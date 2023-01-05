package ru.manikinos.profile.dao;

import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
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
