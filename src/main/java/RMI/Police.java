package RMI;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Police {
    int id;
    String name;
    String nationalID;
    String patrolUnit;
    public static String listQuery;

    public  Police(int id,String name,String nationalID,String patrolUnit){
        this.id = id;
        this.name = name;
        this.nationalID = nationalID;
        this.patrolUnit = patrolUnit;
    }
    public static Police fromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String nationalID = resultSet.getString("national_id");
        String patrolUnit = resultSet.getString("patrol_unit");

        return new Police(id,name,nationalID,patrolUnit);
    }
}
