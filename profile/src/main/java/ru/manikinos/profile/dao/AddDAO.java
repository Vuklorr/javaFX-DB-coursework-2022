package ru.manikinos.profile.dao;

import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
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
        final String ADD_TYPE_QUERY = "INSERT INTO Address (id, country, city, region, street, house, flat) VALUES (?, ?, ?, ?, ?, ?, ?);\n";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_TYPE_QUERY)) {
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
