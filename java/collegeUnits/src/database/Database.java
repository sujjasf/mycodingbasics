/*
Create a java program using employee table, your program's output should display choices for example
    Enter your choice....
    1. Insert Employee
    2. View Employees
    3. Delete Employee
    4. Update Employee
*/
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Database {
    static final String url = "jdbc:mariadb://localhost:3306/testdb";
    static final String username = "attendance";
    static final String password = "12345";

    // One scanner for whole program
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Employee Management Menu =====");
            System.out.println("1. Insert Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Delete Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            // FIX: after nextInt(), buffer still has a leftover newline, so clear it
            sc.nextLine();

            switch (choice) {
                case 1:
                    insertEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return; 
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void insertEmployee() {
        try {
            System.out.println("Enter Name: ");

            // FIX: nextInt() from menu left newline, so nextLine() would read empty without clearing
            // Already cleared in main, so no need additional clear here

            String name = sc.nextLine();

            System.out.println("Enter Salary: ");
            double salary = sc.nextDouble();

            // FIX: nextDouble() leaves newline, so clear it
            sc.nextLine();

            System.out.println("Enter Branch: ");
            String branch = sc.nextLine();

            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO employees (name, salary, branch) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, branch);

            ps.executeUpdate();
            System.out.println("Employee inserted Successfully!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void viewEmployees() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "SELECT * FROM employees";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Employee List ---");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Salary: " + rs.getDouble("salary") +
                        ", Branch: " + rs.getString("branch"));
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void deleteEmployee() {
        try {
            viewEmployees();

            System.out.println("Enter Employee ID to delete: ");
            int id = sc.nextInt();

            Connection conn = DriverManager.getConnection(url, username, password);

            String sql = "DELETE FROM employees WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee deleted successfully");
            else
                System.out.println("Employee ID not found");

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void updateEmployee() {
        try {
            viewEmployees();

            System.out.println("Enter employee ID to update: ");
            int id = sc.nextInt();
            sc.nextLine(); // FIX: clear newline

            System.out.print("Enter new name: ");
            String name = sc.nextLine();

            System.out.print("Enter new salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); // FIX: clear newline

            System.out.print("Enter new branch: ");
            String branch = sc.nextLine();

            Connection conn = DriverManager.getConnection(url, username, password);

            // FIX 1: Previously used variable name `url` here, wrong. Changed to sql
            // FIX 2: Missing WHERE id = ? earlier, added now
            String sql = "UPDATE employees SET name = ?, salary = ?, branch = ? WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, name);
            ps.setDouble(2, salary);
            ps.setString(3, branch);
            ps.setInt(4, id); // FIX: index 4 now exists because WHERE has ?

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Employee updated successfully!");
            else
                System.out.println("Employee ID not found.");

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}