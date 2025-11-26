package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseSetup {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/testdb"; // your DB
        // String username = "root"; // MariaDB username
        // Stri ng password = "sujjalbtw";     // MariaDB password
        String username = "attendance";
        String password = "12345";

        try {
            // Optional: explicitly load the driver (good practice)
            Class.forName("org.mariadb.jdbc.Driver");

            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENTS")) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println("Id: " + id + " Name: " + name + " Age: " + age);
                }

            } // resources auto-closed

        } catch (ClassNotFoundException e) {
            System.err.println("MariaDB JDBC driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database error:");
            e.printStackTrace();
        }
    }
}
 DatabaseSetup {
    
}
