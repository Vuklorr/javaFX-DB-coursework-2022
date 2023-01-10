package com.vuklorr.fileshared.dao;

import com.vuklorr.fileshared.entity.Privilege;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class PrivilegeDAO {
    private final Connection connection = Connections.getConnection();

    public PrivilegeDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<Privilege> getData() {
        ObservableList<Privilege> privileges = FXCollections.observableArrayList();
        final String PRIVILEGE_DATA_QUERY = "SELECT *\n" +
                "FROM PRIVILEGE;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(PRIVILEGE_DATA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int idClient = resultSet.getInt(2);
                int idFile = resultSet.getInt(3);
                privileges.add(new Privilege(id, idClient, idFile));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return privileges;
    }

    public void addData(String id, String idClient, String idFile) {
        final String ADD_PRIVILEGE_QUERY = "INSERT INTO PUBLIC.PRIVILEGE (ID, ID_CLIENT, ID_FILE) VALUES (?, ?, ?);\n";
        executeQuery(id, idClient, idFile, ADD_PRIVILEGE_QUERY);
    }

    public void updateData(String id, String idClient, String idFile) {
        final String UPDATE_PRIVILEGE_QUERY = """
                UPDATE PUBLIC.PRIVILEGE t
                SET t.ID_CLIENT = ?,
                    t.ID_FILE   = ?
                WHERE t.ID = ?;
                """;

        executeQuery(idClient, idFile, id, UPDATE_PRIVILEGE_QUERY);
    }

    public void deleteData(String id) {
        final String DELETE_PRIVILEGE_QUERY = """
                DELETE
                FROM PUBLIC.PRIVILEGE
                WHERE ID = ?;""";
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRIVILEGE_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void executeQuery(String id, String idClient, String idFile, String UPDATE_PRIVILEGE_QUERY) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRIVILEGE_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setInt(2, Integer.parseInt(idClient));
            preparedStatement.setInt(3, Integer.parseInt(idFile));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}