
// 2.  Add two distances in inch-feet by creating a class named 'Add Distance'.
//adding feet, inch + feet, inch answer print in screen

import java.util.Scanner;

static void  takeInput( ){
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter first feet and inches : ");
    double feet1 = scanner.nextDouble();
    double inches1 = scanner.nextDouble();
    
    System.out.print("Enter second feet and inches : ");
    double feet2 = scanner.nextDouble();
    double inches2 = scanner.nextDouble();

    double totalinch = add(inches1, inches2);
    double totalfeet = add(feet1, feet2);
    
    if(totalinch>=12){
        totalinch=totalinch-12;
        totalfeet++;
     }
}


static double add(double a,double b){
    return (a+b);
}
public class inchesfun {
    public static void main (String [] args) {
         takeInput();
         display()
    }
}
