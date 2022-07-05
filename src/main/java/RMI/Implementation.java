package RMI;


import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Implementation implements Hello_Interface{
    public ResultSet execute_imp( String query) throws SQLException {
                Database database = new Database();
                return database.execute(query);
             }

             public int executeUpdate_imp(String query) throws SQLException {
                return new Database().executeUpdate(query);
             }
             }
