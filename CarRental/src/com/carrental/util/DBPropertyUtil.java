package com.carrental.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {
    public static String getConnectionString(String filename) {
        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream(filename)) {
            props.load(fis);
            return "jdbc:mysql://" + props.getProperty("host") + ":" + props.getProperty("port") + "/" +
                    props.getProperty("dbname") + "?user=" + props.getProperty("username") + "&password=" + props.getProperty("password");
        } catch (IOException e) {
            System.out.println("Property file error: " + e.getMessage());
            return null;
        }
    }
}
