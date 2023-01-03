package ru.manikinos.profile.util;

public class Connections {
    private static final String URL = "jdbc:h2:./alman";
    private static final String USER = "alman";
    private static final String PASSWORD = "1";

    /**
     * Получить connection в бд.
     *
     * @return - connection
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
