package RMI;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Police {
    public int id;
    public String name ="";
    public String nationalID="";
    public String patrolUnit="";
    public static String listQuery = "SELECT * FROM officers ";

    public  Police(int id,String name,String nationalID,String patrolUnit){
        this.id = id;
        this.name = name;
        this.nationalID = nationalID;
        this.patrolUnit = patrolUnit;
    }
    public static Police fromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Officers ID");
        String name = resultSet.getString("Officers Name");
        String nationalID = resultSet.getString("National ID");
        String patrolUnit = resultSet.getString("Patrol Unit");

        return new Police(id,name,nationalID,patrolUnit);
    }
}
