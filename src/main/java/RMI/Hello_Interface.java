package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.*;

    public interface Hello_Interface extends Remote{
        void Hello_World() throws RemoteException;
        /// Returns a boolean if query is successful
        boolean register_officer(String id,String name,int nationalID,String unit) throws RemoteException;
        boolean add_crime(String date,boolean solved,String obNumber,String description);
        boolean add_criminal(String name,int nationalID,String date,String nextOfKin,int crimeID,int timeServe,boolean suspect);

        boolean add_weapon(String name,String type,boolean status,String officerID);
        boolean add_case(String officerID,String date,int nationalID,String description);

        ResultSet weaponsList();

        ResultSet policeList();
        ResultSet caseList();
        ResultSet crimeList();
        ResultSet criminalList();


    }

