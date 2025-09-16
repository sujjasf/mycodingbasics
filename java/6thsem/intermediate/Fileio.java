import java.nio.file.*;
import java.io.IOException;
import java.io.*;
import java.util.Scanner;

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


class Fileio {
    public static void main(String[] args) throws IOException{
        FileReader reader = new FileReader("output.txt");
        int ch, countLetters = 0, countWords = 0, countLines = 0;
        while((ch = reader.read()) != -1) {
            System.out.print((char) ch);
            countLetters++;
            if((char) ch == ' ') {
                countWords++;
            }
            if((char) ch == "\n") {
                countLines++;
            }
        }
        System.out.printf("Letters %d, Words %d, Lines %d", countLetters, countWords, countLines);
        reader.close();
    }
}

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

