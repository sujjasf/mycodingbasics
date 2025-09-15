class PracticeExtra{
    public static void main(String[] args) {
        
    }
}







































// class PracticeExtra{
//     public static void main(String[] args) {
//         int[][] matrix = {
//             {1, 2, 3},
//             {3, 4, 5},
//             {7, 8, 9}
//         };
//         int positioni = -1;
//         int positionj = -1;
//         for(int i = 0; i < matrix.length; i++ ) {
//             for(int j = 0; j < matrix[i].length; j++ ) {
//                 System.out.print(matrix[i][j] + " ");
//                 if(matrix[i][j] == 2){
//                     positioni = i;
//                     positionj = j;
//                 }
//             }
//             System.out.println();
//         }
//         if(positioni != -1){
//             System.out.println("The position is : " + positioni + " & " + positionj);
//         } else {
//             System.out.println("The Number is not found!.");
//         }
//     }
// }

// class PracticeExtra{
//     public static void main(String[] args) {
//         int[] arr = {1, 8, 2, 3, 2, 4, 8};
//         int largest = 0;
//         int number = 2;
//         for(int i = 0; i < arr.length; i++ ) {
//             // if(largest < arr[i]){
//             //     largest = arr[i];
//             // }
//             // largest += arr[i];
//             if(arr[i]==2) largest++;
//         }
//         System.out.println("The largest is : " + largest);
//     }
// }



// class PracticeExtra{
//     public static void main(String[] args) {
//         int[] arr = {1, 8, 34, 2, 8};
//         int largest = 0;
//         for(int i = 0; i < arr.length; i++ ) {
//             if(largest < arr[i]){
//                 largest = arr[i];
//             }
//         }
//         System.out.println("The largest is : " + largest);
//     }
// }



// class PracticeExtra{
//     public static void main(String[] args) {
//         int[] arr;
//         arr = new int[5];
//         arr[0]=1;
//         arr[2]=2;
//         arr[3]=99;
//         arr[4]=4;
//         int[] arr1 = {1, 2, 3, 4, 5};
//         System.out.println("Arr1 is ");
//         for(int a = 0; a < arr1.length; a++) {
//             System.out.println(arr1[a]);
//         }
//         System.out.println("Arr is ");
//         for(int num : arr) {
//             System.out.println(num);
//         } 
//     }
// }



// class PracticeExtra{
//     static int reverse(int num) {
//         int temp = num;
//         int rev = 0;
//         while(temp > 0){
//             int rem = temp % 10;
//             rev = rev * 10 + rem;
//             temp = temp/10;
//         }
//         return rev;
//     }
//     static void palindrome(int num) {
//         if(reverse(num) == num){
//             System.out.printf("Yes, %d is palindrome.%n", num);
//         } else {
//             System.out.printf("No, %d is not palindrome.\n", num);
//         }
//     }

//     public static void main(String[] args) {
//         // Palindrome check on number
//         int num = 5453;
//         int revNum = reverse(num);
//         System.out.println("The number is " + revNum);
//         palindrome(num);
//     }
// }


// class PracticeExtra{
//     public static void main(String[] args) {
//         int a = 5;
//         for (; a < 10; a++) {
//             System.out.println(a);
//         }
//     }
// }


// class PracticeExtra{
//     public static void main(String[] args) {
//         // double a = -7.5;
//         String a = "sunday";
//         int b = -10;
//         // char a = '-1';
//         switch(a) {
//             case "sunday":
//                 System.out.println("Today is sunday");
//                 break;
//             case "monday":
//                 System.out.println("Today is monday");
//                 break;
//             default:
//                 System.out.println("There are only two days in two days. 🤓");
//         }
//     }
// }

// class PracticeExtra{
//     public static void main(String[] args) {
//         double a = -7.5;
//         int b = -10;
//         // char a = '-1';
//         if(a == 0) {
//             System.out.println("THe number is zero.");
//         }else if (a > 0) {
//             System.out.println("The number is positive.");
//         }else if(a < 0) {
//             System.out.println("The number is negative.");
//         } else {
//             System.out.println("I even don't know what the variable is!!! 🤓");
//         }
//     }
// }

