package com.example;

// import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class BatchProcessingEg {
    public static void main(String[] args){
        Properties prop = new Properties();

        try {
            prop.load(BatchProcessingEg.class.getClassLoader().getResourceAsStream("config.properties"));

            String url = prop.getProperty("db.url");
            String user = prop.getProperty("db.user");
            String password = prop.getProperty("db.password");

            try (Connection conn = DriverManager.getConnection(url, user, password)){
                String sql = "INSERT INTO users (id, name, email) values (?,?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);

                //First Student
                pstmt.setInt(1, 4);
                pstmt.setString(2, "Klaus");
                pstmt.setString(3, "klaus@gmail.com");


                //second student
                pstmt.setInt(1, 5);
                pstmt.setString(2, "Lexi");
                pstmt.setString(3, "lexi@gmail.com");

                pstmt.addBatch();

                int[] counts = pstmt.executeBatch();
                System.out.println("Number of statements executed: " + counts.length);
            } catch (Exception e) {
               e.printStackTrace(); 
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    
}
