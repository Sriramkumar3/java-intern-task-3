package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
 private static final String URL = "jdbc:mysql://localhost:3306/survey_system";
 private static final String USERNAME = "root";
 private static final String PASSWORD = "root";
 
 public static Connection getConnection() throws SQLException {
     return DriverManager.getConnection(URL, USERNAME, PASSWORD);
 }
}

