package ComputerNetwork;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class SpamCheck {
    public static String BlackHole = "sbl.spamhaus.org";
    public static void main(String[] args) throws Exception {
        System.out.println("Java");
    }
    private static boolean IsSpammer(arg) {
        InetAddress addr = InetAddress.getByName("www.google.com");
        byte[] quad = addr.getAddress();
        String query = "BlackHole";
        


    }
}




