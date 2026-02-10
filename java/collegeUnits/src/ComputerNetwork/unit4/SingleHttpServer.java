package ComputerNetwork.unit4;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Socket;

public class SingleHttpServer {
    public static void main(String[] args) {
        
        System.out.println("Http server started on port 8080");
        while(true) {
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Received request: " + requestLine);
            File file = new File(null)
        }
    }
}
