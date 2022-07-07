package RMI;


import java.rmi.RemoteException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Client {


    Database stub = new Database();

    public Client() throws SQLException {
    }

    public void login(String uname, String pass) throws SQLException, RemoteException {
        String query = "";
        stub.execute(query);
    }

    public void register(String fname, String lname, String email, String phone, int nationalID, String password) throws SQLException {
        String query = "";
        stub.executeUpdate(query);
    }

    public ArrayList<Weapon> weaponsList() throws SQLException, RemoteException {
        String query = Weapon.listQuery;
        ArrayList<Weapon> list = new ArrayList<>();
        ResultSet resultSet = stub.execute(query);
        if (resultSet.next()) {

            list.add(Weapon.fromResultSet(resultSet));
        }
        return list;
    }

    public ArrayList<Police> policeList() throws SQLException, RemoteException {
        String query = Police.listQuery;
        ArrayList<Police> list = new ArrayList<>();
        ResultSet resultSet = stub.execute(query);
        if (resultSet.next()) {

            list.add(Police.fromResultSet(resultSet));
        }
        return list;
    }

    public ArrayList<Case> caseList() throws SQLException, RemoteException {
        String query = Case.listQuery;
        ArrayList<Case> list = new ArrayList<>();
        ResultSet resultSet = stub.execute(query);
        if (resultSet.next()) {
            list.add(Case.fromResultSet(resultSet));
        }
        return list;
    }

    public ArrayList<Crime> crimeList() throws SQLException, RemoteException {
        String query = Crime.listQuery;
        ArrayList<Crime> list = new ArrayList<>();
        ResultSet resultSet = stub.execute(query);
        if (resultSet.next()) {
            list.add(Crime.fromResultSet(resultSet));
        }
        return list;
    }
    public ArrayList<Crime> crimeList(String query) throws SQLException, RemoteException {
        ArrayList<Crime> list = new ArrayList<>();
        ResultSet resultSet = stub.execute(query);
        if (resultSet.next()) {
            list.add(Crime.fromResultSet(resultSet));
        }
        return list;
    }
    public ArrayList<Criminal> criminalList(String query) throws SQLException, RemoteException {
        ArrayList<Criminal> list = new ArrayList<>();
        ResultSet resultSet = stub.execute(query);
        if (resultSet.next()) {
            list.add(Criminal.fromResultSet(resultSet));
        }
        return list;
    }

    public Weapon getWeapon(int id) throws SQLException, RemoteException {
        String query = Weapon.listQuery + "WHERE id=" + id;
        ResultSet resultSet = stub.execute(query);
        Weapon weapon = null;
        if (resultSet.next()) {
            weapon = Weapon.fromResultSet(resultSet);
        }
        return weapon;
    }

    public Case getCase(int id) throws SQLException, RemoteException {
        String query = Case.listQuery + "WHERE id=" + id;
        ResultSet resultSet = stub.execute(query);
        Case newcase = null;
        if (resultSet.next()) {
            newcase = Case.fromResultSet(resultSet);
        }
        return newcase;
    }

    public Crime getCrime(int id) throws SQLException, RemoteException {
        String query = Crime.listQuery + "WHERE id=" + id+";";
        ResultSet resultSet = stub.execute(query);
        Crime newcase = null;
        if (resultSet.next()) {
            newcase = Crime.fromResultSet(resultSet);
        }
        return newcase;
    }

    public Police getPolice(int id) throws SQLException, RemoteException {
        String query = Police.listQuery + "WHERE id=" + id;
        ResultSet resultSet = stub.execute(query);
        Police newcase = null;
        if (resultSet.next()) {
            newcase = Police.fromResultSet(resultSet);
        }
        return newcase;
    }

}
