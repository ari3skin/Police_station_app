package application.police_station_app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

public class WelcomePageController {
    @FXML
    AnchorPane pane1;
    Stage stage;
    Scene scn1;
    FXMLLoader loader;

    public void register(@NotNull ActionEvent e) throws IOException {

        loader = new FXMLLoader(WelcomePageController.class.getResource("Register.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        scn1 = new Scene(loader.load());
        stage.setScene(scn1);
        stage.show();
    }
    public void login(@NotNull ActionEvent e) throws IOException {

        loader = new FXMLLoader(WelcomePageController.class.getResource("Login1.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        scn1 = new Scene(loader.load());
        stage.setScene(scn1);
        stage.show();
    }

    public void exit(ActionEvent e){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Program");
        alert.setHeaderText("You are about to Exit");
        alert.setContentText("Press Cancel to go back");

        if (alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) pane1.getScene().getWindow();
            System.out.println("You have exited the program");
            stage.close();
        }
    }
}
