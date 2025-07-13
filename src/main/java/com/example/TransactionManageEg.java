package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class TransactionManageEg {
    public static void main(String[] args) {
        Properties props = new Properties();

        try {
            props.load(TransactionManageEg.class.getClassLoader().getResourceAsStream("config.properties"));

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            Connection conn = null;

            try {
                conn = DriverManager.getConnection(url, user, password);
                conn.setAutoCommit(false);
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("UPDATE accounts SET balance = balance + 100 WHERE id=2;");
                conn.commit();
                System.out.println("Transaction comitted successfully");
            } catch (Exception e) {
                e.printStackTrace();

                try {
                    conn.rollback();
                    System.out.println("Transaction rolled back due to error");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        } catch (Exception exe) {
            exe.printStackTrace();
        }
    }
    
}
