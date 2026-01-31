package unit1;

import java.io.*;
import java.net.*;

public class MyClient {

    public static void main(String[] args) {
        try {
            // Connect to server on localhost at port 6666
            Socket s = new Socket("localhost", 6666);

            // Create output stream to send data
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());

            // Send message to server
            dout.writeUTF("Hello Server");

            // Force data to be sent
            dout.flush();

            // Close connection
            dout.close();
            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
