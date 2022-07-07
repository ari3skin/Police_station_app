package application.police_station_app;

import RMI.Client;
import RMI.Database;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        pane6.setMinSize(580, 500);
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
        Button btn_close = new Button("Close");
        ImageView view1 = new ImageView();
        view1.setImage(img1);

        //main anchor pane content
        Label lbl1 = new Label("Weapons Leasing");
        Label lbl2 = new Label("Officer overseeing lease process");
        Label lbl3 = new Label("Weapon Name");
        Label lbl4 = new Label("Weapon Type");
        Label lbl5 = new Label("Status");
        Label lbl6 = new Label("Officer ID");
        TextField fld_officer_oversee = new TextField();
        TextField fld_weapon_name = new TextField();
        TextField fld_weapon_type = new TextField();
        ChoiceBox fld_status = new ChoiceBox(); fld_status.getItems().add("Leased"); fld_status.getItems().add("Available");
        TextField fld_officer_id = new TextField();
        Button btn_submit = new Button("Submit Details");
        Database client=new Database();
        btn_submit.setOnAction(e -> {
            String Name = fld_weapon_name.getText();
            String Type = fld_weapon_type.getText();
            String status = ("Leased");
            String id = fld_officer_id.getText();

            try {

                String query = "INSERT INTO weapons_list(WeaponsName,WeaponsType,WeaponStatus,OfficerID)" +
                        "VALUES('"+Name+"','"+Type+"','"+status+"','"+id+"')";
                client.executeUpdate(query);
                fld_weapon_name.setPromptText("");
                fld_weapon_type.setPromptText("");
                fld_officer_id.setPromptText("");
                Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                al.setContentText("Successful Registration");
                al.show();


            } catch (Exception ex) {
                Alert al = new Alert(Alert.AlertType.WARNING);
                al.setContentText("Unable to register");
                al.show();
                throw new RuntimeException(ex);

            }
        });

        navigation1.getChildren().addAll(view1,btn_dashboard,btn_cases,btn_criminals,btn_officer_reg,btn_close);
        pane6.getChildren().addAll(navigation1,btn_submit);
        pane6.getChildren().addAll(lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,fld_officer_oversee,fld_weapon_name,fld_weapon_type,fld_status,fld_officer_id);


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
        navigation1.setMargin(btn_dashboard, new Insets(10, 5, 0, 0));
        btn_dashboard.setPadding(new Insets(5));
        btn_dashboard.setCursor(Cursor.cursor("HAND"));
        btn_dashboard.setId("btn_filing_forms");

        btn_cases.setPrefSize(90, 45);
        navigation1.setMargin(btn_cases, new Insets(10, 5, 0, 0));
        btn_cases.setPadding(new Insets(5));
        btn_cases.setCursor(Cursor.cursor("HAND"));
        btn_cases.setId("btn_filing_forms");

        btn_criminals.setPrefSize(110, 45);
        navigation1.setMargin(btn_criminals, new Insets(10, 5, 0, 0));
        btn_criminals.setPadding(new Insets(5));
        btn_criminals.setCursor(Cursor.cursor("HAND"));
        btn_criminals.setId("btn_filing_forms");

        btn_officer_reg.setPrefSize(150, 45);
        navigation1.setMargin(btn_officer_reg, new Insets(10, 5, 0, 0));
        btn_officer_reg.setPadding(new Insets(5));
        btn_officer_reg.setCursor(Cursor.cursor("HAND"));
        btn_officer_reg.setId("btn_filing_forms");

        btn_close.setPrefSize(90, 45);
        navigation1.setMargin(btn_close, new Insets(10, 5, 0, 0));
        btn_close.setPadding(new Insets(5));
        btn_close.setCursor(Cursor.cursor("HAND"));
        btn_close.setId("btn_filing_forms");

        //2.Main Anchor pane and its children
