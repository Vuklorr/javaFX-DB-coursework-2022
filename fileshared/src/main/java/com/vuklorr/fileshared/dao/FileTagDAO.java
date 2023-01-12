package com.vuklorr.fileshared.dao;

import com.vuklorr.fileshared.entity.FileTag;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FileTagDAO {
    private final Connection connection = Connections.getConnection();

    public FileTagDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<FileTag> getData() {
        ObservableList<FileTag> fileTags = FXCollections.observableArrayList();
        final String FILE_TAG_DATA_QUERY = "SELECT *\n" +
                "FROM FILE_TAG;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(FILE_TAG_DATA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idFile = resultSet.getInt(1);
                int idTag = resultSet.getInt(2);

                fileTags.add(new FileTag(idFile, idTag));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return fileTags;
    }

    public void addData(String idFile, String idTag) {
        final String ADD_FILE_TAG_QUERY = "INSERT INTO PUBLIC.FILE_TAG (ID_FILE, ID_TAG) VALUES (?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_FILE_TAG_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idFile));
            preparedStatement.setInt(2, Integer.parseInt(idTag));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(String idFile, String idTag, List<Integer> idFileTagOld) {
        final String UPDATE_FILE_TAG_QUERY = """
                UPDATE PUBLIC.FILE_TAG t
                SET t.ID_FILE   = ?,
                    t.ID_TAG    = ?
                WHERE t.ID_FILE = ?
                  AND t.ID_TAG  = ?;
                """;

        executeQuery(idFile, idTag, idFileTagOld, UPDATE_FILE_TAG_QUERY, connection);
    }

    public static void executeQuery(String idFirst, String idSecond, List<Integer> idFirstSecond, String QUERY, Connection connection) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idFirst));
            preparedStatement.setInt(2, Integer.parseInt(idSecond));
            preparedStatement.setInt(3, idFirstSecond.get(0));
            preparedStatement.setInt(4, idFirstSecond.get(1));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteData(String idFile, String idTag) {
        final String DELETE_FILE_TAG_QUERY = """
             DELETE
             FROM PUBLIC.FILE_TAG
             WHERE ID_FILE  = ?
               AND ID_TAG = ?;""";
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FILE_TAG_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idFile));
            preparedStatement.setInt(2, Integer.parseInt(idTag));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}