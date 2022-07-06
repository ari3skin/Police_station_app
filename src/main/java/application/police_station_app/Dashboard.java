package application.police_station_app;

import javafx.application.Application;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

public class Dashboard extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane pane3 = new AnchorPane();
        Scene scn3 = new Scene(pane3);

        pane3.setMinSize(700, 500);

        //adding the css file
        String css = Objects.requireNonNull(this.getClass().getResource("Style.css")).toExternalForm();
        scn3.getStylesheets().add(css);

        //adding the application icon
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo1.png")));
        stage.getIcons().add(icon);

        stage.setTitle("Kenya Police Service Program");
        stage.setResizable(false);
        stage.setScene(scn3);
        stage.show();

        //setting images
        InputStream stream = new FileInputStream("src/main/resources/application/police_station_app/KPS-logo-1.png");
        Image img1 = new Image(stream);
        ImageView view = new ImageView();
        view.setImage(img1);

        //defining the controls
        //Vbox Navigation:
        VBox navigation = new VBox();
        Label lbl1 = new Label("Navigation Board");
        Button btn_crimeReport = new Button("Crime Report");
        Button btn_weapons = new Button("Weapons Section");
        Button btn_statistics = new Button("Statistics");
        Button btn_logout = new Button("Logout");

        //Main Anchor pane Content


        //adding the controls to the pane and vbox
        pane3.getChildren().addAll(navigation);
        navigation.getChildren().addAll(view,lbl1,btn_crimeReport,btn_weapons,btn_statistics,btn_logout);

//customizing the controls

        //1.VBox and its children
        navigation.setId("navigation");
        navigation.setPrefSize(170,500);
        navigation.setAlignment(Pos.TOP_LEFT);
        navigation.setSpacing(30);


        //1-1.Images
        view.setFitHeight(74.0);
        view.setFitWidth(102.0);
        view.setLayoutX(14.0);
        view.setLayoutY(110.0);
        view.setPreserveRatio(true);
        navigation.setMargin(view, new Insets(10,0,0,35));

        //1-2.Labels
        lbl1.setPrefSize(147,26);
        lbl1.setId("title");
        navigation.setMargin(lbl1, new Insets(5,0,0,5));

        //1-3.buttons
        btn_crimeReport.setPrefSize(110,45);
        btn_crimeReport.setId("btn_crimeReport");
        navigation.setMargin(btn_crimeReport, new Insets(10,0,0,20));
        btn_crimeReport.setPadding(new Insets(10));
        btn_crimeReport.setCursor(Cursor.cursor("HAND"));

        btn_weapons.setPrefSize(134,45);
        btn_weapons.setId("btn_weapons");
        navigation.setMargin(btn_weapons, new Insets(10,0,0,10));
        btn_weapons.setPadding(new Insets(10));
        btn_weapons.setCursor(Cursor.cursor("HAND"));

        btn_statistics.setPrefSize(100,45);
        btn_statistics.setId("btn_statistics");
        navigation.setMargin(btn_statistics, new Insets(10,0,0,20));
        btn_statistics.setPadding(new Insets(10));
        btn_statistics.setCursor(Cursor.cursor("HAND"));

        btn_logout.setPrefSize(100,45);
        btn_logout.setId("btn_logout");
        navigation.setMargin(btn_logout, new Insets(10,0,0,30));
        btn_logout.setPadding(new Insets(10));
        btn_logout.setCursor(Cursor.cursor("HAND"));

        //below ensures the x close button works
        btn_logout.setOnAction(e -> exit(stage));
        stage.setOnCloseRequest(e -> {
            e.consume();
            exit(stage);
        });
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
}
