// 2. Write a program to find factorial of a number


public class factorial {
    public static void main(String[] args) {
        int number = 5; // Change this number to calculate factorial for a different number

        long factorial = 1; // Initialize factorial to 1

        // Calculate factorial
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }

        // Print the factorial
        System.out.println("Factorial of " + number + " is: " + factorial);
    }
}
