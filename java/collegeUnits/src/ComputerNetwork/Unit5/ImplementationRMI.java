package ComputerNetwork.Unit5;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplementationRMI extends UnicastRemoteObject implements HelloRMI {
    protected ImplementationRMI() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Hello from RMI Server!";
    }
}