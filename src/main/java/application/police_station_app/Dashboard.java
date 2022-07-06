package application.police_station_app;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

public class Dashboard extends Application {
    static Scene scn4, scn5;
    static AnchorPane pane4, pane5;

    @Override
    public void start(Stage stage) throws Exception {
        //adding the css file
        String css = Objects.requireNonNull(this.getClass().getResource("Style.css")).toExternalForm();

        //adding the application icon
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo1.png")));
        stage.getIcons().add(icon);

        //setting images
        InputStream stream1 = new FileInputStream("src/main/resources/application/police_station_app/KPS-logo-2.png");
        Image img1 = new Image(stream1);
        InputStream stream2 = new FileInputStream("src/main/resources/application/police_station_app/KPS-logo-1.png");
        Image img2 = new Image(stream2);

//default pane
        pane4 = new AnchorPane();
        scn4 = new Scene(pane4);
        pane4.setMinSize(700, 500);
        scn4.getStylesheets().add(css);

        //defining the controls
        //Vbox Navigation:
        VBox navigation1 = new VBox();
        Label lbl1 = new Label("Navigation Board");
        Button btn_forms = new Button("Filing Forms");
        Button btn_reports = new Button("Reports");
        Button btn_logout = new Button("Logout");
        ImageView view1 = new ImageView();
        view1.setImage(img1);

        //Main Anchor pane Content
//filing forms merged with the default pane
        Label lbl2 = new Label("Utumishi Kwa Wote");
        Label lbl3 = new Label("Filing Forms");
        Button btn_weapons = new Button("Weapons Filing");
        Button btn_cases = new Button("Case Filing");
        Button btn_criminals = new Button("Criminal Filing");
        Button btn_officer_reg = new Button("Officer Registration");
        ImageView view2 = new ImageView();
        view2.setImage(img2);


        //adding the controls to the pane and vbox
        navigation1.getChildren().addAll(view1, lbl1, btn_forms, btn_reports, btn_logout);
        pane4.getChildren().addAll(navigation1);
        pane4.getChildren().addAll(lbl2, lbl3, btn_weapons, btn_cases, view2, btn_criminals, btn_officer_reg);

//customizing the controls

        //1.VBox and its children
        navigation1.setId("navigation");
        navigation1.setPrefSize(170, 500);
        navigation1.setAlignment(Pos.TOP_LEFT);
        navigation1.setSpacing(30);


        //1-1.Images
        view1.setFitHeight(74.0);
        view1.setFitWidth(102.0);
        view1.setLayoutX(14.0);
        view1.setLayoutY(110.0);
        view1.setPreserveRatio(true);
        navigation1.setMargin(view1, new Insets(10, 0, 0, 35));

        //1-2.Labels
        lbl1.setPrefSize(147, 26);
        lbl1.setId("navigation_title");
        navigation1.setMargin(lbl1, new Insets(5, 0, 0, 10));

        //1-3.buttons
        btn_forms.setPrefSize(110, 45);
        btn_forms.setId("btn_crimeReport");
        navigation1.setMargin(btn_forms, new Insets(10, 0, 0, 20));
        btn_forms.setPadding(new Insets(10));
        btn_forms.setCursor(Cursor.cursor("HAND"));
        btn_forms.setId("btn_forms");

        btn_reports.setPrefSize(134, 45);
        btn_reports.setId("btn_weapons");
        navigation1.setMargin(btn_reports, new Insets(10, 0, 0, 10));
        btn_reports.setPadding(new Insets(10));
        btn_reports.setCursor(Cursor.cursor("HAND"));
        btn_reports.setId("btn_reports");

        btn_logout.setPrefSize(100, 45);
        btn_logout.setId("btn_logout");
        navigation1.setMargin(btn_logout, new Insets(10, 0, 0, 30));
        btn_logout.setPadding(new Insets(10));
        btn_logout.setCursor(Cursor.cursor("HAND"));


        //2.Anchor pane and its children
        lbl2.setPrefSize(250, 35);
        lbl2.setLayoutX(300);
        lbl2.setLayoutY(5);
        lbl2.setId("lbl_motto");
        lbl2.setAlignment(Pos.BASELINE_CENTER);

        lbl3.setPrefSize(240, 35);
        lbl3.setLayoutX(292);
        lbl3.setLayoutY(40);
        lbl3.setId("lbl_filling");
        lbl3.setAlignment(Pos.BASELINE_CENTER);

        //2-1.Images
        view2.setFitHeight(150.0);
        view2.setFitWidth(200.0);
        view2.setLayoutX(330.0);
        view2.setLayoutY(206.0);
        view2.setPreserveRatio(true);

        //2-3.Buttons
        btn_weapons.setPrefSize(170, 45);
        btn_weapons.setLayoutX(185.0);
        btn_weapons.setLayoutY(116.0);
        btn_weapons.setMnemonicParsing(false);
        btn_weapons.setId("btn_dashboard");
        btn_weapons.setCursor(Cursor.cursor("HAND"));

        btn_officer_reg.setPrefSize(170, 45);
        btn_officer_reg.setLayoutX(500.0);
        btn_officer_reg.setLayoutY(116.0);
        btn_officer_reg.setMnemonicParsing(false);
        btn_officer_reg.setId("btn_dashboard");
        btn_officer_reg.setCursor(Cursor.cursor("HAND"));

        btn_cases.setPrefSize(170, 45);
        btn_cases.setLayoutX(185.0);
        btn_cases.setLayoutY(356.0);
        btn_cases.setMnemonicParsing(false);
        btn_cases.setId("btn_dashboard");
        btn_cases.setCursor(Cursor.cursor("HAND"));

        btn_criminals.setPrefSize(170, 45);
        btn_criminals.setLayoutX(500.0);
        btn_criminals.setLayoutY(356.0);
        btn_criminals.setMnemonicParsing(false);
        btn_criminals.setId("btn_dashboard");
        btn_criminals.setCursor(Cursor.cursor("HAND"));


//        report generation
        pane5 = new AnchorPane();
        scn5 = new Scene(pane5);
        pane5.setMinSize(700, 500);
        scn5.getStylesheets().add(css);

        //declaring controls
        // Vbox Navigation:
        VBox navigation2 = new VBox();
        Label lbl4 = new Label("Navigation Board");
        Button btn_forms_rep = new Button("Filing Forms");
        Button btn_reports_rep = new Button("Reports");
        Button btn_logout_rep = new Button("Logout");
        ImageView view3 = new ImageView();
        view3.setImage(img1);

        //Main Anchor pane Content
        Label lbl5 = new Label("Utumishi Kwa Wote");
        Label lbl6 = new Label("Report Generation");
        Button btn_crime_report = new Button("Crime Reports");
        Button btn_case_report = new Button("Case Reports");
        Button btn_weapons_report = new Button("Weapons Reports");
        ImageView view4 = new ImageView();
        view4.setImage(img2);

        //adding all controls
        navigation2.getChildren().addAll(view3, lbl4, btn_forms_rep, btn_reports_rep, btn_logout_rep);
        pane5.getChildren().add(navigation2);
        pane5.getChildren().addAll(view4,lbl5, lbl6, btn_crime_report,btn_case_report,btn_weapons_report);

        //customizing controls
        //1.VBox and its children
        navigation2.setId("navigation");
        navigation2.setPrefSize(170, 500);
        navigation2.setAlignment(Pos.TOP_LEFT);
        navigation2.setSpacing(30);


        //1-1.Images
        view3.setFitHeight(74.0);
        view3.setFitWidth(102.0);
        view3.setLayoutX(14.0);
        view3.setLayoutY(110.0);
        view3.setPreserveRatio(true);
        navigation2.setMargin(view3, new Insets(10, 0, 0, 35));

        //1-2.Labels
        lbl4.setPrefSize(147, 26);
        lbl4.setId("navigation_title");
        navigation2.setMargin(lbl4, new Insets(5, 0, 0, 10));

        //1-3.buttons
        btn_forms_rep.setPrefSize(110, 45);
        btn_forms_rep.setId("btn_crimeReport");
        navigation2.setMargin(btn_forms_rep, new Insets(10, 0, 0, 20));
        btn_forms_rep.setPadding(new Insets(10));
        btn_forms_rep.setCursor(Cursor.cursor("HAND"));
        btn_forms_rep.setId("btn_forms");

        btn_reports_rep.setPrefSize(134, 45);
        btn_reports_rep.setId("btn_weapons");
        navigation2.setMargin(btn_reports_rep, new Insets(10, 0, 0, 10));
        btn_reports_rep.setPadding(new Insets(10));
        btn_reports_rep.setCursor(Cursor.cursor("HAND"));
        btn_reports_rep.setId("btn_reports");

        btn_logout_rep.setPrefSize(100, 45);
        btn_logout_rep.setId("btn_logout");
        navigation2.setMargin(btn_logout_rep, new Insets(10, 0, 0, 30));
        btn_logout_rep.setPadding(new Insets(10));
        btn_logout_rep.setCursor(Cursor.cursor("HAND"));


        //2.Anchor pane and its children
        lbl5.setPrefSize(250, 35);
        lbl5.setLayoutX(300);
        lbl5.setLayoutY(5);
        lbl5.setId("lbl_motto");
        lbl5.setAlignment(Pos.BASELINE_CENTER);

        lbl6.setPrefSize(240, 35);
        lbl6.setLayoutX(292);
        lbl6.setLayoutY(40);
        lbl6.setId("lbl_filling");
        lbl6.setAlignment(Pos.BASELINE_CENTER);

        //2-1.Images
        view4.setFitHeight(150.0);
        view4.setFitWidth(200.0);
        view4.setLayoutX(330.0);
        view4.setLayoutY(206.0);
        view4.setPreserveRatio(true);

        //2-3.Buttons
        btn_crime_report.setPrefSize(170, 45);
        btn_crime_report.setLayoutX(185.0);
        btn_crime_report.setLayoutY(116.0);
        btn_crime_report.setMnemonicParsing(false);
        btn_crime_report.setId("btn_dashboard");
        btn_crime_report.setCursor(Cursor.cursor("HAND"));

        btn_case_report.setPrefSize(170, 45);
        btn_case_report.setLayoutX(500.0);
        btn_case_report.setLayoutY(116.0);
        btn_case_report.setMnemonicParsing(false);
        btn_case_report.setId("btn_dashboard");
        btn_case_report.setCursor(Cursor.cursor("HAND"));

        btn_weapons_report.setPrefSize(170, 45);
        btn_weapons_report.setLayoutX(350.0);
        btn_weapons_report.setLayoutY(370.0);
        btn_weapons_report.setMnemonicParsing(false);
        btn_weapons_report.setId("btn_dashboard");
        btn_weapons_report.setCursor(Cursor.cursor("HAND"));



        //below ensures the x close button works
        stage.setOnCloseRequest(e -> {
            e.consume();
            exit(stage);
        });

        //button events
        btn_logout.setOnAction(e -> logout());
        btn_logout_rep.setOnAction(e -> logout());
        btn_forms.setOnAction(e -> stage.setScene(scn4));
        btn_forms_rep.setOnAction(e -> stage.setScene(scn4));
        btn_reports.setOnAction(e -> stage.setScene(scn5));
        btn_reports_rep.setOnAction(e -> stage.setScene(scn5));

        stage.setTitle("Kenya Police Service Program");
        stage.setResizable(false);
        stage.setScene(scn4);
        stage.show();
    }

    public void exit(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Program");
        alert.setHeaderText("You are about to Logout");
        alert.setContentText("Press Cancel to go back");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You have exited the Logout Page");
            stage.close();
        }
    }

    public void logout() {
        Platform.exit();
        System.out.println("You Have Exited the program");
    }
}