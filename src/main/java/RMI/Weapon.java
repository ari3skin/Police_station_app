package RMI;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Weapon{
    public int id;
    public String name;
    public String type;
    public String status;
    public int officerID;

    public Police police;
    public static String listQuery = "SELECT * FROM `weapons list`;";

    public Weapon(int id, String name, String type, String status, int officerID){
        this.id =id;
        this.name = name;
        this.type = type;
        this.status = status;
        this.officerID = officerID;
    }

    public static Weapon fromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Weapons ID");
        String name = resultSet.getString("Weapons Name");
        String type = resultSet.getString("Weapons Type");
        String status = resultSet.getString("Weapon Status");
        int officerID = resultSet.getInt("Officer ID");

        Weapon weapon = new Weapon(id, name, type, status, officerID);

        return  weapon;
    }

    @Override
    public String toString() {
        return name;
    }
}
