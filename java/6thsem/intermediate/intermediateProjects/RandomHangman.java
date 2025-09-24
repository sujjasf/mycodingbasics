import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class RandomHangman {
    public static void main(String[] args) {

        String filePath = "HangmanRandom.txt";
        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("Could not find file");
        }
        catch(IOException e) {
            System.out.println("Something went wrong");
        }
        
        Random random = new Random();

        String word = words.get(random.nextInt(words.size())).toLowerCase();

        Scanner scanner = new Scanner(System.in);

        ArrayList<Character> wordState = new ArrayList<>();

        int wrongGuesses = 0;

        for(int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("*****************************");
        System.out.println("Welcome to java Hangman");
        System.out.println("*****************************");

        while(wrongGuesses < 6) {

            System.out.println(getHangmanArt(wrongGuesses));

            System.out.print("wordState : ");

            for(char c : wordState) {
                System.out.print(c + " ");
            }
            System.out.println();
            System.out.print("Guess a Letter : ");
            char guess = scanner.next().toLowerCase().charAt(0);

            System.out.println(guess);

            if(word.indexOf(guess) >= 0) {
                System.out.println("Correct Guess!");

                for(int i = 0; i < word.length(); i++) {
                    if(word.charAt(i) == guess) {
                        wordState.set(i, guess);
                    }
                }

                if(!wordState.contains('_')) {
                    System.out.println(getHangmanArt(wrongGuesses));
                    System.out.println("You won wow !!!");
                    System.out.println("Yaes the word was : "+ word);
                    break;

                }
            } else {
                wrongGuesses++;
                System.out.println("Wrong Guess!");
            }
        }

        if(wrongGuesses >= 6) {
            System.out.println(getHangmanArt(wrongGuesses));
            System.out.println("Game Over !!!");
            System.out.println("The word was : " + word);

        }

        scanner.close();
    }

    static String getHangmanArt(int wrongGuesses) {
        return switch(wrongGuesses) {
            case 0 -> """
                    _________
                        !



                      """;
            case 1 -> """
                    _________
                        !
                        o


                      """;
            case 2 -> """
                    _________
                        !
                        o
                        |

                      """;
            case 3 -> """
                    _________
                        !
                        o
                       /|

                      """;
            case 4 -> """
                    _________
                        !
                        o
                       /|\\

                      """;
            case 5 -> """
                    _________
                        !
                        o
                       /|\\
                       /
                      """;
            case 6 -> """
                    _________
                        !
                        o
                       /|\\
                       / \\
                       """;
            default -> "";
        };
    }
}