package com.day26;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 public class User{
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/wipro_training";
        String username = "root";
        String password = "rps@2345";
 
        Connection connection = null;
 
        try {
            // Load the JDBC driver (for MySQL)
            Class.forName("com.mysql.cj.jdbc.Driver");
 
            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
 
            // Disable auto-commit mode
            connection.setAutoCommit(false);
 
            // Perform database operations
            performDatabaseOperations(connection);
 
            // Commit the transaction
            connection.commit();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    // Rollback the transaction in case of an error
                    connection.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) {
                    // Re-enable auto-commit mode and close the connection
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }
    }
 
    private static void performDatabaseOperations(Connection connection) throws SQLException {
        // Example SQL operations
        String insertUserSql = "INSERT INTO sume (sname,ID, email) VALUES (?, ?,?)";
        String updateUserSql = "UPDATE sume SET email = ? WHERE username = ?";
 
        try (PreparedStatement insertUserStmt = connection.prepareStatement(insertUserSql);
             PreparedStatement updateUserStmt = connection.prepareStatement(updateUserSql)) {
 
            // Insert a new user
            insertUserStmt.setString(1, "Khalfan Hussain");
            insertUserStmt.setInt(2, 1);
            insertUserStmt.setString(3, "khalfan.hussain01@gmail.com");
            insertUserStmt.executeUpdate();
 
            // Update an existing user
			/*
			 * updateUserStmt.setString(3, "khalfan.hussain01@gmail.com");
			 * updateUserStmt.setInt(4, 4); updateUserStmt.setString(5, "khalfan hussain");
			 * updateUserStmt.executeUpdate();
			 */
        }
    }
}