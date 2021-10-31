package database;

import java.sql.*;

public class DAO {
    public static Connection getConnection() {
        String connString = "jdbc:mysql://localhost:3306/placement_management";
        String userName = "admin";
        String password = "admin123";
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connString, userName, password);
        } catch (Exception e) {
            System.out.println("Sorry, The connection could not be Established");
            e.printStackTrace();
        }
        return conn;
    }
}
