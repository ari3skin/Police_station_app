package application.police_station_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class WelcomePage extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(WelcomePage.class.getResource("WelcomePage.fxml"));
        Scene scn1 = new Scene(loader.load());

        String css = this.getClass().getResource("Style.css").toExternalForm();
        scn1.getStylesheets().add(css);

//        Image icon = new Image("application/police_station_app/Kenya-logo-1.png");
//        stage.getIcons().add(icon);

        stage.setTitle("Kenya Police Service Program");
        stage.setScene(scn1);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
