public class pattern1 {
    public static void main(String[] args) {
        int rows = 5; // Number of rows you want in your pattern

        for (int i = 1; i <= rows; i++) {
            // Prints stars for each row
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // Moves to the next line after printing each row
            System.out.println();
        }
    }
}
