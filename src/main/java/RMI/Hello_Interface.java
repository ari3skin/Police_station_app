package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.*;
public interface Hello_Interface extends Remote{
        ResultSet execute_imp( String query) throws SQLException; // Execute queries
        int executeUpdate_imp(String query) throws SQLException;
}

