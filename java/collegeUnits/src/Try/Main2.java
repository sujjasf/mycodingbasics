package Try;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main1 {
    public static void main(String[] args) {
        try {
            InetAddress me = InetAddress.getLocalHost();
            String dottedQuad = me.getHostAddress();
            System.out.println("My address is " + dottedQuad);
        } catch (UnknownHostException ex) {
            System.out.println("I'm sorry i don't know my own address..."+ ex);
        }
    }
}
