package unit1;
import java.io.*;
import java.net.*;

public class MyClient {

    public static void main(String[] args) {
        try {
            // Step 1: Connect to server
            Socket s = new Socket("localhost", 6666);

            // Step 2: Send data to server
            DataOutputStream dout =
                new DataOutputStream(s.getOutputStream());

            dout.writeUTF("Hello Server");
            dout.flush();

            // Step 3: Close resources
            dout.close();
            s.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
