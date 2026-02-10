package ComputerNetwork.Unit5;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            HelloRMI stub = (HelloRMI) registry.lookup("HelloRMI");
            String response = stub.sayHello();
            System.out.println("response: " + response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
