package Try;

import java.net.InetAddress;

public class Main1 {
    public static void main(String[] args) throws Exception {

        InetAddress ia = InetAddress.getByName("www.google.com");

        // Display actual IP address
        System.out.println("IP Address: " + ia.getHostAddress());

        // Get IP in byte form
        byte[] address = ia.getAddress();

        // Check IP version
        if (address.length == 4) {
            System.out.println("IP Version: IPv4");
        } else if (address.length == 16) {
            System.out.println("IP Version: IPv6");
        } else {
            System.out.println("IP Version: Unknown");
        }
    }
}
