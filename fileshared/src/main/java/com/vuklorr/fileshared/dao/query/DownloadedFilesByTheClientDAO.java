package com.vuklorr.fileshared.dao.query;

import com.vuklorr.fileshared.entity.File;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String path = resultSet.getString(3);
                int size = resultSet.getInt(4);

                files.add(new File(id, name, path, size));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return files;
    }
}