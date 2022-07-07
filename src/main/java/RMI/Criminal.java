package RMI;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Criminal {
    public int crimeID;

    public int getCrimeID() {
        return crimeID;
    }

    public int getCriminalID() {
        return criminalID;
    }

    public String getCriminalName() {
        return criminalName;
    }

    public int getNationalID() {
        return nationalID;
    }

    public Date getDate() {
        return date;
    }

    public String getNext_kin() {
        return next_kin;
    }

    public int getTerm() {
        return term;
    }

    public int criminalID;
    public String criminalName;
    public int nationalID;
    public Date date;
    public String next_kin;
    public int term;
    public Crime crime;
    public static String listQuery = "SELECT * FROM criminals";
    public Criminal(int crimeID, int criminalID, String criminalName, int nationalID, Date date, String next_kin, int term) {
        this.crimeID = crimeID;
        this.criminalID = criminalID;
        this.criminalName = criminalName;
        this.nationalID = nationalID;
        this.date = date;
        this.next_kin = next_kin;
        this.term = term;
    }

    public static Criminal fromResultSet(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("criminal_ID");
        int crimeID = resultSet.getInt("crime_ID");
        String name = resultSet.getString("Criminal_Name");
        int nationalID = resultSet.getInt("Criminal_National_ID");
        Date date = resultSet.getDate("Date_of_Arrest");
        String next = resultSet.getString("Next_Of_kin");
        int term = resultSet.getInt("Term");
        return  new Criminal(crimeID,id,name,nationalID,date,next,term);
    }

    public String getCrime() {
        return crime.obNumber;
    }

    public String dateFormat(){
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        return DateFor.format(this.date);
    }
}
