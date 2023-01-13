package com.vuklorr.fileshared.dao;

import com.vuklorr.fileshared.entity.Client;
import com.vuklorr.fileshared.util.Connections;
import com.vuklorr.fileshared.util.DuplicateQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO {
    private final Connection connection = Connections.getConnection();

    public ClientDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<Client> getData() {
        ObservableList<Client> clients = FXCollections.observableArrayList();
        final String CLIENT_DATA_QUERY = "SELECT *\n" +
                "FROM CLIENT;";

        DuplicateQuery.getClients(clients, CLIENT_DATA_QUERY, connection);
        return clients;
    }

    public void addData(String id, String name, String patronymic, String surname) {
        final String ADD_CLIENT_QUERY = "INSERT INTO PUBLIC.CLIENT (ID, NAME, PATRONYMIC, SURNAME) VALUES (?, ?, ?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_CLIENT_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, patronymic);
            preparedStatement.setString(4, surname);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(String id, String name, String patronymic, String surname) {
        final String UPDATE_CLIENT_QUERY = """
                UPDATE PUBLIC.CLIENT t
                SET t.NAME       = ?,
                    t.PATRONYMIC = ?,
                    t.SURNAME    = ?
                WHERE t.ID = ?;""";

        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_QUERY)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, patronymic);
            preparedStatement.setString(3, surname);
            preparedStatement.setInt(4, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteData(String id) {
        final String DELETE_CLIENT_QUERY = """
                DELETE
                FROM PUBLIC.CLIENT
                WHERE ID = ?;""";
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}