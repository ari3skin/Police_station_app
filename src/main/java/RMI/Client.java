package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client{

    /// The client class will be used by the javafx application to execute queries

    public Hello_Interface stub;

    Client() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();
        stub = (Hello_Interface) registry.lookup("kps");
    }

    public Hello_Interface getStub() {
        return stub;
    }

}
