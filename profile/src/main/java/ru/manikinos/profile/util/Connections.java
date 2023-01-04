package ru.manikinos.profile.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    private static final String URL = "jdbc:h2:./alman";
    private static final String USER = "alman";
    private static final String PASSWORD = "1";

    /**
     * Получить connection в бд.
     *
     * @return - connection
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
