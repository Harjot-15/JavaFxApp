package com.example.javafxapp.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseHelper {

    // Database connection parameters
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/employeesDB";
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASS = "1994H@rjot";  // Replace with your database password

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASS);
        } catch (Exception e) {
            throw new Exception("Error connecting to the database: " + e.getMessage());
        }
    }
}
