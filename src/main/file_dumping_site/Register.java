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

public class Register extends Application {
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
        Label lbl3 = new Label("Welcome New User");
        Label lbl4 = new Label("Kindly Provide your details:");
        Label lbl5 = new Label("First Name :");
        Label lbl6 = new Label("Last Name :");
        Label lbl7 = new Label("Email :");
        Label lbl8 = new Label("Phone Number :");
        Label lbl9 = new Label("National Id :");
        Label lbl10 = new Label("Password");
        TextField fld_firstname = new TextField();
        TextField fld_lastname = new TextField();
        TextField fld_email = new TextField();
        TextField fld_phoneNumber = new TextField();
        TextField fld_nationalID = new TextField();
        PasswordField fld_password = new PasswordField();
        Button btn_register = new Button("Register Now !");

        //adding the controls to the pane
        pane2.getChildren().addAll(btn_back,view,btn_register,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10);
        pane2.getChildren().addAll(fld_firstname,fld_lastname,fld_email,fld_phoneNumber,fld_nationalID,fld_password);

        //customizing the controls
        //1.labels
        lbl3.setLayoutX(344.0);
        lbl3.setLayoutY(13.0);
        lbl3.setId("welcome_new");

        lbl4.setLayoutX(310.0);
        lbl4.setLayoutY(50.0);
        lbl4.setId("prompt_1");

        lbl5.setLayoutX(269.0);
        lbl5.setLayoutY(102.0);

        lbl6.setLayoutX(269.0);
        lbl6.setLayoutY(138.0);

        lbl7.setLayoutX(269.0);
        lbl7.setLayoutY(179.0);

        lbl8.setLayoutX(269.0);
        lbl8.setLayoutY(212.0);

        lbl9.setLayoutX(269.0);
        lbl9.setLayoutY(250.0);

        lbl10.setLayoutX(269.0);
        lbl10.setLayoutY(292.0);

        //2.text and password fields
        fld_firstname.setLayoutX(410.0);
        fld_firstname.setLayoutY(102.0);
        fld_firstname.setId("fld_register");
        fld_firstname.setCursor(Cursor.cursor("TEXT"));

        fld_lastname.setLayoutX(410.0);
        fld_lastname.setLayoutY(138.0);
        fld_lastname.setId("fld_register");
        fld_lastname.setCursor(Cursor.cursor("TEXT"));

        fld_email.setLayoutX(410.0);
        fld_email.setLayoutY(179.0);
        fld_email.setId("fld_register");
        fld_email.setCursor(Cursor.cursor("TEXT"));

        fld_phoneNumber.setLayoutX(410.0);
        fld_phoneNumber.setLayoutY(212.0);
        fld_phoneNumber.setId("fld_register");
        fld_phoneNumber.setCursor(Cursor.cursor("TEXT"));

        fld_nationalID.setLayoutX(410.0);
        fld_nationalID.setLayoutY(250.0);
        fld_nationalID.setId("fld_register");
        fld_nationalID.setCursor(Cursor.cursor("TEXT"));

        fld_password.setLayoutX(410.0);
        fld_password.setLayoutY(292.0);
        fld_password.setId("fld_register");
        fld_password.setCursor(Cursor.cursor("TEXT"));

        //3.buttons
        btn_back.setLayoutX(20.0);
        btn_back.setLayoutY(20.0);
        btn_back.setId("btn_exit");
        btn_back.setCursor(Cursor.cursor("HAND"));

        btn_register.setLayoutX(441.0);
        btn_register.setLayoutY(340.0);
        btn_register.setMnemonicParsing(false);
        btn_register.setId("btn_register");
        btn_register.setCursor(Cursor.cursor("HAND"));

        //4.Images
        view.setFitHeight(232.0);
        view.setFitWidth(227.0);
        view.setLayoutX(14.0);
        view.setLayoutY(110.0);
        view.setPreserveRatio(true);

        //below ensures the x close button works
        stage.setOnCloseRequest(e -> {
            e.consume();
            exit(stage);
        });

        //button events
        btn_back.setOnAction(e -> {
            try {
                Login obj1 = new Login();
                obj1.back();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public void exit(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Program");
        alert.setHeaderText("You are about to Exit: Registration Page");
        alert.setContentText("Press Cancel to go back");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You have exited the Registration Page");
            stage.close();
        }
    }
}
