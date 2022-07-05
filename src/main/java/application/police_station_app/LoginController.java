package application.police_station_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
}
