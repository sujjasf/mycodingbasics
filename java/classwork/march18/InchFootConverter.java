

import java.util.Scanner;


// 2.  Add two distances in inch-feet by creating a class named 'Add Distance'.
class InchConverter {
    double inches;

    InchConverter(double inches) {
        this.inches = inches;
    }

    double toFeet() {
        return inches / 12.0;
    }
}
public class InchFootConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter inches: ");
        double inches = scanner.nextDouble();

        InchConverter converter = new InchConverter(inches);
        double feet = converter.toFeet();

        System.out.println(inches + " inches is equal to " + feet + " feet.");

        scanner.close();
    }
}
