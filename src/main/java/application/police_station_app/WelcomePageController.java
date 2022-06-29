package application.police_station_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomePageController {
    Stage stage;
    Scene scn1;
    Parent root;
    FXMLLoader loader;

    public void register(ActionEvent e) throws IOException {
        loader = new FXMLLoader(WelcomePageController.class.getResource("Register.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scn1 = new Scene(loader.load());
        stage.setScene(scn1);
        stage.show();
    }
    public void login(ActionEvent e) throws IOException {
        loader = new FXMLLoader(WelcomePageController.class.getResource("Login.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scn1 = new Scene(loader.load());
        stage.setScene(scn1);
        stage.show();
    }
}
