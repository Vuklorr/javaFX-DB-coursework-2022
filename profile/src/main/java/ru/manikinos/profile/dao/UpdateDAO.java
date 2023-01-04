package ru.manikinos.profile.dao;

import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDAO {
    Connection connection = Connections.getConnection();

    public UpdateDAO() throws SQLException, ClassNotFoundException {
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
