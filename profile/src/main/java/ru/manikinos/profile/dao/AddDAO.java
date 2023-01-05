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

    public void addPersonalData(String id,
                                String idAddress,
                                String idRelative,
                                String idWork,
                                String name,
                                String patronymic,
                                String surname,
                                String phoneNumber) {
        final String ADD_PD_QUERY = "INSERT INTO Personal_data (id, id_address, id_relative, id_work, name, patronymic, surname, phone_number) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_PD_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setInt(2, Integer.parseInt(idAddress));
            preparedStatement.setInt(3, Integer.parseInt(idRelative));
            preparedStatement.setInt(4, Integer.parseInt(idWork));
            preparedStatement.setString(5, name);
            preparedStatement.setString(6, patronymic);
            preparedStatement.setString(7, surname);
            preparedStatement.setString(8, phoneNumber);

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
}
