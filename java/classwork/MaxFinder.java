// 1. Write a program to find maximum between 3 numbers.


public class MaxFinder {
    public static void main(String[] args) {
        // Define three number
        int num1 = 10;
        int num2 = 20;
        int num3 = 30;

        //find the maximun number
        int max = num1; //Assume num1 is the maximun initially

        // compare num2 with max
        if(num2> max){
            max = num2; // if num2 is greater than max, update max to num3
        }

        // compare num3 with max
        if(num3>max){
            max = num3;//if num3 is greater than max, update max to num3
        }

        //print the maximun number
        System.out.println("The maximum number among "+ num1 +", " + num2 + ", and " + num3 + " is : " + max);
    }
}
