package ru.manikinos.profile.dao;

import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ADDRESS_QUERY)) {
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

        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DOCUMENT_QUERY)) {
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

    public void updateType(String id, String name) {
        final String UPDATE_TYPE_QUERY = "UPDATE Type\n" +
                "SET name = ?\n" +
                "WHERE id = ?;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TYPE_QUERY)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
