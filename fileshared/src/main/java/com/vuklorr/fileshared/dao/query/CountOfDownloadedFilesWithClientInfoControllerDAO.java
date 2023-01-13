package com.vuklorr.fileshared.dao.query;

import com.vuklorr.fileshared.entity.Client;
import com.vuklorr.fileshared.util.Connections;
import com.vuklorr.fileshared.util.DuplicateQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CountOfDownloadedFilesWithClientInfoControllerDAO {
    Connection connection = Connections.getConnection();

    public CountOfDownloadedFilesWithClientInfoControllerDAO() throws SQLException, ClassNotFoundException {
    }

    public int countOfDownloadedFiles() {
        final String COUNT_OF_DOWNLOADED_FILES_QUERY = """
                SELECT COUNT(TOO.NAME)
                FROM HISTORY_OF_OPERATION HOP
                INNER JOIN TYPE_OF_OPERATION TOO on TOO.ID = HOP.ID_TYPE_OF_OPERATION
                WHERE TOO.NAME = 'Скачать'
                GROUP BY TOO.NAME;
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(COUNT_OF_DOWNLOADED_FILES_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public ObservableList<Client> getClientData() {
        ObservableList<Client> clients = FXCollections.observableArrayList();
        final String CLIENT_DATA_QUERY = """
                SELECT C.ID, C.NAME, C.PATRONYMIC, C.SURNAME
                FROM HISTORY_OF_OPERATION HOP
                INNER JOIN TYPE_OF_OPERATION TOO on TOO.ID = HOP.ID_TYPE_OF_OPERATION
                INNER JOIN CLIENT C on C.ID = HOP.ID_CLIENT
                WHERE TOO.NAME = 'Скачать';
                """;
        DuplicateQuery.getClients(clients, CLIENT_DATA_QUERY, connection);
        return clients;
    }
}