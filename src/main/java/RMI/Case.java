package RMI;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Case {

    String obNumber;
    int officerID;
    String dateTime;
    String nationalID;
    String description;
    public static String listQuery;

    public Case(String a, int b, String c, String d, String e) {
        obNumber = a;
        officerID = b;
        dateTime = c;
        nationalID = d;
        description = e;

    }

    public static Case fromResultSet(ResultSet resultSet) throws SQLException {
        int officerID = resultSet.getInt("officer_id");
        String ob = resultSet.getString("ob_number");
        String nationalID = resultSet.getString("national_id");
        String date = resultSet.getString("date");


        String description = resultSet.getString("description");

        return new Case(ob,officerID,date,nationalID,description);
    }

    @Override
    public String toString() {
        return obNumber;
    }
}
