package application.police_station_app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

public class Main_App extends Application {
    static Scene scn7;
    static AnchorPane pane7;
    @Override
    public void start(Stage stage) throws Exception {
        //adding the css file
        String css = Objects.requireNonNull(this.getClass().getResource("Style.css")).toExternalForm();

        //adding the application icon
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo1.png")));
        stage.getIcons().add(icon);

        //setting images
        InputStream stream = new FileInputStream("src/main/resources/application/police_station_app/KPS-logo-1.png");
        Image img1 = new Image(stream);
    }
}
