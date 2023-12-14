package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {
    private static final String URL = "jdbc:postgresql://localhost:5432/CulturalEvent";
    private static final String USER = "postgres";
    private static final String PASSWORD = "png67dat3";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
