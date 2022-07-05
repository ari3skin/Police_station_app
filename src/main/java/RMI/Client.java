package RMI;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    Hello_Interface stub;

    private Client(){
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry(null);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
        try {
            stub = (Hello_Interface) registry.lookup("kps");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }
    }


}
