package application.police_station_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.rmi.NotBoundException;

public class Report extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException, NotBoundException {
//        Parent root = FXMLLoader.load(D.class.getResource("dashboard.fxml"));
//        primaryStage.setTitle("Police Dashboard");
//        primaryStage.setScene(new Scene(root,1000,780));
//        primaryStage.show();
    }
}
