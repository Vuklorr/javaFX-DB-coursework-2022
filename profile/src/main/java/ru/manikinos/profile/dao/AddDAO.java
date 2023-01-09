package ru.manikinos.profile.dao;

import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDAO {
    private final Connection connection = Connections.getConnection();

    public AddDAO() throws SQLException, ClassNotFoundException {
    }

    public void addAddress(String id,
                           String country,
                           String city,
                           String region,
                           String street,
                           String house,
                           String flat)  {
        final String ADD_ADDRESS_QUERY = "INSERT INTO Address (id, country, city, region, street, house, flat) VALUES (?, ?, ?, ?, ?, ?, ?);\n";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_ADDRESS_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, country);
            preparedStatement.setString(3, city);
            preparedStatement.setString(4, region);
            preparedStatement.setString(5, street);
            preparedStatement.setString(6, house);
            preparedStatement.setInt(7, Integer.parseInt(flat));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void addDocument(String id,
                            String idType,
                            String idPersonalData,
                            String startDate,
                            String endDate) {
        final String ADD_DOCUMENT_QUERY = "INSERT INTO Document (id, id_type, id_personal_data, start_date, END_DATE) VALUES (?, ?, ?, ?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_DOCUMENT_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setInt(2, Integer.parseInt(idType));
            preparedStatement.setInt(3, Integer.parseInt(idPersonalData));
            preparedStatement.setDate(4, Date.valueOf(startDate));
            preparedStatement.setDate(5, Date.valueOf(endDate));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addFamilyRelations(String idFirstPerson, String idSecondPerson, String idTypeOfRelationship) {
        final String ADD_FR_QUERY = "INSERT INTO FAMILY_RELATIONS (id_first_person, id_second_person, id_type_of_relationship) VALUES (?, ?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_FR_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idFirstPerson));
            preparedStatement.setInt(2, Integer.parseInt(idSecondPerson));
            preparedStatement.setInt(3, Integer.parseInt(idTypeOfRelationship));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPersonalData(String id,
                                String idAddress,
                                String name,
                                String patronymic,
                                String surname,
                                String phoneNumber) {
        final String ADD_PD_QUERY = "INSERT INTO Personal_data (id, id_address, name, patronymic, surname, phone_number) VALUES (?, ?, ?, ?, ?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_PD_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setInt(2, Integer.parseInt(idAddress));
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, patronymic);
            preparedStatement.setString(5, surname);
            preparedStatement.setString(6, phoneNumber);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

   public void addType(String id, String name)  {
        final String ADD_TYPE_QUERY = "INSERT INTO Type (id, name) VALUES (?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_TYPE_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
   }

    public void addTypeOfRelationship(String id, String name)  {
        final String ADD_TYPE_QUERY = "INSERT INTO Type_of_relationship (id, name) VALUES (?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_TYPE_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addWorkActivity(String id, String nameCompany, String nameWork, String salary)  {
        final String ADD_WA_QUERY = "INSERT INTO Work_activity (id, name_company, name_work, salary) VALUES (?, ?, ?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_WA_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, nameCompany);
            preparedStatement.setString(3, nameWork);
            preparedStatement.setInt(4, Integer.parseInt(salary));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addWorkActivityPersonal(String idPerson, String idWork, String dateOfHiring, String dateOfDismissal)  {
        final String ADD_WAP_QUERY = "INSERT INTO Work_activity_personal (id_personal_data, id_work, date_of_hiring, date_of_dismissal) VALUES (?, ?, ?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_WAP_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idPerson));
            preparedStatement.setInt(2, Integer.parseInt(idWork));
            preparedStatement.setDate(3, Date.valueOf(dateOfHiring));
            preparedStatement.setDate(4, Date.valueOf(dateOfDismissal));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
