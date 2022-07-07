package application.police_station_app;

import RMI.Client;
import RMI.Crime;
import RMI.Criminal;
import RMI.Weapon;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class WeaponReport extends Application {

    Client client;

    {
        try {
            client = new Client();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private TableView table = new TableView();
    private ObservableList<Weapon> weaponsList;

    public  void setTable() throws SQLException, RemoteException {
        ArrayList<Weapon> weapons = client.weaponsList();

        for(int i=0;i<weapons.size();i++){
            Weapon weapon = weapons.get(i);
            if(!Objects.isNull(weapon.officerID)){
                weapon.police = client.getPolice(weapon.officerID);

            }
        }
        weaponsList = FXCollections.observableArrayList(weapons);
        table.setItems(weaponsList);
    }
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws SQLException, RemoteException {
        setTable();
        VBox parent = new VBox();
        parent.setPadding(new Insets(20,20,20,20));
        parent.setMinSize(1000,360);
        //OB NUMBER FIELDS

        //CRIME DETAILS
        TableColumn<Weapon,String> obNumber = new TableColumn("Weapon ID");
        obNumber.setCellValueFactory(data-> {
            return new SimpleStringProperty(String.valueOf(data.getValue().id));
        });
        TableColumn<Weapon,String> criminalTable = new TableColumn("Weapon Name");
        criminalTable.setCellValueFactory(data-> {
            return new SimpleStringProperty(data.getValue().name);
        });
        criminalTable.setMinWidth(100);
        TableColumn<Weapon,String> nationalIDTable = new TableColumn<>("Weapon Type");
        nationalIDTable.setCellValueFactory(data-> {
            return new SimpleStringProperty(String.valueOf(data.getValue().type));
        });

        TableColumn<Weapon,String> date = new TableColumn("Police ID");
        date.setCellValueFactory(data-> {
            return new SimpleStringProperty(String.valueOf(data.getValue().officerID));
        });
        date.setMinWidth(200);

        TableColumn<Weapon,String> serving = new TableColumn("Police Name");
        serving.setCellValueFactory(data-> {
            return new SimpleStringProperty(data.getValue().police.name);
        });
        table.getColumns().addAll(obNumber,criminalTable,nationalIDTable,date,serving);

        parent.getChildren().addAll(table);
        parent.setSpacing(20);
        primaryStage.setTitle("Crime Report");

        Scene scene = new Scene(parent);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
