package application.police_station_app;

import RMI.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class LoginController {
    Scene scn1;
    FXMLLoader loader;
    Stage stage;
    public void back(ActionEvent e) throws IOException {
        loader = new FXMLLoader(WelcomePageController.class.getResource("WelcomePage.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scn1 = new Scene(loader.load());
        stage.setScene(scn1);
        stage.show();
    }

    // TODO: 05/07/2022 this is a temporary method for navigation. After complete build make sure its deleted
    public void dashboard(ActionEvent e) throws IOException {
        loader = new FXMLLoader(ReportController.class.getResource("Dashboard.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scn1 = new Scene(loader.load());
        stage.setScene(scn1);
        stage.show();
    }
    public void login1(ActionEvent a) throws IOException {
     try {

       Client client = new Client();


    } catch (Exception e) {
        System.err.println("Client exception: " + e.toString());
        e.printStackTrace();
    }
}}
