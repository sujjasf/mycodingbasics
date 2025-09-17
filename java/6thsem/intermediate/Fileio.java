import java.nio.file.*;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

// class WriteFile {
//     public static void main(String[] args) throws IOException {
//         FileWriter writer = new FileWriter("output.txt");
//         writer.write("Hello, its your boi ksi. Knowledge FR.");
//         writer.close();
//     }
// }


// class ReadFile {
//     public static void main(String[] args) throws IOException {
//         FileReader reader = new FileReader("output.txt");
//         int ch;
//         while((ch = reader.read()) != -1) {
//             System.out.print((char) ch);
//         }
//         System.out.println();
//         reader.close();
//     }
// }


// BufferedReader br = new BufferedReader(new FileReader("output.txt"));
// String line;
// while((line = br.readLine()) != null) {
//     System.out.println(line);
// }
// br.close();


// class FilesAPIExample {
//     public static void main(String[] args) throws IOException {
//         String content = Files.readString(Path.of("output.txt"));
//         System.out.println(content);

//         Files.writeString(Path.of("output2.txt"), "Written using Files API!");
//     }
// }

// class ExceptionHan {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter Two numbers to divide!🤓");
//         try{
//             System.out.print("Enter 1st number : ");
//             int a = sc.nextInt();
//             System.out.print("Enter 2nd number : ");
//             int b = sc.nextInt();

//             double result = (double) a / (double) b;
//             System.out.printf("The result is  : %.2f", result);
//             System.out.println();

//         } catch(ArithmeticException e) {
//             System.out.println("Error: Divide by zero not allowed.");
//         }
//     }
// }




// class AgeException extends Exception {
//     public AgeException(String msg) {
//         super(msg);
//     }
// }
// class Fileio {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter Your age!🤓");
//         int age = sc.nextInt();
//         try{
//             if(age < 18) {
//                 throw new AgeException("You must be 18+.🤓");
//             }
//             System.out.println("You are allowed to Allegable to vote.");
//         } catch(AgeException e) {
//             System.out.println("Exception occured : " + e.getMessage());
//         }
//     }
// }


// class Fileio {
//     public static void main(String[] args) throws IOException{
//         FileReader reader = new FileReader("output.txt");
//         int ch, countLetters = 0, countWords = 0, countLines = 0;
//         while((ch = reader.read()) != -1) {
//             System.out.print((char) ch);
//             countLetters++;
//             if((char) ch == ' ') {
//                 countWords++;
//             }
//             if((char) ch == "\n") {
//                 countLines++;
//             }
//         }
//         System.out.printf("Letters %d, Words %d, Lines %d", countLetters, countWords, countLines);
//         reader.close();
//     }
// }

// class Fileio {
//     public static void main(String[] args) throws IOException {
//         FileReader reader = new FileReader("output.txt");
//         int ch;
//         int countLetters = 0, countWords = 0, countLines = 0;
//         boolean inWord = false;

//         while ((ch = reader.read()) != -1) {
//             char c = (char) ch;
//             System.out.print(c);

//             // Count letters (alphabetic only)
//             if (Character.isLetter(c)) {
//                 countLetters++;
//             }

//             // Count words (transition from non-space to space/newline)
//             if (Character.isWhitespace(c)) {
//                 if (inWord) {
//                     countWords++;
//                     inWord = false;
//                 }
//                 if (c == '\n') {
//                     countLines++;
//                 }
//             } else {
//                 inWord = true;
//             }
//         }

//         // If file didn’t end with space/newline, close last word
//         if (inWord) countWords++;

//         reader.close();

//         System.out.printf("\nLetters: %d, Words: %d, Lines: %d\n",
//                           countLetters, countWords, countLines + 1);
//     }
// }


// class FileWordCount {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new FileReader("output.txt"));
//         String line;
//         int lineCount = 0, wordCount = 0;

//         while((line = br.readLine()) != null) {
//             lineCount++;
//             wordCount += line.split("\\s+").length;
//         }
//         br.close();

//         System.out.println("Lines: "+ lineCount);
//         System.out.println("Words: "+ wordCount);
        
//     }
// }

// Log User input into file untill "exit"
// class InputLogger {
//     public static void main(String[] args) throws IOException {
//         Scanner sc = new Scanner(System.in);
//         // BufferedWriter writer = new BufferdWriter(new FileWriter("log.txt", true));
//         BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true)); // append mode

//         while(true) {
//             System.out.print("Enter text (type 'exit' to quit): ");
//             String input = sc.nextLine();

//             if(input.equalsIgnoreCase("exit")) break;

//             writer.write(input);
//             writer.newLine();
//         }
//         writer.close();
//         sc.close();
//         System.out.println("All inputs logged into log.txt.");
//     }
// }


// class InputLogger {
//     public static void main(String[] args) throws IOException {
//         Scanner sc = new Scanner(System.in);
//         BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true)); // append mode

//         while(true) {
//             System.out.print("Enter text (type 'exit' to quit): ");
//             String input = sc.nextLine();

//             if(input.equalsIgnoreCase("exit")) break;

//             writer.write(input);
//             writer.newLine();
//         }

//         writer.close();
//         sc.close();
//         System.out.println("All inputs logged into log.txt");
//     }
// }

// Use Streams to filter even numbers from a list
// class EvenFilter {
//     public static void main(String[] args) {
//         List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
//         // List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
//         List<Integer> evens = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

//         System.out.println("Even Numbers : " + evens);
//     }
// }


// // Convert a list of strings to uppercase using lambda expressions.
// class UpperCaseList {
//     public static void main(String[] args) {
//         List<String> names = Arrays.asList("Sujjal", "Sushant", "Sujal", "Human", "Being");
//         List<String> upsCase = names.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());

//         System.out.println("To Upper Case is : " + upsCase);
//     }
// }
 
// Count words in a list that start with "A" using Streams.
// class CountA {
//     public static void main(String[] args) {
//         List<String> names = Arrays.asList("Sujjal", "Sushant", "Sujal", "Aword", "Asecond", "Acorn", "Human", "Being");
//         List<String> aWords = names.stream().filter(n -> n.startsWith("A")).collect(Collectors.toList());

//         long aCount = names.stream().filter(n -> n.startsWith("A")).count();
        
//         System.out.println("The words which start with a is : " + aWords + " Number is : " + aCount);
//     }
// }


// Demonstrate Optional to avoid NullPointerException
class OptionalDemo {
    public static void main(String[] args) {
        String name = null;

        // Wrap in Optional
        Optional<String> optName = Optional.ofNullable(name);

        // Provide fallback if null
        String result = optName.orElse("Default Name");

        System.out.println(result); // Prints "Default Name"
    }
}

































