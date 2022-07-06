package RMI;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Weapon{
    int id;
    String name;
    String type;
    String status;
    int officerID;
    public static String listQuery = "";

    public Weapon(int id, String name, String type, String status, int officerID){
        this.id =id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.officerID = officerID;
    }

    public static Weapon fromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String type = resultSet.getString("type");
        String status = resultSet.getString("status");
        int officerID = resultSet.getInt("officer_id");

        Weapon weapon = new Weapon(id, name, type, status, officerID);

        return  weapon;
    }

    @Override
    public String toString() {
        return name;
    }
}
