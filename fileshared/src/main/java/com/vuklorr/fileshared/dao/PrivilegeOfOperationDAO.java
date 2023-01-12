package com.vuklorr.fileshared.dao;

import com.vuklorr.fileshared.entity.PrivilegeOfOperation;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PrivilegeOfOperationDAO {
    private final Connection connection = Connections.getConnection();

    public PrivilegeOfOperationDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<PrivilegeOfOperation> getData() {
        ObservableList<PrivilegeOfOperation> privilegeOfOperations = FXCollections.observableArrayList();
        final String POO_DATA_QUERY = "SELECT *\n" +
                "FROM PRIVILEGE_OF_OPERATION;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(POO_DATA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idPrivilege = resultSet.getInt(1);
                int idTypeOfOperation = resultSet.getInt(2);
                privilegeOfOperations.add(new PrivilegeOfOperation(idPrivilege, idTypeOfOperation));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return privilegeOfOperations;
    }

    public void addData(String idPrivilege, String idTypeOfOperation) {
        final String ADD_POO_QUERY = "INSERT INTO PUBLIC.PRIVILEGE_OF_OPERATION (ID_PRIVILEGE, ID_TYPE_OF_OPERATION) VALUES (?, ?);\n";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_POO_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idPrivilege));
            preparedStatement.setInt(2, Integer.parseInt(idTypeOfOperation));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(String idPrivilege, String idTypeOfOperation, List<Integer> idPrivilegeTypeOfOperationOld) {
        final String UPDATE_POO_QUERY = """
                UPDATE PUBLIC.PRIVILEGE_OF_OPERATION t
                SET t.ID_PRIVILEGE         = ?,
                    t.ID_TYPE_OF_OPERATION = ?
                WHERE t.ID_PRIVILEGE = ?
                  AND t.ID_TYPE_OF_OPERATION = ?;
                """;

        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_POO_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idPrivilege));
            preparedStatement.setInt(2, Integer.parseInt(idTypeOfOperation));
            preparedStatement.setInt(3, idPrivilegeTypeOfOperationOld.get(0));
            preparedStatement.setInt(4, idPrivilegeTypeOfOperationOld.get(1));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteData(String idPrivilege, String idTypeOfOperation) {
        final String DELETE_POO_QUERY = """
             DELETE
             FROM PUBLIC.PRIVILEGE_OF_OPERATION
             WHERE ID_PRIVILEGE = ?
               AND ID_TYPE_OF_OPERATION = ?;""";
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_POO_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idPrivilege));
            preparedStatement.setInt(2, Integer.parseInt(idTypeOfOperation));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}