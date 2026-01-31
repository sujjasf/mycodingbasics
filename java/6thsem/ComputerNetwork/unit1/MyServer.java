package unit1;

import java.io.DataInputStream;
import java.net.*;

public class MyServer {

    public static void main(String[] args) {
        try {
            // Create server socket on port 6666
            ServerSocket ss = new ServerSocket(6666);
            System.out.println("Server is waiting for client...");

            // Accept client connection
            Socket s = ss.accept();
            System.out.println("Client connected!");

            // Read data from client
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = dis.readUTF();

            // Print received message
            System.out.println("Message = " + str);

            // Close connections
            dis.close();
            s.close();
            ss.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
