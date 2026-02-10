package Try;

import java.net.*;

public class Main1 {
    public static void main(String[] args) throws Exception {
        NetworkInterface ni = NetworkInterface.getByName("eth0");
        if (ni == null) {
            System.err.println("No such interface: eth0");
        }
        System.out.println(" eth0" + ni);
    }
}
