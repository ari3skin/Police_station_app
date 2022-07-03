package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


    public class Server extends Implementation {
        public Server() {}
        public static void main(String args[]) {
            try {

                Implementation obj = new Implementation();


                Hello_Interface hh = (Hello_Interface) UnicastRemoteObject.exportObject(obj, 0);


                Registry registry = LocateRegistry.getRegistry();

                registry.bind("hh_bind-name", hh);
                System.err.println("Server is Running");
            } catch (Exception e) {
                System.err.println("Server exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }

