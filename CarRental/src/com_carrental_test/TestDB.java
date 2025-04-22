package com_carrental_test;

import com.carrental.util.DBConnUtil;
import java.sql.Connection;


public class TestDB {
    public static void main(String[] args) {
        Connection conn = DBConnUtil.getConnection("databse.properties");
        if (conn != null) {
            System.out.println("✅ Connected to the database!");
        } else {
            System.out.println("❌ Connection failed!");
        }
    }
}
/CarRental/src/resource/databse.properties