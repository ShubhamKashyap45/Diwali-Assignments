package com.example.utils;
import java.sql.Connection;
import java.sql.DriverManager;
public class DBUtil {
    // Update these values for your environment
    private static final String URL = "jdbc:mysql://localhost:3306/day04_task1";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
