package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class PreparedStmtEg{
    public static void main(String[] args) {
        
        Properties props = new Properties();
        try {
            props.load(PreparedStmtEg.class.getClassLoader().getResourceAsStream("config.properties"));
            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");
            String insertSQL = "INSERT INTO accounts(id, namee, balance) values(?,?,?) ";

            Connection conn = null;

            try {

                conn = DriverManager.getConnection(url, user, password);

                PreparedStatement pstmt = conn.prepareStatement(insertSQL);
                pstmt.setInt(1, 3);
                pstmt.setString(2, "Bonnie");
                pstmt.setInt(3, 25000);

                int rowsinserted = pstmt.executeUpdate();
                System.out.println("Rows inserted: " + rowsinserted);

                Statement stmt = conn.createStatement();
                String quer = "SELECT * FROM accounts";
                ResultSet rs = stmt.executeQuery(quer);

                while (rs.next()) {
                    
                    int id = rs.getInt("id");
                    String namee = rs.getString("namee");
                    int balance = rs.getInt("balance");

                    System.out.println(id + ". Name: " + namee + ". Balance: " + balance);
                }
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}