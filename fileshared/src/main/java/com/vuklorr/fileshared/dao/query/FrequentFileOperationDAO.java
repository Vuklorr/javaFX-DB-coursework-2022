package com.vuklorr.fileshared.dao.query;

import com.vuklorr.fileshared.entity.query.FrequentFileOperation;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FrequentFileOperationDAO {
    Connection connection = Connections.getConnection();

    public FrequentFileOperationDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<FrequentFileOperation> getData() {
        ObservableList<FrequentFileOperation> operations = FXCollections.observableArrayList();
        final String OPERATION_DATA_QUERY = """
                SELECT TOO.NAME, COUNT(TOO.NAME) AS count
                FROM HISTORY_OF_OPERATION HOP
                INNER JOIN TYPE_OF_OPERATION TOO on TOO.ID = HOP.ID_TYPE_OF_OPERATION
                GROUP BY TOO.NAME
                ORDER BY count DESC
                LIMIT 2;
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(OPERATION_DATA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nameOperation = resultSet.getString(1);
                int countOperation = resultSet.getInt(2);

                operations.add(new FrequentFileOperation(nameOperation, countOperation));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return operations;
    }
}