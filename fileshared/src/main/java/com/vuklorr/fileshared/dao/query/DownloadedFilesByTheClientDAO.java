package com.vuklorr.fileshared.dao.query;

import com.vuklorr.fileshared.entity.File;
import com.vuklorr.fileshared.util.Connections;
import com.vuklorr.fileshared.util.DuplicateQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DownloadedFilesByTheClientDAO {
    Connection connection = Connections.getConnection();

    public DownloadedFilesByTheClientDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<File> getData(String idClient) {
        ObservableList<File> files = FXCollections.observableArrayList();
        final String DOWNLOADED_FILES_DATA_QUERY = """
                SELECT F.ID, F.NAME, F.PATH, F.SIZE
                FROM PRIVILEGE P
                INNER JOIN FILE F on P.ID_FILE = F.ID
                INNER JOIN CLIENT C on C.ID = P.ID_CLIENT
                WHERE C.ID = ?;
                """;

        try(PreparedStatement preparedStatement = connection.prepareStatement(DOWNLOADED_FILES_DATA_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idClient));
            preparedStatement.executeQuery();

            DuplicateQuery.getFiles(files, preparedStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return files;
    }
}