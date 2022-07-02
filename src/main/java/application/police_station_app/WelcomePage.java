package application.police_station_app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class WelcomePage extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        //adding the application icon
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo1.png")));
        stage.getIcons().add(icon);

        //loading the fxml file
        FXMLLoader loader = new FXMLLoader(WelcomePage.class.getResource("WelcomePage.fxml"));
        Scene scn1 = new Scene(loader.load());

        //initiating stage settings
        stage.setTitle("Kenya Police Service Program");
        stage.setResizable(false);
        stage.setScene(scn1);
        stage.show();

        //below ensures the x close button works
        stage.setOnCloseRequest(e -> {
            e.consume();
            exit(stage);
        });
    }

    public void exit(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Program");
        alert.setHeaderText("You are about to Exit");
        alert.setContentText("Press Cancel to go back");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You have exited the program");
            stage.close();
        }
    }

}