//        2-1.labels
        lbl1.setPrefSize(205, 80);
        lbl1.setLayoutX(250);
        lbl1.setLayoutY(70);
        lbl1.setId("lbl_filling");
        lbl1.setAlignment(Pos.BASELINE_CENTER);

        lbl2.setPrefSize(395, 80);
        lbl2.setLayoutX(14);
        lbl2.setLayoutY(130);
        lbl2.setId("lbl_filling");
        lbl2.setAlignment(Pos.BASELINE_CENTER);

        lbl3.setPrefSize(205, 80);
        lbl3.setLayoutX(50);
        lbl3.setLayoutY(180);
        lbl3.setId("lbl_filling");
        lbl3.setAlignment(Pos.BASELINE_CENTER);

        lbl4.setPrefSize(205, 80);
        lbl4.setLayoutX(50);
        lbl4.setLayoutY(225);
        lbl4.setId("lbl_filling");
        lbl4.setAlignment(Pos.BASELINE_CENTER);

        lbl5.setPrefSize(205, 80);
        lbl5.setLayoutX(50);
        lbl5.setLayoutY(275);
        lbl5.setId("lbl_filling");
        lbl5.setAlignment(Pos.BASELINE_CENTER);

        lbl6.setPrefSize(205, 80);
        lbl6.setLayoutX(50);
        lbl6.setLayoutY(325);
        lbl6.setId("lbl_filling");
        lbl6.setAlignment(Pos.BASELINE_CENTER);

        fld_officer_oversee.setLayoutX(410);
        fld_officer_oversee.setLayoutY(160);

        fld_weapon_name.setLayoutX(280);
        fld_weapon_name.setLayoutY(210);

        fld_weapon_type.setLayoutX(280);
        fld_weapon_type.setLayoutY(255);

        fld_status.setLayoutX(280);
        fld_status.setLayoutY(290);

        fld_officer_id.setLayoutX(280);
        fld_officer_id.setLayoutY(350);

        btn_submit.setPrefSize(150, 45);
        btn_submit.setLayoutX(260);
        btn_submit.setLayoutY(395);
        btn_submit.setPadding(new Insets(5));
        btn_submit.setCursor(Cursor.cursor("HAND"));
        btn_submit.setId("btn_filing_forms");


//        case filing

        pane7 = new AnchorPane();
        scn7 = new Scene(pane7);
        pane7.setMinSize(580, 550);
        scn7.getStylesheets().add(css);


//        declaring controls
        // Vbox Navigation:
        HBox navigation2 = new HBox();
        Button btn_dashboard_case = new Button("Dashboard");
        Button btn_weapons_case = new Button("Weapons Leasing");
        Button btn_criminals_case = new Button("Criminal Filing");
        Button btn_officer_reg_case = new Button("Officer Registration");
        Button btn_close_case = new Button("Close");
        ImageView view2 = new ImageView();
        view2.setImage(img1);

        //Main Anchor Page content
        Label lbl7 = new Label("Case Filing");
        Label lbl8 = new Label("OB Number");
        Label lbl9 = new Label("Officer ID");
        Label lbl10 = new Label("Date-Time");
        Label lbl11 = new Label("Victim National ID");
        Label lbl12 = new Label("Description");
        TextField fld_ob_number = new TextField();
        TextField fld_officer_id_case = new TextField();
        DatePicker fld_date = new DatePicker();
        TextField fld_victim_id = new TextField();
        TextArea fld_description = new TextArea("Describe your Case here:");
        Button btn_clear_case = new Button("Clear Form");
        Button btn_submit_case = new Button("Submit Details");
        btn_submit_case.setOnAction(e -> {
            String Name = fld_officer_id_case.getText();
            String status = ("Leased");
            String id = fld_victim_id.getText();
            String description =fld_description.getText();

            try {

                String query = "INSERT INTO cases(OfficerID,Victim,Description)" +
                        "VALUES('"+Name+"','"+id+"','"+description+"')";
                client.executeUpdate(query);
                fld_officer_id_case.setPromptText("");
                fld_victim_id.setPromptText("");
                fld_description.setPromptText("");
                fld_date.setPromptText("");
                Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                al.setContentText("Successful Registration");
                al.show();


            } catch (Exception ex) {
                Alert al = new Alert(Alert.AlertType.WARNING);
                al.setContentText("Unable to register");
                al.show();
                throw new RuntimeException(ex);

            }
        });

        navigation2.getChildren().addAll(view2,btn_dashboard_case,btn_weapons_case,btn_criminals_case,btn_officer_reg_case,btn_close_case);
        pane7.getChildren().add(navigation2);
        pane7.getChildren().addAll(lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,fld_ob_number,fld_officer_id_case,fld_date,fld_victim_id,fld_description,btn_clear_case,btn_submit_case);

        //customizing controls

        //1.VBox and its children
        navigation2.setId("navigation");
        navigation2.setPrefSize(700, 55);
        navigation2.setAlignment(Pos.TOP_LEFT);
        navigation2.setSpacing(20);


        //1-1.Images
        view2.setFitHeight(78.0);
        view2.setFitWidth(78.0);
        view2.setPickOnBounds(true);
        view2.setPreserveRatio(true);

        //1-2.buttons
        btn_dashboard_case.setPrefSize(90, 45);
        navigation2.setMargin(btn_dashboard_case, new Insets(10,0 , 0, 0));
        btn_dashboard_case.setPadding(new Insets(5));
        btn_dashboard_case.setCursor(Cursor.cursor("HAND"));
        btn_dashboard_case.setId("btn_filing_forms");

        btn_weapons_case.setPrefSize(120, 45);
        navigation2.setMargin(btn_weapons_case, new Insets(10, 0, 0, 0));
        btn_weapons_case.setPadding(new Insets(5));
        btn_weapons_case.setCursor(Cursor.cursor("HAND"));
        btn_weapons_case.setId("btn_filing_forms");

        btn_criminals_case.setPrefSize(110, 45);
        navigation2.setMargin(btn_criminals_case, new Insets(10, 0, 0, 0));
        btn_criminals_case.setPadding(new Insets(5));
        btn_criminals_case.setCursor(Cursor.cursor("HAND"));
        btn_criminals_case.setId("btn_filing_forms");

        btn_officer_reg_case.setPrefSize(150, 45);
        navigation2.setMargin(btn_officer_reg_case, new Insets(10, 0, 0, 0));
        btn_officer_reg_case.setPadding(new Insets(5));
        btn_officer_reg_case.setCursor(Cursor.cursor("HAND"));
        btn_officer_reg_case.setId("btn_filing_forms");

        btn_close_case.setPrefSize(90, 45);
        navigation2.setMargin(btn_close_case, new Insets(10, 5, 0, 0));
        btn_close_case.setPadding(new Insets(5));
        btn_close_case.setCursor(Cursor.cursor("HAND"));
        btn_close_case.setId("btn_filing_forms");

        //2.Main Anchor pane and its children
