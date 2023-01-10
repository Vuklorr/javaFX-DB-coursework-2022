package com.vuklorr.fileshared.dao;

import com.vuklorr.fileshared.entity.Tag;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TagDAO {
    private final Connection connection = Connections.getConnection();

    public TagDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<Tag> getData() {
        ObservableList<Tag> tags = FXCollections.observableArrayList();
        final String TAG_DATA_QUERY = "SELECT *\n" +
                "FROM TAG;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(TAG_DATA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                tags.add(new Tag(id, name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tags;
    }

    public void addData(String id, String name) {
        final String ADD_TAG_QUERY = "INSERT INTO PUBLIC.TAG (ID, NAME) VALUES (?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_TAG_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(String id, String name) {
        final String UPDATE_TAG_QUERY = """
                UPDATE PUBLIC.TAG t
                SET t.NAME = ?
                WHERE t.ID = ?;""";

        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TAG_QUERY)) {
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteData(String id) {
        final String DELETE_TAG_QUERY = """
                DELETE
                FROM PUBLIC.TAG
                WHERE ID = ?;""";
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TAG_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
