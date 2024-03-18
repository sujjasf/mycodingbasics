


public class pattern {
    public static void main(String[] args) {
        int height = 6; // Height of the pyramid

        // Outer loop to iterate through each row
        for (int i = 1; i <= height; i++) {
            // Print leading spaces for alignment
            for (int j = 1; j <= height - i; j++) {
                System.out.print(" ");
            }

            // Print asterisks ascending from 1 to i
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }

            // Move to the next line for the next row
            System.out.println();
        }
    }
}
