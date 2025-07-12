package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.io.FileInputStream;

public class PreparedStmtEg {
    public static void main(String[] args) {
        Properties props = new Properties();
        try {

            props.load(new FileInputStream("config.properties"));

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            String insertSQL = "INSERT INTO users (id, name, email) values (?,?,?)";

            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {

                pstmt.setInt(1, 1);
                pstmt.setString(2, "STEFAN");
                pstmt.setString(3, "stefan@gmail.com");

                int rowsInserted = pstmt.executeUpdate();
                System.out.println(rowsInserted + " row(s) inserted");

                Statement stmnt = conn.createStatement();
                String sql = "SELECT * FROM users";
                ResultSet rs = stmnt.executeQuery(sql);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    System.out.println(id + ". Name: " + name + ", Email: " + email);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
