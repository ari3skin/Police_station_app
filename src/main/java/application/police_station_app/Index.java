package application.police_station_app;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;

public class Index extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane1 = new AnchorPane();
        Scene scn1 = new Scene(pane1);

        pane1.setMinSize(600, 400);

        //adding the css file
        String css = Objects.requireNonNull(this.getClass().getResource("Style.css")).toExternalForm();
        scn1.getStylesheets().add(css);

        //adding the application icon
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo1.png")));
        stage.getIcons().add(icon);

        stage.setTitle("Kenya Police Service Program");
        stage.setResizable(false);
        stage.setScene(scn1);
        stage.show();

        //setting images
        InputStream stream = new FileInputStream("src/main/resources/application/police_station_app/KPS-logo-1.png");
        Image img1 = new Image(stream);
        ImageView view = new ImageView();
        view.setImage(img1);

        //declaring the controls
        Label lbl1 = new Label("Kenya Police Service");
        Label lbl2 = new Label("Police Application");
        Button btn_exit = new Button("Exit App");
        Button btn_register = new Button("Register");
        Button btn_login = new Button("Login");


        //adding the controls to the pane
        pane1.getChildren().addAll(lbl1, lbl2, btn_login, btn_register, btn_exit, view);

        //customizing the controls
        //1.labels
        lbl1.setLayoutX(214.0);
        lbl1.setLayoutY(58.0);
        lbl1.setPrefHeight(54.0);
        lbl1.setPrefWidth(372.0);
        lbl1.setId("kpsLabel");

        lbl2.setLayoutX(400.0);
        lbl2.setLayoutY(150.0);
        lbl2.setPrefHeight(50.0);
        lbl2.setPrefWidth(175.0);
        lbl2.setId("policeLabel");


        //2.buttons
        btn_login.setLayoutX(479.0);
        btn_login.setLayoutY(275.0);
        btn_login.setId("btn_login");
        btn_login.setCursor(Cursor.cursor("HAND"));

        btn_register.setLayoutX(340.0);
        btn_register.setLayoutY(275.0);
        btn_register.setId("btn_register");
        btn_register.setCursor(Cursor.cursor("HAND"));

        btn_exit.setLayoutX(20.0);
        btn_exit.setLayoutY(20.0);
        btn_exit.setId("btn_exit");
        btn_exit.setCursor(Cursor.cursor("HAND"));

        //3.Images
        view.setFitHeight(150.0);
        view.setFitWidth(200.0);
        view.setLayoutX(32.0);
        view.setLayoutY(125.0);
        view.setPreserveRatio(true);


        //below ensures the x close button works
        stage.setOnCloseRequest(e -> {
            e.consume();
            exit(stage);
        });

        //setting the action events
        btn_exit.setOnAction(e -> exit(stage));
        btn_login.setOnAction(e -> {
            try {
                login();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        btn_register.setOnAction(e -> {
            try {
                register();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
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

    public void login() throws Exception {
        Stage stage = new Stage();
        Login obj1 = new Login();
        obj1.start(stage);
    }

    public void register() throws Exception {
        Stage stage = new Stage();
        Register obj1 = new Register();
        obj1.start(stage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
