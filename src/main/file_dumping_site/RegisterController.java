package application.police_station_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class RegisterController {
    Scene scn1;
    FXMLLoader loader;
    Stage stage;

    public void back(ActionEvent e) throws IOException {
        loader = new FXMLLoader(WelcomePageController.class.getResource("WelcomePage.fxml"));
        scn1 = new Scene(loader.load());
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scn1);
        stage.show();
    }

    // TODO: 05/07/2022 a method to capture data for registering the user is to be made before the one below 
    public void login(ActionEvent e) throws IOException {
        loader = new FXMLLoader(DashboardController.class.getResource("Dashboard.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scn1 = new Scene(loader.load());
        stage.setScene(scn1);
        stage.show();
    }
}
