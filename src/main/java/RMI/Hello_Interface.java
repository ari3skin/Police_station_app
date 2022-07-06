package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
public interface Hello_Interface extends Remote{
        ResultSet execute_imp( String query) throws RemoteException; // Execute queries
        int executeUpdate_imp(String query) throws RemoteException;
}

