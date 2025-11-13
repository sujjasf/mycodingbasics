package ComputerNetwork;

import java.net.InetAddress;

public class InetAddressClas {
    public static void main(String[] args) {
        try {
            InetAddress addr = InetAddress.getByName("www.google.com");
            System.out.println(addr.getHostAddress());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }    
}
