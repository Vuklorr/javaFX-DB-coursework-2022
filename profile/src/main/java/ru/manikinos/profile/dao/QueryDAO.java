package ru.manikinos.profile.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.manikinos.profile.entity.query.*;
import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class QueryDAO {
    private final Connection connection = Connections.getConnection();

    public QueryDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<AllWorks> getListAllWorks(String id) {
        ObservableList<AllWorks> allWorks = FXCollections.observableArrayList();
        final String GET_LIST_ALL_WORKS_QUERY = "SELECT wa.name_company, wa.name_work, wa.salary, DATEDIFF(hour, wap.date_of_hiring, wap.date_of_dismissal) AS \"Отработанные часы\"\n" +
                "FROM Work_activity wa\n" +
                "         INNER JOIN Work_activity_personal wap ON wap.id_work = wa.id\n" +
                "WHERE wap.id_personal_data = ?;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_ALL_WORKS_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nameCompany = resultSet.getString(1);
                String nameWork = resultSet.getString(2);
                int salary = resultSet.getInt(3);
                int workExperience = resultSet.getInt(4);

                allWorks.add(new AllWorks(nameCompany, nameWork, salary, workExperience));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allWorks;
    }

    public ObservableList<AllDocuments> getListAllDocuments(String id) {
        ObservableList<AllDocuments> allDocuments = FXCollections.observableArrayList();
        final String GET_LIST_ALL_DOCUMENTS_QUERY = "SELECT t.name, COUNT(d.id_type)\n" +
                "FROM Document d\n" +
                "INNER JOIN Type t ON d.id_type = t.id\n" +
                "WHERE d.id_personal_data = ?\n" +
                "GROUP BY d.id_type;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_ALL_DOCUMENTS_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nameDocuments = resultSet.getString(1);
                int countDocument = resultSet.getInt(2);

                allDocuments.add(new AllDocuments(nameDocuments, countDocument));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return allDocuments;
    }

    //FIXME cleanup
    public NearestPerson getNearestPerson(String country, String city, String region, String street, String house, String idAddress, String flatText) throws SQLException {
        List<NearestPerson> persons = new ArrayList<>();
        NearestPerson person = new NearestPerson();

        final String GET_NEAREST_PERSON_HOUSE_QUERY = "SELECT  pd.id, pd.name, pd.patronymic, pd.surname, a.flat\n" +
                "FROM Personal_data pd\n" +
                "         INNER JOIN Address A on A.id = pd.id_address\n" +
                "WHERE a.country = ? AND\n" +
                "        a.city = ? AND\n" +
                "        a.region = ? AND\n" +
                "        a.street = ? AND\n" +
                "        a.house = ? AND\n" +
                "        a.id != ?;";

        try (PreparedStatement preparedStatementHouse = connection.prepareStatement(GET_NEAREST_PERSON_HOUSE_QUERY)) {
            preparedStatementHouse.setString(1, country);
            preparedStatementHouse.setString(2, city);
            preparedStatementHouse.setString(3, region);
            preparedStatementHouse.setString(4, street);
            preparedStatementHouse.setString(5, house);
            preparedStatementHouse.setInt(6, Integer.parseInt(idAddress));

            queryForNearestPerson(persons, preparedStatementHouse);

            if (persons.isEmpty()) {
                final String GET_NEAREST_PERSON_STREET_QUERY = "SELECT  pd.id, pd.name, pd.patronymic, pd.surname, a.flat\n" +
                        "FROM Personal_data pd\n" +
                        "         INNER JOIN Address A on A.id = pd.id_address\n" +
                        "WHERE a.country = ? AND\n" +
                        "        a.city = ? AND\n" +
                        "        a.region = ? AND\n" +
                        "        a.street = ? AND\n" +
                        "        a.id != ?";

                try (PreparedStatement preparedStatementStreet = connection.prepareStatement(GET_NEAREST_PERSON_STREET_QUERY)) {
                    preparedStatementStreet.setString(1, country);
                    preparedStatementStreet.setString(2, city);
                    preparedStatementStreet.setString(3, region);
                    preparedStatementStreet.setString(4, street);
                    preparedStatementStreet.setInt(5, Integer.parseInt(idAddress));

                    queryForNearestPerson(persons, preparedStatementStreet);
                }

                if(persons.isEmpty()) {
                    final String GET_NEAREST_PERSON_REGION_QUERY = "SELECT  pd.id, pd.name, pd.patronymic, pd.surname, a.flat\n" +
                            "FROM Personal_data pd\n" +
                            "         INNER JOIN Address A on A.id = pd.id_address\n" +
                            "WHERE a.country = ? AND\n" +
                            "        a.city = ? AND\n" +
                            "        a.region = ? AND\n" +
                            "        a.id != ?";

                    try (PreparedStatement preparedStatementRegion = connection.prepareStatement(GET_NEAREST_PERSON_REGION_QUERY)) {
                        preparedStatementRegion.setString(1, country);
                        preparedStatementRegion.setString(2, city);
                        preparedStatementRegion.setString(3, region);
                        preparedStatementRegion.setInt(4, Integer.parseInt(idAddress));

                        queryForNearestPerson(persons, preparedStatementRegion);
                    }

                    if(persons.isEmpty()) {
                        final String GET_NEAREST_PERSON_CITY_QUERY = "SELECT  pd.id, pd.name, pd.patronymic, pd.surname, a.flat\n" +
                                "FROM Personal_data pd\n" +
                                "         INNER JOIN Address A on A.id = pd.id_address\n" +
                                "WHERE a.country = ? AND\n" +
                                "        a.city = ? AND\n" +
                                "        a.id != ?";

                        try (PreparedStatement preparedStatementCity = connection.prepareStatement(GET_NEAREST_PERSON_CITY_QUERY)) {
                            preparedStatementCity.setString(1, country);
                            preparedStatementCity.setString(2, city);
                            preparedStatementCity.setInt(3, Integer.parseInt(idAddress));

                            queryForNearestPerson(persons, preparedStatementCity);
                        }

                        if(persons.isEmpty()) {
                            final String GET_NEAREST_PERSON_COUNTRY_QUERY = "SELECT  pd.id, pd.name, pd.patronymic, pd.surname, a.flat\n" +
                                    "FROM Personal_data pd\n" +
                                    "         INNER JOIN Address A on A.id = pd.id_address\n" +
                                    "WHERE a.country = ? AND\n" +
                                    "        a.id != ?";

                            try (PreparedStatement preparedStatementCountry = connection.prepareStatement(GET_NEAREST_PERSON_COUNTRY_QUERY)) {
                                preparedStatementCountry.setString(1, country);
                                preparedStatementCountry.setInt(2, Integer.parseInt(idAddress));

                                queryForNearestPerson(persons, preparedStatementCountry);
                            }
                            if(persons.isEmpty()) {
                                final String GET_NEAREST_PERSON_QUERY = "SELECT  pd.id, pd.name, pd.patronymic, pd.surname, a.flat\n" +
                                        "FROM Personal_data pd\n" +
                                        "         INNER JOIN Address A on A.id = pd.id_address\n" +
                                        "WHERE a.id != ?\n";

                                try (PreparedStatement preparedStatement = connection.prepareStatement(GET_NEAREST_PERSON_QUERY)) {
                                    preparedStatement.setInt(1, Integer.parseInt(idAddress));

                                    queryForNearestPerson(persons, preparedStatement);
                                }
                            }
                        }
                    }
                }
                person = persons.get(0);
            } else {
                int min = 100000;

                int flat = Integer.parseInt(flatText);
                for(NearestPerson np : persons) {
                    if(Math.abs(np.getFlat() - flat) < min) {
                        min = Math.abs(np.getFlat() - flat);
                        person = np;
                    }
                }
            }

            return person;
        }
    }

    public ObservableList<Recruit> getListRecruit() {
        ObservableList<Recruit> recruits = FXCollections.observableArrayList();
        final String GET_LIST_RECRUIT_QUERY = "SELECT pd.name, pd.patronymic, pd.surname, d.start_date\n" +
                "FROM Personal_data pd\n" +
                "         INNER JOIN Document d ON d.id_personal_data = pd.id\n" +
                "WHERE d.id_type = 7 AND\n" +
                "        d.start_date > CURRENT_DATE AND\n" +
                "        d.start_date < DATEADD(year, 1 ,CURRENT_DATE);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_LIST_RECRUIT_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString(1);
                String patronymic = resultSet.getString(2);
                String surname = resultSet.getString(3);
                LocalDate dateRecruit = resultSet.getDate(4).toLocalDate();

                recruits.add(new Recruit(name, patronymic, surname, dateRecruit));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return recruits;
    }

    public ObservableList<PrivateContact> getPrivateContact(String id) {
        ObservableList<PrivateContact> contacts = FXCollections.observableArrayList();
        final String GET_PRIVATE_CONTACT_QUERY = "SELECT pd1.surname, pd1.phone_number,pd2.surname, pd2.phone_number\n" +
                "FROM FAMILY_RELATIONS fr\n" +
                "         INNER JOIN PERSONAL_DATA pd1 ON pd1.id = fr.id_first_person\n" +
                "         INNER JOIN PERSONAL_DATA pd2 ON pd2.id = fr.id_second_person\n" +
                "WHERE pd1.id = ?;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_PRIVATE_CONTACT_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String namePerson = resultSet.getString(1);
                String phoneNumberPerson = resultSet.getString(2);
                String nameRelative = resultSet.getString(3);
                String phoneNumberRelative = resultSet.getString(4);

                contacts.add(new PrivateContact(namePerson, phoneNumberPerson, nameRelative, phoneNumberRelative));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contacts;
    }

    private void queryForNearestPerson(List<NearestPerson> persons, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSetStreet = preparedStatement.executeQuery();

        while (resultSetStreet.next()) {
            int id = resultSetStreet.getInt(1);
            String name = resultSetStreet.getString(2);
            String patronymic = resultSetStreet.getString(3);
            String surname = resultSetStreet.getString(4);
            int flat = resultSetStreet.getInt(5);

            persons.add(new NearestPerson(id, name, patronymic, surname, flat));
        }
    }
}
