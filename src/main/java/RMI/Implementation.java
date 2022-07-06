package RMI;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Implementation implements Hello_Interface {
    public ResultSet execute_imp(String query) {
        Database database = null;
        try {
            database = new Database();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            return database.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int executeUpdate_imp(String query)  {
        try {
            return new Database().executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
