package ComputerNetwork.unit4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class SSLSecureServer {
    public static void main(String[] args) {
        SSLServerSocketFactory factory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
        SSLServerSocket = (SSLServerSocket)factory.createServerSocket(5000);
        System.out.println("SSL Server Started");
        String msg;
        BufferedReader rd = new BufferedReader(new InputStreamReader(serverSock))
    }
}
