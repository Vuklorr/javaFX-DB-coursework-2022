package com.vuklorr.fileshared.dao.query;

import com.vuklorr.fileshared.entity.query.TopThreeMostAccessibleFiles;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TopThreeMostAccessibleFilesDAO {
    Connection connection = Connections.getConnection();

    public TopThreeMostAccessibleFilesDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<TopThreeMostAccessibleFiles> getData() {
        ObservableList<TopThreeMostAccessibleFiles> files = FXCollections.observableArrayList();
        final String TOP_FILES_DATA_QUERY = """
                SELECT P.ID_FILE, F.NAME,COUNT(P.ID_FILE) AS count
                FROM PRIVILEGE P
                INNER JOIN FILE F on F.ID = P.ID_FILE
                GROUP BY P.ID_FILE
                ORDER BY count DESC
                LIMIT 3;
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(TOP_FILES_DATA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idFile = resultSet.getInt(1);
                String nameFile = resultSet.getString(2);
                int countClient = resultSet.getInt(3);

                files.add(new TopThreeMostAccessibleFiles(idFile, nameFile, countClient));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return files;
    }
}