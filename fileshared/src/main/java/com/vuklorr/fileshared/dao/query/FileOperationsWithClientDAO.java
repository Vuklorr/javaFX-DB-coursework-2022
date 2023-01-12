package com.vuklorr.fileshared.dao.query;

import com.vuklorr.fileshared.entity.query.FileOperationsWithClient;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FileOperationsWithClientDAO {
    private final Connection connection = Connections.getConnection();

    public FileOperationsWithClientDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<FileOperationsWithClient> getData(String idFile) {
        ObservableList<FileOperationsWithClient> operations = FXCollections.observableArrayList();
        final String FILE_OPERATION_DATA_QUERY = """
                SELECT TOO.NAME, C.NAME, C.PATRONYMIC, C.SURNAME
                FROM HISTORY_OF_OPERATION HOP
                INNER JOIN CLIENT C on C.ID = HOP.ID_CLIENT
                INNER JOIN TYPE_OF_OPERATION TOO on TOO.ID = HOP.ID_TYPE_OF_OPERATION
                WHERE HOP.ID_FILE = ?;
                """;

        try(PreparedStatement preparedStatement = connection.prepareStatement(FILE_OPERATION_DATA_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idFile));

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                String nameOperation = resultSet.getString(1);
                String nameClient = resultSet.getString(2);
                String patronymicClient = resultSet.getString(3);
                String surnameClient = resultSet.getString(4);

                operations.add(new FileOperationsWithClient(nameOperation, nameClient, patronymicClient, surnameClient));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return operations;
    }
}