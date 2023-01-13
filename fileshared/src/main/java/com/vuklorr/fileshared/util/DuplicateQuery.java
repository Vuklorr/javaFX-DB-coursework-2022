package com.vuklorr.fileshared.util;

import com.vuklorr.fileshared.entity.Client;
import com.vuklorr.fileshared.entity.File;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DuplicateQuery {
    public static void getClients(ObservableList<Client> clients,
                                                    String CLIENT_DATA_QUERY,
                                                    Connection connection) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(CLIENT_DATA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String patronymic = resultSet.getString(3);
                String surname = resultSet.getString(4);

                clients.add(new Client(id, name, patronymic, surname));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void getFiles(ObservableList<File> files,
                                PreparedStatement preparedStatement) throws SQLException {
        {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String path = resultSet.getString(3);
                int size = resultSet.getInt(4);

                files.add(new File(id, name, path, size));
            }

        }
    }
}