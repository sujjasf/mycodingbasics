

public class numpattern {
    public static void main(String[] args) {
        int height = 5; // Height of the pyramid

        // Outer loop to iterate through each row
        for (int i = 1; i <= height; i++) {
            // Print numbers in descending order from i to 1
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }

            // Print numbers in ascending order from 2 to i
            for (int k = 2; k <= i; k++) {
                System.out.print(k);
            }

            // Move to the next line for the next row
            System.out.println();
        }
    }
}
