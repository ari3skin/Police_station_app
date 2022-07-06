package application.police_station_app;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

public class Login extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane2 = new AnchorPane();
        Scene scn2 = new Scene(pane2);

        pane2.setMinSize(600, 400);

        //adding the css file
        String css = Objects.requireNonNull(this.getClass().getResource("Style.css")).toExternalForm();
        scn2.getStylesheets().add(css);

        //adding the application icon
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo1.png")));
        stage.getIcons().add(icon);

        stage.setTitle("Kenya Police Service Program");
        stage.setResizable(false);
        stage.setScene(scn2);
        stage.show();

        //setting images
        InputStream stream = new FileInputStream("src/main/resources/application/police_station_app/KPS-logo-1.png");
        Image img1 = new Image(stream);
        ImageView view = new ImageView();
        view.setImage(img1);

        //defining the controls
        Button btn_back = new Button("Back");
        Label lbl3 = new Label("Welcome Back");
        Label lbl4 = new Label("Username :");
        Label lbl5 = new Label("Password :");
        TextField fld_username = new TextField();
        PasswordField fld_password = new PasswordField();
        Button btn_login = new Button("Login");
        Button btn_forgotPassword = new Button("Forgot Password ?");

        //adding the controls to the pane
        pane2.getChildren().addAll(btn_back,view,lbl3,lbl4,lbl5,fld_username,fld_password,btn_login,btn_forgotPassword);

        //customizing the controls
        //1.labels
        lbl3.setLayoutX(360.0);
        lbl3.setLayoutY(70.0);
        lbl3.setPrefHeight(50.0);
        lbl3.setPrefWidth(257.0);
        lbl3.setId("welcome_back");

        lbl4.setLayoutX(317.0);
        lbl4.setLayoutY(145.0);
        lbl4.setPrefHeight(35.0);
        lbl4.setPrefWidth(110.0);
        lbl4.setId("username");

        lbl5.setLayoutX(317.0);
        lbl5.setLayoutY(204.0);
        lbl5.setPrefHeight(35.0);
        lbl5.setPrefWidth(110.0);
        lbl5.setId("password");

        //2.text and password fields
        fld_username.setLayoutX(428.0);
        fld_username.setLayoutY(150.0);
        fld_username.setId("fld_username");
        fld_username.setCursor(Cursor.cursor("TEXT"));

        fld_password.setLayoutX(428.0);
        fld_password.setLayoutY(209.0);
        fld_password.setId("fld_password");
        fld_password.setCursor(Cursor.cursor("TEXT"));

        //3.buttons
        btn_back.setLayoutX(20.0);
        btn_back.setLayoutY(20.0);
        btn_back.setId("btn_exit");
        btn_back.setCursor(Cursor.cursor("HAND"));

        btn_login.setLayoutX(380.0);
        btn_login.setLayoutY(283.0);
        btn_login.setPrefHeight(35.0);
        btn_login.setPrefWidth(59.0);
        btn_login.setMnemonicParsing(false);
        btn_login.setId("btn_login");
        btn_login.setCursor(Cursor.cursor("HAND"));

        btn_forgotPassword.setLayoutX(443.0);
        btn_forgotPassword.setLayoutY(283.0);
        btn_forgotPassword.setPrefHeight(35.0);
        btn_forgotPassword.setPrefWidth(125.0);
        btn_forgotPassword.setMnemonicParsing(false);
        btn_forgotPassword.setId("btn_login");
        btn_forgotPassword.setCursor(Cursor.cursor("HAND"));

        //4.Images
        view.setFitHeight(215.0);
        view.setFitWidth(281.0);
        view.setLayoutX(14.0);
        view.setLayoutY(93.0);
        view.setPreserveRatio(true);

        //below ensures the x close button works
        stage.setOnCloseRequest(e -> {
            e.consume();
            exit(stage);
        });

        //button events
        btn_back.setOnAction(e -> {
            try {
                back();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void exit(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Program");
        alert.setHeaderText("You are about to Exit: Login Page");
        alert.setContentText("Press Cancel to go back");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You have exited the Login Page");
            stage.close();
        }
    }

    public void back() throws Exception {
        Stage stage = new Stage();
        Index obj1 = new Index();
        obj1.start(stage);
    }
}
