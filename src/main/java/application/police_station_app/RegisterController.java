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
}
