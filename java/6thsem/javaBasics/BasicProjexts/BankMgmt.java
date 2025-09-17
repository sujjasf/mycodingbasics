import java.util.Scanner;

public class BankMgmt {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Java Bank for Learning
        // Declare Variables
        double balance = 0;
        boolean isRunning = true;
        int choice;

        while(isRunning) {

        // Display menu using switch inside while(true)
        System.out.println();
        System.out.println("***********************");
        System.out.println("Banking Program!!!");
        System.out.println("***********************");
        System.out.println("1. Show Balance ");
        System.out.println("2. Deposit ");
        System.out.println("3. Withdraw ");
        System.out.println("4. Exit");
        System.out.println("***********************");

        // Get and Process users choice
        System.out.print("Enter your choice (1-4) : ");
        choice = scanner.nextInt();

        switch(choice) {
            case 1 -> showBalance(balance);
            case 2 -> balance = deposit(balance);
            case 3 -> balance = withDraw(balance);
            case 4 -> isRunning = false;
            default -> System.out.println("Invalid Choice");

        }
        }
        // showBalance(), deposit(), withDraw(), Exit message
        System.out.println("Exiting the program...");
        scanner.close();
    }

    static void showBalance(double balance) {
        System.out.println("***********************");
        System.out.printf("$%.2f", balance);
        System.out.println();
    }

    static double deposit(double balance) {
        System.out.print("Enter the deposit ammount : ");
        double depAmount = scanner.nextDouble();
        if(depAmount > 0) {
            balance += depAmount;
            // System.out.println();
            System.out.printf("Balance Deposited new balance is : %.2f", balance);
        } else {
            System.out.println("Deposit cannot be negative!.");
        }
            
        return balance;
    }

    static double withDraw(double balance) {
        System.out.print("Enter the withdraw ammount : ");
        double witDAmount = scanner.nextDouble();
        if (witDAmount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= witDAmount;
            System.out.printf("Withdrawal successful. New balance is: $%.2f\n", balance);
            // System.out.println();
            System.out.printf("Balance withdrawn new balance is : %.2f", balance);
        }
            System.out.printf("Balanc
        System.out.println();
        return balance;
    }
}