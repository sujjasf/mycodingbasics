package unit1;
import java.io.*;
import java.net.*;

public class MyServer {

    public static void main(String[] args) {
        try {
            // Step 1: Create ServerSocket
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server is waiting for client...");

            // Step 2: Accept client connection
            Socket s = ss.accept();
            System.out.println("Client connected");

            // Step 3: Read data from client
            DataInputStream dis =
                new DataInputStream(s.getInputStream());

            String str = dis.readUTF();   // receive message
            System.out.println("Message = " + str);

            // Step 4: Close resources
            dis.close();
            s.close();
            ss.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
