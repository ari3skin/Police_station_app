package RMI;


import java.rmi.RemoteException;
import java.sql.ResultSet;

public class Implementation implements Hello_Interface{

        @Override
        public void Hello_World()
        {
           System.out.println("Hello World");

        }

    @Override
    public boolean register_officer(String id, String name, int nationalID, String unit) throws RemoteException {
        return false;
    }

    @Override
    public boolean add_crime(String date, boolean solved, String obNumber, String description) {
        return false;
    }

    @Override
    public boolean add_criminal(String name, int nationalID, String date, String nextOfKin, int crimeID, int timeServe, boolean suspect) {
        return false;
    }

    @Override
    public boolean add_weapon(String name, String type, boolean status, String officerID) {
        return false;
    }

    @Override
    public boolean add_case(String officerID, String date, int nationalID, String description) {
        return false;
    }

    @Override
    public ResultSet weaponsList() {
        return null;
    }

    @Override
    public ResultSet policeList() {
        return null;
    }

    @Override
    public ResultSet caseList() {
        return null;
    }

    @Override
    public ResultSet crimeList() {
        return null;
    }

    @Override
    public ResultSet criminalList() {
        return null;
    }

}

