
// 2.  Add two distances in inch-feet by creating a class named 'Add Distance'.
//adding feet, inch + feet, inch answer print in screen

import java.util.Scanner;

public class doubleadd {
    public static void main (String [] args) {
         Scanner scanner = new Scanner(System.in);

         System.out.print("Enter first feet and inches : ");
         double feet1 = scanner.nextDouble();
         double inches1 = scanner.nextDouble();
         
         System.out.print("Enter second feet and inches : ");
         double feet2 = scanner.nextDouble();
         double inches2 = scanner.nextDouble();
         

         double totalinch = inches1 + inches2;
        double totalfeet = feet1 + feet2;
         //add two inches and do modulous and extract inches to feet
         if(totalinch>=12){
            totalinch=totalinch-12;
            totalfeet++;
         }
         System.out.println("Total : " + totalfeet +" feet " + totalinch + " is inches.");
         scanner.close();
    }
}
