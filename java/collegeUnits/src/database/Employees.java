package database;

import java.sql.*;

public class Employees {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/testdb"; // your DB
        // String username = "root"; // MariaDB username
        // String password = "sujjalbtw";     // MariaDB password
        String username = "attendance";
        String password = "12345";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO employees (name, salary, branch) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Sushant Khadka");
            ps.setDouble(2, 4500);;
            ps.setString(3, "Biratnagar");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
