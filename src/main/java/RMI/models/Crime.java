package RMI.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Crime {
    int id;
    String date;
    String obNumber;
    boolean solved;
    String description;
    public static String listQuery;
    public Crime(int id, String date, String obNumber, boolean solved, String description) {
        this.id = id;
        this.date = date;
        this.obNumber = obNumber;
        this.solved = solved;
        this.description = description;
    }

    public static Crime fromResultSet(ResultSet resultSet) throws SQLException {
        int crimeID = resultSet.getInt("id");
        String ob = resultSet.getString("ob_number");
        String date = resultSet.getString("date");
        boolean solved = resultSet.getBoolean("solved");

        String description = resultSet.getString("description");
        return new Crime(crimeID,date,ob,solved,description);

    }

    @Override
    public String toString() {
        return  obNumber;
    }
}
