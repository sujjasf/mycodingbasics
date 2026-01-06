package ComputerNetwork;

import java.net.InetAddress;

public class TestingReachability {
    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            if(address.isReachable(300)) {
                System.out.println("This machine is not server");
            } else {
                System.out.println("This server is reachable");
            }
        } catch (Exception e) {
        }
    }
}
