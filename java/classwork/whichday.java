package java.classwork;
// 6. Print day number in words "sunday", "monday", ...."saturday" 
//by asking user to input number use switch and nested loop

import java.util.Scanner;

public class whichday {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input the number of the day
        System.out.print("Enter the number of the day (1-7): ");
        int dayNumber = scanner.nextInt();

        // Close the scanner to prevent resource leak
        scanner.close();

        // Validate the input to ensure it falls within the range of 1 to 7
        if (dayNumber < 1 || dayNumber > 7) {
            System.out.println("Invalid input. Please enter a number between 1 and 7.");
            return; // Exit the program if the input is invalid
        }

        // Define an array to store the names of the days
        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        // Print the name of the day corresponding to the input number
        switch (dayNumber) {
            case 1:
                System.out.println("The day is: " + daysOfWeek[0]);
                break;
            case 2:
                System.out.println("The day is: " + daysOfWeek[1]);
                break;
            case 3:
                System.out.println("The day is: " + daysOfWeek[2]);
                break;
            case 4:
                System.out.println("The day is: " + daysOfWeek[3]);
                break;
            case 5:
                System.out.println("The day is: " + daysOfWeek[4]);
                break;
            case 6:
                System.out.println("The day is: " + daysOfWeek[5]);
                break;
            case 7:
                System.out.println("The day is: " + daysOfWeek[6]);
                break;
            default:
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
        }
    }
}
