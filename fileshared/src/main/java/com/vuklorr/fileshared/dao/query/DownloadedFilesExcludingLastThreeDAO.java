package com.vuklorr.fileshared.dao.query;

import com.vuklorr.fileshared.entity.query.DownloadedFilesExcludingLastThree;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DownloadedFilesExcludingLastThreeDAO {
    Connection connection = Connections.getConnection();

    public DownloadedFilesExcludingLastThreeDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<DownloadedFilesExcludingLastThree> getData() {
        ObservableList<DownloadedFilesExcludingLastThree> files = FXCollections.observableArrayList();
        final String DOWNLOADED_FILES_DATA_QUERY = """
                SELECT F.ID, F.NAME, F.PATH, F.SIZE, HOP.DATE_OF_OPERATION
                FROM HISTORY_OF_OPERATION HOP
                INNER JOIN FILE F on F.ID = HOP.ID_FILE
                INNER JOIN TYPE_OF_OPERATION TOO on TOO.ID = HOP.ID_TYPE_OF_OPERATION
                WHERE TOO.NAME = 'Скачать'
                ORDER BY HOP.DATE_OF_OPERATION
                    OFFSET 3;
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(DOWNLOADED_FILES_DATA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String path = resultSet.getString(3);
                int size = resultSet.getInt(4);
                LocalDate dateOfOperation = resultSet.getDate(5)
                        .toLocalDate();

                files.add(new DownloadedFilesExcludingLastThree(id, name, path, size, dateOfOperation));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return files;
    }
}