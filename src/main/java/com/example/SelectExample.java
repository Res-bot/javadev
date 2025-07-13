package com.example;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
// import java.io.FileInputStream;

public class SelectExample {
    public static void main(String[] args){
        Properties props = new Properties();

        try {
            props.load(SelectExample.class.getClassLoader().getResourceAsStream("config.properties"));

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            try {
                Connection conn = DriverManager.getConnection(url, user, password);
                Statement stmt = conn.createStatement();
                String sql = "SELECT * from student ";
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {

                    int roll = rs.getInt("roll_no");
                    String namee = rs.getString("namee");
                    String classs = rs.getString("classs");
                    String dob = rs.getString("DOB");
                    String gender = rs.getString("gender");
                    String city = rs.getString("city");
                    String marks = rs.getString("marks");
                    System.out.println("Roll: " + roll + ", Name: " + namee +
                    ", Class: " + classs + ", DOB: " + dob + ", Gender: " + gender +
                    ", City: " + city + ", Marks: " + marks);
                }
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
            
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
