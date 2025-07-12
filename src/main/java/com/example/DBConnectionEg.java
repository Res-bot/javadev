package com.example;

import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Properties;
import java.io.FileInputStream;

public class DBConnectionEg {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {
            props.load(new FileInputStream("config.properties"));

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                System.out.println("Connected to Database");
                conn.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}