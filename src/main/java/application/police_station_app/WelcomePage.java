package application.police_station_app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;

public class WelcomePage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(WelcomePage.class.getResource("WelcomePage.fxml"));
        Scene scn1 = new Scene(loader.load());

        Image icon = new Image("application/police_station_app/logo1.png");
//        Image icon = new Image(new File("application/police_station_app/logo1.png").toURI().toString());
        stage.getIcons().add(icon);

        stage.setTitle("Kenya Police Service Program");
        stage.setScene(scn1);
        stage.show();

        stage.setOnCloseRequest(e -> {
            e.consume();
            exit(stage);
        });
    }

    public void exit(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Program");
        alert.setHeaderText("You are about to Exit");
        alert.setContentText("Press Cancel to go back?");

        if (alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You have exited the program");
            stage.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
