package RMI;


import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Implementation implements Hello_Interface{
    public ResultSet execute_imp( String query) throws SQLException {
                return  Database.execute(query);
             }

             public int executeUpdate_imp(String query) throws SQLException {
                return Database.executeUpdate(query);
             }
}

