import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // How to play audio with java (.wav, .au, .aiff)

        // String filePath = "TotalEclipsecut.wav";
        String filePath = "ThePoliceWatchingYou.wav";
        File file = new File(filePath);

        try(Scanner scanner = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            String response = "";

            while(!response.equals("Q")) {
                System.out.println("p = Play");
                System.out.println("s = Stop");
                System.out.println("r = Reset");
                System.out.println("q = Quit");
                System.out.print("Enter your choice : ");

                response = scanner.next().toUpperCase();

                switch(response) {
                    case "P" -> {
                        clip.setFramePosition(0);
                        clip.start();
                    }
                    case "S" -> clip.stop(); 
                    case "R" -> clip.setMicrosecondPosition(0); 
                    case "Q" -> clip.close(); 
                    default -> System.out.println("Invalid Choice !!!");
                }
            }

            System.out.println("Nothing went wrong");
        }
        catch (FileNotFoundException e) {
            System.out.println("Something went wrong. Audio file not supported...");

        } 
        catch (UnsupportedAudioFileException e) {
            System.out.println("Something went wrong. Audio file not supported...");
            
        } 
        catch (LineUnavailableException e) {

            System.out.println("Unable to access audio resource went wrong..");
        }
        catch(IOException e) {
            System.out.println("Something went wrong..");
        }
        finally {
            System.out.println("Bye exiting!!!.");
        }


    }
}