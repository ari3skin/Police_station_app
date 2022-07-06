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

public class Index extends Application {
    static Scene scn1,scn2,scn3;
    static AnchorPane pane1,pane2,pane3;
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

        //Index Scene
        pane1 = new AnchorPane();
        scn1 = new Scene(pane1);
        scn1.getStylesheets().add(css);
        pane1.setMinSize(600, 400);

        //declaring the controls
        Label lbl1 = new Label("Kenya Police Service");
        Label lbl2 = new Label("Police Application");
        Button btn_exit = new Button("Exit App");
        Button btn_register_scn = new Button("Register");
        Button btn_login_scn = new Button("Login");

        ImageView view1 = new ImageView();
        view1.setImage(img1);


        //adding the controls to the pane
        pane1.getChildren().addAll(lbl1, lbl2, btn_login_scn, btn_register_scn, btn_exit, view1);

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
        btn_login_scn.setLayoutX(479.0);
        btn_login_scn.setLayoutY(275.0);
        btn_login_scn.setId("btn_login");
        btn_login_scn.setCursor(Cursor.cursor("HAND"));

        btn_register_scn.setLayoutX(340.0);
        btn_register_scn.setLayoutY(275.0);
        btn_register_scn.setId("btn_register");
        btn_register_scn.setCursor(Cursor.cursor("HAND"));

        btn_exit.setLayoutX(20.0);
        btn_exit.setLayoutY(20.0);
        btn_exit.setId("btn_exit");
        btn_exit.setCursor(Cursor.cursor("HAND"));

        //3.Images
        view1.setFitHeight(150.0);
        view1.setFitWidth(200.0);
        view1.setLayoutX(32.0);
        view1.setLayoutY(125.0);
        view1.setPreserveRatio(true);

        //Login Scene
        pane2 = new AnchorPane();
        scn2 = new Scene(pane2);
        pane2.setMinSize(600, 400);
        scn2.getStylesheets().add(css);

        //defining the controls
        Button btn_back = new Button("Back");
        Label lbl3 = new Label("Welcome Back");
        Label lbl4 = new Label("Username :");
        Label lbl5 = new Label("Password :");
        TextField fld_username = new TextField();
        PasswordField fld_password = new PasswordField();
        Button btn_login = new Button("Login");
        Button btn_forgotPassword = new Button("Forgot Password ?");
        ImageView view2 = new ImageView();
        view2.setImage(img1);

        //adding the controls to the pane
        pane2.getChildren().addAll(btn_back,view2,lbl3,lbl4,lbl5,fld_username,fld_password,btn_login,btn_forgotPassword);

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
        view2.setFitHeight(215.0);
        view2.setFitWidth(281.0);
        view2.setLayoutX(14.0);
        view2.setLayoutY(93.0);
        view2.setPreserveRatio(true);

//        Register Scene
        pane3 = new AnchorPane();
        scn3 = new Scene(pane3);
        pane3.setMinSize(600, 400);
        scn3.getStylesheets().add(css);

        //defining the controls
        Button btn_back_reg = new Button("Back");
        Label lbl6 = new Label("Welcome New User");
        Label lbl7 = new Label("Kindly Provide your details:");
        Label lbl8 = new Label("First Name :");
        Label lbl9 = new Label("Last Name :");
        Label lbl10 = new Label("Email :");
        Label lbl11 = new Label("Phone Number :");
        Label lbl12 = new Label("National Id :");
        Label lbl13 = new Label("Password");
        TextField fld_firstname = new TextField();
        TextField fld_lastname = new TextField();
        TextField fld_email = new TextField();
        TextField fld_phoneNumber = new TextField();
        TextField fld_nationalID = new TextField();
        PasswordField fld_reg_password = new PasswordField();
        Button btn_register = new Button("Register Now !");
        ImageView view3 = new ImageView();
        view3.setImage(img1);

        //adding the controls to the pane
        pane3.getChildren().addAll(btn_back_reg,view3, btn_register, lbl6, lbl7, lbl8, lbl9, lbl10, lbl11, lbl12, lbl13);
        pane3.getChildren().addAll(fld_firstname, fld_lastname, fld_email, fld_phoneNumber, fld_nationalID, fld_reg_password);

//        customizing the controls
//        1.labels
        lbl6.setLayoutX(344.0);
        lbl6.setLayoutY(13.0);
        lbl6.setId("welcome_new");

        lbl7.setLayoutX(310.0);
        lbl7.setLayoutY(50.0);
        lbl7.setId("prompt_1");

        lbl8.setLayoutX(269.0);
        lbl8.setLayoutY(102.0);

        lbl9.setLayoutX(269.0);
        lbl9.setLayoutY(138.0);

        lbl10.setLayoutX(269.0);
        lbl10.setLayoutY(179.0);

        lbl11.setLayoutX(269.0);
        lbl11.setLayoutY(212.0);

        lbl12.setLayoutX(269.0);
        lbl12.setLayoutY(250.0);

        lbl13.setLayoutX(269.0);
        lbl13.setLayoutY(292.0);

//        2.text and password fields
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

        fld_reg_password.setLayoutX(410.0);
        fld_reg_password.setLayoutY(292.0);
        fld_reg_password.setId("fld_register");
        fld_reg_password.setCursor(Cursor.cursor("TEXT"));

//        3.buttons
        btn_back_reg.setLayoutX(20.0);
        btn_back_reg.setLayoutY(20.0);
        btn_back_reg.setId("btn_exit");
        btn_back_reg.setCursor(Cursor.cursor("HAND"));

        btn_register.setLayoutX(441.0);
        btn_register.setLayoutY(340.0);
        btn_register.setMnemonicParsing(false);
        btn_register.setId("btn_register");
        btn_register.setCursor(Cursor.cursor("HAND"));

//        4.Images
        view3.setFitHeight(232.0);
        view3.setFitWidth(227.0);
        view3.setLayoutX(14.0);
        view3.setLayoutY(110.0);
        view3.setPreserveRatio(true);



        //below ensures the x close button works
        stage.setOnCloseRequest(e -> {
            e.consume();
            exit(stage);
        });

        //setting the action events
        btn_exit.setOnAction(e -> exit(stage));
        btn_back.setOnAction(e -> stage.setScene(scn1));
        btn_back_reg.setOnAction(e -> stage.setScene(scn1));
        btn_login_scn.setOnAction(e -> stage.setScene(scn2));
        btn_register_scn.setOnAction(e -> stage.setScene(scn3));

        stage.setTitle("Kenya Police Service Program");
        stage.setResizable(false);
        stage.setScene(scn1);
        stage.show();
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


    public static void main(String[] args) {
        launch(args);
    }
}
