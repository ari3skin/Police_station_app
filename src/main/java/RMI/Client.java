package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client{

    public Hello_Interface stub;

    Client() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();
        stub = (Hello_Interface) registry.lookup("kps");
    }
}
