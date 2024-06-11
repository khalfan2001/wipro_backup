package com.day26;

import java.sql.*;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserAuthentication {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/wipro";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "rps@2345";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD)) {
            // Step 1: Create the User table
            createUserTable(connection);

            // Step 2: Insert a user with hashed password (for demonstration)
            insertUser(connection, "rootes", "rps@2345");

            // Step 3: Accept User ID and Password input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter User ID: ");
            String userID = scanner.nextLine();
            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            // Step 4: Check if the user exists and the password matches
            if (authenticateUser(connection, userID, password)) {
                System.out.println("User access allowed.");
            } else {
                System.out.println("User access denied.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createUserTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS User ("
                + "UserID VARCHAR(255) PRIMARY KEY, "
                + "PasswordHash VARCHAR(255) NOT NULL)";
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(createTableSQL);
        }
    }

    private static void insertUser(Connection connection, String userID, String password) throws SQLException {
        String hashedPassword = hashPassword(password);
        String insertUserSQL = "INSERT INTO User (UserID, PasswordHash) VALUES (?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(insertUserSQL)) {
            pstmt.setString(1, userID);
            pstmt.setString(2, hashedPassword);
            pstmt.executeUpdate();
        }
    }

    private static boolean authenticateUser(Connection connection, String userID, String password) throws SQLException {
        String selectUserSQL = "SELECT PasswordHash FROM User WHERE UserID = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(selectUserSQL)) {
            pstmt.setString(1, userID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String storedPasswordHash = rs.getString("PasswordHash");
                    return storedPasswordHash.equals(hashPassword(password));
                }
            }
        }
        return false;
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder(2 * hash.length);
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}