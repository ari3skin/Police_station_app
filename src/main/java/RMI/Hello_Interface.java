package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;


    public interface Hello_Interface extends Remote{
        void Hello_World() throws RemoteException;

    }

