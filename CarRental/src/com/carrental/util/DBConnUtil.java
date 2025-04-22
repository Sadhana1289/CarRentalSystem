package com.carrental.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
    public static Connection getConnection(String propertiesFilePath) {
        String connStr = DBPropertyUtil.getConnectionString(propertiesFilePath);
        try {
            return DriverManager.getConnection(connStr);
        } catch (SQLException e) {
            System.out.println("DB connection error: " + e.getMessage());
            return null;
        }
    }
}