//        2-1.labels
        lbl7.setPrefSize(205, 80);
        lbl7.setLayoutX(250);
        lbl7.setLayoutY(70);
        lbl7.setId("lbl_filling");
        lbl7.setAlignment(Pos.BASELINE_CENTER);

        lbl8.setPrefSize(205, 80);
        lbl8.setLayoutX(50);
        lbl8.setLayoutY(130);
        lbl8.setId("lbl_filling");
        lbl8.setAlignment(Pos.BASELINE_CENTER);

        lbl9.setPrefSize(205, 80);
        lbl9.setLayoutX(50);
        lbl9.setLayoutY(180);
        lbl9.setId("lbl_filling");
        lbl9.setAlignment(Pos.BASELINE_CENTER);

        lbl10.setPrefSize(205, 80);
        lbl10.setLayoutX(50);
        lbl10.setLayoutY(225);
        lbl10.setId("lbl_filling");
        lbl10.setAlignment(Pos.BASELINE_CENTER);

        lbl11.setPrefSize(305, 80);
        lbl11.setLayoutX(5);
        lbl11.setLayoutY(275);
        lbl11.setId("lbl_filling");
        lbl11.setAlignment(Pos.BASELINE_CENTER);

        lbl12.setPrefSize(205, 80);
        lbl12.setLayoutX(50);
        lbl12.setLayoutY(325);
        lbl12.setId("lbl_filling");
        lbl12.setAlignment(Pos.BASELINE_CENTER);

        fld_ob_number.setLayoutX(280);
        fld_ob_number.setLayoutY(160);
        fld_ob_number.setEditable(false);
        fld_ob_number.setId("fld_ob_number");
        // TODO: 07/07/2022 for this particular field you will use a selsct query to view the ob numbers which are supposed to be auto increment

        fld_officer_id_case.setLayoutX(280);
        fld_officer_id_case.setLayoutY(210);

        fld_date.setLayoutX(280);
        fld_date.setLayoutY(255);

        fld_victim_id.setLayoutX(290);
        fld_victim_id.setLayoutY(300);

        fld_description.setLayoutX(280);
        fld_description.setLayoutY(350);
        fld_description.setPrefSize(200,90);

        btn_clear_case.setPrefSize(100, 35);
        btn_clear_case.setLayoutX(260);
        btn_clear_case.setLayoutY(465);
        btn_clear_case.setPadding(new Insets(5));
        btn_clear_case.setCursor(Cursor.cursor("HAND"));
        btn_clear_case.setId("btn_filing_forms");

        btn_submit_case.setPrefSize(100, 35);
        btn_submit_case.setLayoutX(460);
        btn_submit_case.setLayoutY(465);
        btn_submit_case.setPadding(new Insets(5));
        btn_submit_case.setCursor(Cursor.cursor("HAND"));
        btn_submit_case.setId("btn_filing_forms");


        //button events
        btn_dashboard.setOnAction(e -> {
            Index obj1 = new Index();
            try {
                obj1.dashboard();
                stage.hide();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        btn_dashboard_case.setOnAction(e -> {
            Index obj1 = new Index();
            try {
                obj1.dashboard();
                stage.hide();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        btn_close.setOnAction(e -> stage.close());
        btn_close_case.setOnAction(e -> stage.close());
        btn_weapons_case.setOnAction(e -> stage.setScene(scn6));
        btn_cases.setOnAction(e -> stage.setScene(scn7));
        btn_clear_case.setOnAction(e ->{
            fld_officer_id_case.clear();
            fld_date.getEditor().clear();
            fld_victim_id.clear();
            fld_description.clear();
        });


        stage.setTitle("Kenya Police Service Program");
        stage.setResizable(false);
        stage.setScene(scn6);
        stage.show();
    }

    public void case_filing() throws Exception {

    }
}
