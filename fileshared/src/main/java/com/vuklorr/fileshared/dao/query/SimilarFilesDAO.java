package com.vuklorr.fileshared.dao.query;

import com.vuklorr.fileshared.dao.FileDAO;
import com.vuklorr.fileshared.entity.File;
import com.vuklorr.fileshared.util.Connections;
import com.vuklorr.fileshared.util.DuplicateQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SimilarFilesDAO {
    private final Connection connection = Connections.getConnection();

    public SimilarFilesDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<File> getFileData() {
        try {
            FileDAO fileDAO = new FileDAO();
            return fileDAO.getData();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<File> searchFile(String name, String path, String size) {
        ObservableList<File> files = FXCollections.observableArrayList();
        final String FILE_DATA_QUERY = "SELECT *\n" +
                "FROM FILE F\n" +
                "WHERE NAME LIKE '%" + name + "%' AND\n" +
                "      PATH LIKE '%" + path + "%' AND\n" +
                "      SIZE  LIKE '%" + size + "%';";
        try(PreparedStatement preparedStatement = connection.prepareStatement(FILE_DATA_QUERY)) {
            DuplicateQuery.getFiles(files, preparedStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return files;
    }
}