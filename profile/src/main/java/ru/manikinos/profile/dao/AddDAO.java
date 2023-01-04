package ru.manikinos.profile.dao;

import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDAO {
    private Connection connection = Connections.getConnection();

    public AddDAO() throws SQLException, ClassNotFoundException {
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
