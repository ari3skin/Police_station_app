package RMI;


import RMI.models.*;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Client {

    /// The client class will be used by the javafx application to execute queries

    public Hello_Interface stub;

    public Client() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry();
        stub = (Hello_Interface) registry.lookup("kps");
    }

    public void login(String uname, String pass) throws SQLException, RemoteException {
        String query = "";
        stub.execute_imp(query);
    }

    public void register(String fname, String lname, String email, String phone, int nationalID, String password) {
        String query = "";
        try {
            stub.executeUpdate_imp(query);
        } catch (RemoteException e) {
            throw new RuntimeException(e);

        }
    }

    /*public ArrayList<Weapon> weaponsList() throws SQLException, RemoteException {
        String query = Weapon.listQuery;
        ArrayList<Weapon> list = new ArrayList<>();
        ResultSet resultSet = stub.execute_imp(query);
        if (resultSet.next()) {

            list.add(Weapon.fromResultSet(resultSet));
        }
        return list;
    }
    public ArrayList<Police> policeList() throws SQLException, RemoteException {
        String query = Police.listQuery;
        ArrayList<Police> list = new ArrayList<>();
        ResultSet resultSet = stub.execute_imp(query);
        if (resultSet.next()) {

            list.add(Police.fromResultSet(resultSet));
        }
        return list;
    }

    public ArrayList<Case> caseList() throws SQLException, RemoteException {
        String query = Case.listQuery;
        ArrayList<Case> list = new ArrayList<>();
        ResultSet resultSet = stub.execute_imp(query);
        if (resultSet.next()) {
            list.add(Case.fromResultSet(resultSet));
        }
        return list;
    }

    public ArrayList<Crime> crimeList() throws SQLException, RemoteException {
        String query = Crime.listQuery;
        ArrayList<Crime> list = new ArrayList<>();
        ResultSet resultSet = stub.execute_imp(query);
        if (resultSet.next()) {
            list.add(Crime.fromResultSet(resultSet));
        }
        return list;
    }

    public Weapon getWeapon(int id) throws SQLException, RemoteException {
        String query = Weapon.listQuery +"WHERE id="+id;
        ResultSet resultSet = stub.execute_imp(query);
        Weapon weapon = null;
        if(resultSet.next()){
            weapon =  Weapon.fromResultSet(resultSet);
        }
        return  weapon;
    }

    public Case getCase(int id) throws SQLException, RemoteException {
        String query = Case.listQuery +"WHERE id="+id;
        ResultSet resultSet = stub.execute_imp(query);
        Case newcase = null;
        if(resultSet.next()){
            newcase =  Case.fromResultSet(resultSet);
        }
        return  newcase;
    }
    public Crime getCrime(int id) throws SQLException, RemoteException {
        String query = Crime.listQuery +"WHERE id="+id;
        ResultSet resultSet = stub.execute_imp(query);
        Crime newcase = null;
        if(resultSet.next()){
            newcase =  Crime.fromResultSet(resultSet);
        }
        return  newcase;
    }
    public Police getPolice(int id) throws SQLException, RemoteException {
        String query = Police.listQuery +"WHERE id="+id;
        ResultSet resultSet = stub.execute_imp(query);
        Police newcase = null;
        if(resultSet.next()){
            newcase =  Police.fromResultSet(resultSet);
        }
        return  newcase;
    }
    public void registerOfficer(String fname, String lname, String email, String phone, int nationalID, String password) {
        String query = "";
        try {
            stub.executeUpdate_imp(query);
        } catch (RemoteException e) {
            throw new RuntimeException(e);

        }
    }
    public void registerWeapon(String fname, String lname, String email, String phone, int nationalID, String password) {
        String query = "";
        try {
            stub.executeUpdate_imp(query);
        } catch (RemoteException e) {
            throw new RuntimeException(e);

        }
    }
    public void fileCase(String fname, String lname, String email, String phone, int nationalID, String password) {
        String query = "";
        try {
            stub.executeUpdate_imp(query);
        } catch (RemoteException e) {
            throw new RuntimeException(e);

        }
    }
    public void registerCriminal(String fname, String lname, String email, String phone, int nationalID, String password) {
        String query = "";
        try {
            stub.executeUpdate_imp(query);
        } catch (RemoteException e) {
            throw new RuntimeException(e);

        }
    }*/

}
