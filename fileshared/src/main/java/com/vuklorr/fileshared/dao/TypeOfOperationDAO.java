package com.vuklorr.fileshared.dao;

import com.vuklorr.fileshared.entity.Tag;
import com.vuklorr.fileshared.entity.TypeOfOperation;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TypeOfOperationDAO {
    private final Connection connection = Connections.getConnection();

    public TypeOfOperationDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<TypeOfOperation> getData() {
        ObservableList<TypeOfOperation> typeOfOperations = FXCollections.observableArrayList();
        final String TOO_DATA_QUERY = "SELECT *\n" +
                "FROM TYPE_OF_OPERATION;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(TOO_DATA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                typeOfOperations.add(new TypeOfOperation(id, name));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return typeOfOperations;
    }

    public void addData(String id, String name) {
        final String ADD_TOO_QUERY = "INSERT INTO PUBLIC.TYPE_OF_OPERATION (ID, NAME) VALUES (?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_TOO_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, name);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(String id, String name) {
        final String UPDATE_TOO_QUERY = """
                UPDATE PUBLIC.TYPE_OF_OPERATION t
                SET t.NAME = ?
                WHERE t.ID = ?;""";

        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TOO_QUERY)) {
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
                FROM PUBLIC.TYPE_OF_OPERATION
                WHERE ID = ?;""";
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TAG_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}