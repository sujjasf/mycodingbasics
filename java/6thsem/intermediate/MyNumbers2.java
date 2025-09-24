import java.util.ArrayList;
import java.util.Scanner;

public class MyNumbers2 {
    private final ArrayList<Integer> al = new ArrayList<>();

    // Input method
    void input() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("How many numbers do you want to enter? ");
            int c = sc.nextInt();

            System.out.println("Enter the numbers:");
            for (int i = 0; i < c; i++) {
                al.add(sc.nextInt());
            }
        }
    }

    // Display method
    void display() {
        System.out.println("Elements in ArrayList:");
        for (int i : al) {
            System.out.println(i);
        }
    }

    // Find min, max, swap them
    void process() {
        if (al.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }

        int min = al.get(0), max = al.get(0);
        int imin = 0, imax = 0;

        for (int i = 1; i < al.size(); i++) {
            if (al.get(i) < min) {
                min = al.get(i);
                imin = i;
            }
            if (al.get(i) > max) {
                max = al.get(i);
                imax = i;
            }
        }

        System.out.println("Largest number is: " + max + " at index: " + imax);
        System.out.println("Smallest number is: " + min + " at index: " + imin);

        // Swap
        al.set(imax, min);
        al.set(imin, max);

        System.out.println("---- After Swapping ----");
        display();
    }

    public static void main(String[] args) {
        MyNumbers2 obj = new MyNumbers2();
        obj.input();
        obj.display();
        obj.process();
    }
}
