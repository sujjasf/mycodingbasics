import java.net.ServerSocket;
import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ServerClass {
    public static void main(String[] args) {
        try {
            ServerSocket Ssocket = new ServerSocket(5000);
            System.out.println("Server is running... waiting for client connection");

            Socket socket = Ssocket.accept();
            System.out.println("Client is connected.");

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            writer.println("Hello client, Sujjal");

            writer.close();
            socket.close();
            Ssocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

