package java;

import java.util.Scanner; // Importing the Scanner class to read user input


// 1. Write a program to find maximum between 3 numbers.
// 2. Write a program to find factorial of a number
// 3. Write a program to print pyramid of number pattern.
// 4. wap to print following pattern
// 5. A school has follwing grading system...
// 6. Print day number in words "sunday", "monday", ...."saturday" 
//by asking user to input number use switch and nested loop

public class max {
    public static void main(String[] args) {
        // Creating a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Prompting the user to enter their name
        System.out.print("Enter your name: ");
        
        // Reading the user's input
        String name = scanner.nextLine();

        // Greeting the user
        System.out.println("Hello, " + name + "! Welcome to Parbati ko bihe.");
        
        // Closing the Scanner object to prevent resource leak
        scanner.close();
    }
}
