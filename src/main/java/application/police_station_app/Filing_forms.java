package application.police_station_app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

public class Filing_forms extends Application {
    static Scene scn6,scn7,scn8,scn9;
    static AnchorPane pane6,pane7,pane8,pane9;
    private String css = Objects.requireNonNull(this.getClass().getResource("Style.css")).toExternalForm();
    static InputStream stream;
    static Image img1;
    static Stage stage;
    @Override
    public void start(Stage stage) throws Exception {

        //adding the application icon
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("logo1.png")));
        stage.getIcons().add(icon);

        pane6 = new AnchorPane();
        scn6 = new Scene(pane6);
        pane6.setMinSize(700, 500);
        scn6.getStylesheets().add(css);
        stream = new FileInputStream("src/main/resources/application/police_station_app/KPS-logo-2.png");
        img1 = new Image(stream);


//declaring controls
        // Vbox Navigation:
        HBox navigation1 = new HBox();
        Button btn_dashboard = new Button("Dashboard");
        Button btn_cases = new Button("Case Filing");
        Button btn_criminals = new Button("Criminal Filing");
        Button btn_officer_reg = new Button("Officer Registration");
        Button btn_logout = new Button("Logout");
        ImageView view1 = new ImageView();
        view1.setImage(img1);

        navigation1.getChildren().addAll(view1,btn_dashboard,btn_cases,btn_criminals,btn_officer_reg,btn_logout);
        pane6.getChildren().addAll(navigation1);


//customizing controls

        //1.VBox and its children
        navigation1.setId("navigation");
        navigation1.setPrefSize(700, 55);
        navigation1.setAlignment(Pos.TOP_LEFT);
        navigation1.setSpacing(30);


        //1-1.Images
        view1.setFitHeight(78.0);
        view1.setFitWidth(78.0);
        view1.setPickOnBounds(true);
        view1.setPreserveRatio(true);

        //1-2.buttons
        btn_dashboard.setPrefSize(90, 45);
        btn_dashboard.setId("btn_crimeReport");
        navigation1.setMargin(btn_dashboard, new Insets(10, 5, 0, 0));
        btn_dashboard.setPadding(new Insets(5));
        btn_dashboard.setCursor(Cursor.cursor("HAND"));
        btn_dashboard.setId("btn_filing_forms");

        btn_cases.setPrefSize(90, 45);
        btn_cases.setId("btn_crimeReport");
        navigation1.setMargin(btn_cases, new Insets(10, 5, 0, 0));
        btn_cases.setPadding(new Insets(5));
        btn_cases.setCursor(Cursor.cursor("HAND"));
        btn_cases.setId("btn_filing_forms");

        btn_criminals.setPrefSize(110, 45);
        btn_criminals.setId("btn_crimeReport");
        navigation1.setMargin(btn_criminals, new Insets(10, 5, 0, 0));
        btn_criminals.setPadding(new Insets(5));
        btn_criminals.setCursor(Cursor.cursor("HAND"));
        btn_criminals.setId("btn_filing_forms");

        btn_officer_reg.setPrefSize(150, 45);
        btn_officer_reg.setId("btn_crimeReport");
        navigation1.setMargin(btn_officer_reg, new Insets(10, 5, 0, 0));
        btn_officer_reg.setPadding(new Insets(5));
        btn_officer_reg.setCursor(Cursor.cursor("HAND"));
        btn_officer_reg.setId("btn_filing_forms");

        btn_logout.setPrefSize(90, 45);
        btn_logout.setId("btn_crimeReport");
        navigation1.setMargin(btn_logout, new Insets(10, 5, 0, 0));
        btn_logout.setPadding(new Insets(5));
        btn_logout.setCursor(Cursor.cursor("HAND"));
        btn_logout.setId("btn_filing_forms");

        //button events
        btn_cases.setOnAction(e -> {
            try {
                case_filing();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });

        stage.setTitle("Kenya Police Service Program");
        stage.setResizable(false);
        stage.setScene(scn6);
        stage.show();
    }

    public void case_filing() throws Exception {
        pane7 = new AnchorPane();
        scn7 = new Scene(pane7);
        pane7.setMinSize(700, 500);
        scn7.getStylesheets().add(css);


        //declaring controls
        // Vbox Navigation:
        HBox navigation1 = new HBox();
        Button btn_dashboard = new Button("Dashboard");
        Button btn_cases = new Button("Case Filing");
        Button btn_criminals = new Button("Criminal Filing");
        Button btn_officer_reg = new Button("Officer Registration");
        Button btn_logout = new Button("Logout");
        ImageView view1 = new ImageView();
        view1.setImage(img1);
        stage.setScene(scn7);
        stage.show();
    }
}
