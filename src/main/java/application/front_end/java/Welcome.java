package application.front_end.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Welcome extends Application {
    FXMLLoader loader;
    Scene scn1;
    String css;
    @Override
    public void start(Stage stage) throws Exception {
        loader = new FXMLLoader(Welcome.class.getResource("Welcome.fxml"));
        scn1 = new Scene(loader.load());

        css = Objects.requireNonNull(this.getClass().getResource("Welcome.css")).toExternalForm();
        scn1.getStylesheets().add(css);

        stage.setScene(scn1);
        stage.setTitle("Kenya Police Program");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
