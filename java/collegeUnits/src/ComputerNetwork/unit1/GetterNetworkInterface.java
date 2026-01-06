package ComputerNetwork;

import java.net.*;
import java.util.*;

public class GetterNetworkInterface {
    public static void main(String[] args) throws Exception{
        NetworkInterface ni = NetworkInterface.getByName("lo");
        Enumeration e = ni.getInetAddresses();
        System.out.println(e);
        while(e.hasMoreElements()) {
            System.out.println(e.nextElement());
        }
    }
}
