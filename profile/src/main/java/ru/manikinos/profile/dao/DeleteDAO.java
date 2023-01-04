package ru.manikinos.profile.dao;

import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDAO {
    Connection connection = Connections.getConnection();

    public DeleteDAO() throws SQLException, ClassNotFoundException {
    }

    public void deleteType(String id) {
        final String DELETE_TYPE_QUERY = "DELETE FROM Type WHERE id = ?;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TYPE_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
