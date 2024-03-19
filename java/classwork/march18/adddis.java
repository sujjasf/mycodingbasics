
// 2.  Add two distances in inch-feet by creating a class named 'Add Distance'.
//adding feet, inch + feet, inch answer print in screen

import java.util.Scanner;

public class adddis {
    public static void main (String [] args) {
         Scanner scanner = new Scanner(System.in);
         System.out.print("Enter inches: ");
         double inches1 = scanner.nextDouble();
         System.out.print("Enter inches: ");
         double inches2 = scanner.nextDouble();
         double totalinch = inches1 + inches2;
         System.out.println(totalinch + " is total inch");
         scanner.close();
    }
}
