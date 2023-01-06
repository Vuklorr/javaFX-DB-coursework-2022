package ru.manikinos.profile.dao;

import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UpdateDAO {
    Connection connection = Connections.getConnection();

    public UpdateDAO() throws SQLException, ClassNotFoundException {
    }

    public void updateAddress(String id,
                              String country,
                              String city,
                              String region,
                              String street,
                              String house,
                              String flat) {
        final String UPDATE_ADDRESS_QUERY = "UPDATE Address\n" +
                "SET country = ?,\n" +
                "    city = ?,\n" +
                "    region = ?,\n" +
                "    street = ?,\n" +
                "    house = ?,\n" +
                "    flat = ?\n" +
                "WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADDRESS_QUERY)) {
            preparedStatement.setString(1, country);
            preparedStatement.setString(2, city);
            preparedStatement.setString(3, region);
            preparedStatement.setString(4, street);
            preparedStatement.setString(5, house);
            preparedStatement.setInt(6, Integer.parseInt(flat));
            preparedStatement.setInt(7, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateDocument(String id,
                               String idType,
                               String idPersonalData,
                               String startDate,
                               String endDate) {
        final String UPDATE_DOCUMENT_QUERY = "UPDATE Document\n" +
                "SET id_type = ?,\n" +
                "    id_personal_data = ?,\n" +
                "    start_date = ?,\n" +
                "    end_date = ?\n" +
                "WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCUMENT_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idType));
            preparedStatement.setInt(2, Integer.parseInt(idPersonalData));
            preparedStatement.setDate(3, Date.valueOf(startDate));
            preparedStatement.setDate(4, Date.valueOf(endDate));
            preparedStatement.setInt(5, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateFamilyRelations(String idFirstPerson, String idSecondPerson, String idTypeOfRelationship, List<String> firstSecondOldER) {
        final String UPDATE_FR_QUERY = "UPDATE FAMILY_RELATIONS t\n" +
                "SET t.ID_FIRST_PERSON         = ?,\n" +
                "    t.ID_SECOND_PERSON        = ?,\n" +
                "    t.ID_TYPE_OF_RELATIONSHIP = ?\n" +
                "WHERE t.ID_FIRST_PERSON = ?\n" +
                "  AND t.ID_SECOND_PERSON = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FR_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idFirstPerson));
            preparedStatement.setInt(2, Integer.parseInt(idSecondPerson));
            preparedStatement.setInt(3, Integer.parseInt(idTypeOfRelationship));
            preparedStatement.setInt(4, Integer.parseInt(firstSecondOldER.get(0)));
            preparedStatement.setInt(5, Integer.parseInt(firstSecondOldER.get(1)));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updatePersonalData(String id,
                                   String idAddress,
                                   String name,
                                   String patronymic,
                                   String surname,
                                   String phoneNumber) {
        final String UPDATE_PD_QUERY = "UPDATE Personal_data\n" +
                "SET id_address = ?,\n" +
                "    name = ?,\n" +
                "    patronymic = ?,\n" +
                "    surname = ?,\n" +
                "    phone_number = ?\n" +
                "WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PD_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idAddress));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, patronymic);
            preparedStatement.setString(4, surname);
            preparedStatement.setString(5, phoneNumber);
            preparedStatement.setInt(6, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateType(String id, String name) {
        final String UPDATE_TYPE_QUERY = "UPDATE Type\n" +
                "SET name = ?\n" +
                "WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TYPE_QUERY)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateTypeOfRelationship(String id, String name) {
        final String UPDATE_TYPE_QUERY = "UPDATE Type_of_relationship\n" +
                "SET name = ?\n" +
                "WHERE id = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TYPE_QUERY)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateWorkActivity(String id,
                                   String nameCompany,
                                   String nameWork,
                                   String salary) {
        final String UPDATE_WA_QUERY = "UPDATE Work_activity\n" +
                "SET name_company = ?,\n" +
                "    name_work = ?,\n" +
                "    salary = ?\n" +
                "WHERE id = ?;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_WA_QUERY)) {
            preparedStatement.setString(1, nameCompany);
            preparedStatement.setString(2, nameWork);
            preparedStatement.setInt(3, Integer.parseInt(salary));
            preparedStatement.setInt(4, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateWorkActivityPersonal(String idPerson, String idWork, String dateOfHiring, String dateOfDismissal, List<String> personWorkOldWAP) {
        final String UPDATE_WAP_QUERY = "UPDATE work_activity_personal\n" +
                "SET id_personal_data = ?,\n" +
                "    id_work = ?,\n" +
                "    date_of_hiring = ?,\n" +
                "    date_of_dismissal = ?\n" +
                "WHERE id_personal_data = ?\n" +
                "  AND id_work = ?;";

        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_WAP_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idPerson));
            preparedStatement.setInt(2, Integer.parseInt(idWork));
            preparedStatement.setDate(3, Date.valueOf(dateOfHiring));
            preparedStatement.setDate(4, Date.valueOf(dateOfDismissal));
            preparedStatement.setInt(5, Integer.parseInt(personWorkOldWAP.get(0)));
            preparedStatement.setInt(6, Integer.parseInt(personWorkOldWAP.get(1)));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}