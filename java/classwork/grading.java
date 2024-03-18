

// 5. A school has follwing grading system...
/*
 * a. below 25 => f
 * 25-45 => E
 * 45-50 => D
 * 50-60 => C
 * 60-80 => B
 * above 80 => A
 * Ask user to enter marks and print the corresponding order
 */
import java.util.Scanner;

public class grading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to enter marks
        System.out.print("Enter your marks: ");
        int marks = scanner.nextInt();

        // Close the scanner to prevent resource leak
        scanner.close();

        // Determine the grade based on the marks entered
        String grade;
        if (marks < 25) {
            grade = "F";
        } else if (marks >= 25 && marks < 45) {
            grade = "E";
        } else if (marks >= 45 && marks < 50) {
            grade = "D";
        } else if (marks >= 50 && marks < 60) {
            grade = "C";
        } else if (marks >= 60 && marks < 80) {
            grade = "B";
        } else {
            grade = "A";
        }

        // Print the corresponding grade
        System.out.println("Your grade is: " + grade);
    }
}
