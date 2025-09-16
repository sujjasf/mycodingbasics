import java.util.*;


class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.size();
        System.out.println("Sum is : " + sum);
        System.out.println("Average is : " + average);

    }
}