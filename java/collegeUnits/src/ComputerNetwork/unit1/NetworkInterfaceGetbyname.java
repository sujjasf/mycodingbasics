package ComputerNetwork;

import java.net.NetworkInterface;
import java.util.Enumeration;

public class NetworkInterfaceGetbyname {
    public static void main(String[] args) throws Exception {
        Enumeration<NetworkInterface> em = NetworkInterface.getNetworkInterfaces();
        while(em.hasMoreElements()){
            NetworkInterface ni = em.nextElement();
            System.out.println(ni);
        }
    }
}
