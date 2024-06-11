package com.day26;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConnection {
    public static void main(String[] args) {
        // Database credentials
        String jdbcUrl = "jdbc:mysql://localhost:3306/wipro";
        String username = "root";
        String password = "rps@2345";

        Connection connection = null;

        try {
            // Establish the connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Print the connection object to confirm successful connection
            System.out.println("Connection established successfully: " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to establish connection: " + e.getMessage());
        } finally {
            // Close the connection if it was successfully opened
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
