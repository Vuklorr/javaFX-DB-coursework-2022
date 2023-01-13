package com.vuklorr.fileshared.dao;

import com.vuklorr.fileshared.entity.File;
import com.vuklorr.fileshared.util.Connections;
import com.vuklorr.fileshared.util.DuplicateQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FileDAO {
    private final Connection connection = Connections.getConnection();

    public FileDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<File> getData() {
        ObservableList<File> files = FXCollections.observableArrayList();
        final String FILE_DATA_QUERY = "SELECT *\n" +
                "FROM FILE;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(FILE_DATA_QUERY)) {
            preparedStatement.executeQuery();
            DuplicateQuery.getFiles(files, preparedStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return files;
    }

    public void addData(String id, String name, String path, String size) {
        final String ADD_FILE_QUERY = "INSERT INTO PUBLIC.FILE (ID, NAME, PATH, SIZE) VALUES (?, ?, ?, ?);";

        try(PreparedStatement preparedStatement = connection.prepareStatement(ADD_FILE_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, path);
            preparedStatement.setInt(4, Integer.parseInt(size));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateData(String id, String name, String path, String size) {
        final String UPDATE_FILE_QUERY = """
                UPDATE PUBLIC.FILE t
                SET t.NAME       = ?,
                    t.PATH       = ?,
                    t.SIZE       = ?
                WHERE t.ID = ?;""";

        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FILE_QUERY)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, path);
            preparedStatement.setInt(3, Integer.parseInt(size));
            preparedStatement.setInt(4, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteData(String id) {
        final String DELETE_FILE_QUERY = """
                DELETE
                FROM PUBLIC.FILE
                WHERE ID = ?;""";
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FILE_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
