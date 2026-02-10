package ComputerNetwork.Unit5;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            ImplementationRMI obj = new ImplementationRMI();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HelloRMI", obj);
            System.out.println("Server is Ready.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
