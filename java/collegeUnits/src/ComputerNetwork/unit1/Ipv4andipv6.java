package ComputerNetwork;

import java.net.InetAddress;
import java.net.NetworkInterface;

public class Ipv4andipv6 {
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getLocalHost();
        NetworkInterface nt = NetworkInterface.getByInetAddress(address);
        if(nt == null){
            System.err.println("null");
        } else {
            System.out.println(nt);
        }
    }
}
