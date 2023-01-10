package com.vuklorr.fileshared.dao;

import com.vuklorr.fileshared.entity.HistoryOfOperation;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class HistoryOfOperationDAO {
    private final Connection connection = Connections.getConnection();

    public HistoryOfOperationDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<HistoryOfOperation> getData() {
        ObservableList<HistoryOfOperation> historyOfOperations = FXCollections.observableArrayList();
        final String HOO_DATA_QUERY = "SELECT *\n" +
                "FROM HISTORY_OF_OPERATION;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(HOO_DATA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int idTypeOfOperation = resultSet.getInt(2);
                int idClient = resultSet.getInt(3);
                int idFile = resultSet.getInt(4);
                LocalDate dateOfOperation = resultSet.getDate(5).toLocalDate();

                historyOfOperations.add(new HistoryOfOperation(id, idTypeOfOperation, idClient, idFile, dateOfOperation));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return historyOfOperations;
    }

    public void addData(String id, String idTypeOfOperation, String idClient, String idFile, String dateOfOperation) {
        final String ADD_HOO_QUERY = "INSERT INTO PUBLIC.HISTORY_OF_OPERATION (ID, ID_TYPE_OF_OPERATION, ID_CLIENT, ID_FILE, DATE_OF_OPERATION) VALUES (?, ?, ?, ?, ?);\n";
        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_HOO_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setInt(2, Integer.parseInt(idTypeOfOperation));
            preparedStatement.setInt(3, Integer.parseInt(idClient));
            preparedStatement.setInt(4, Integer.parseInt(idFile));
            preparedStatement.setDate(5, Date.valueOf(dateOfOperation));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(String id, String idTypeOfOperation, String idClient, String idFile, String dateOfOperation) {
        final String UPDATE_HOO_QUERY = """
                UPDATE PUBLIC.HISTORY_OF_OPERATION t
                SET t.ID_TYPE_OF_OPERATION = ?,
                    t.ID_CLIENT            = ?,
                    t.ID_FILE              = ?,
                    t.DATE_OF_OPERATION    = ?
                WHERE t.ID = ?;
                """;

        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HOO_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idTypeOfOperation));
            preparedStatement.setInt(2, Integer.parseInt(idClient));
            preparedStatement.setInt(3, Integer.parseInt(idFile));
            preparedStatement.setDate(4, Date.valueOf(dateOfOperation));
            preparedStatement.setInt(5, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteData(String id) {
        final String DELETE_CLIENT_QUERY = """
                DELETE
                FROM PUBLIC.HISTORY_OF_OPERATION
                WHERE ID = ?;""";
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}