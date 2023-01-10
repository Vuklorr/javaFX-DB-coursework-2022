package com.vuklorr.fileshared.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connections {
    private static final String URL = "jdbc:h2:./vuklorr";
    private static final String USER = "Vuklorr";
    private static final String PASSWORD = "1";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}