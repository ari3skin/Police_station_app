package application.police_station_app;

import RMI.Client;
import RMI.Crime;
import RMI.Criminal;
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

public class CriminalReport extends Application {
    private TableView table = new TableView();
    private ObservableList<Criminal> crimeList;
    Client client;

    {
        try {
            client = new Client();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Criminal> getCriminals(int crimeID) throws SQLException, RemoteException {
        return client.criminalList("SELECT * FROM criminals INNER JOIN crimes_commited ON criminals.Crime_ID=crimes_commited.id WHERE Criminal_National_ID="+crimeID+";");
    }

    public void setTables() throws SQLException, RemoteException {
        ArrayList<Criminal> crimesFinal = new ArrayList<Criminal>();
        ArrayList<Crime> crimes = client.crimeList();
        for(int i=0;i<crimes.size();i++){
            Crime crime = crimes.get(i);
            ArrayList<Criminal> _c = client.criminalList("SELECT * FROM criminals INNER JOIN crimes_commited ON criminals.Crime_ID=crimes_commited.id WHERE Crime_ID="+crime.id+";");
            for(int z=0;z<_c.size();z++){
                _c.get(i).crime=crime;
            }
            crimesFinal.addAll(_c);
        }
        crimeList = FXCollections.observableArrayList(crimesFinal);

        table.setItems(crimeList);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws SQLException, RemoteException {
        setTables();
        VBox parent = new VBox();
        parent.setPadding(new Insets(20, 20, 20, 20));
        parent.setMinSize(1000, 360);
        //OB NUMBER FIELDS
        GridPane obNumberGrid = new GridPane();
        obNumberGrid.setVgap(20);
        obNumberGrid.setHgap(20);
        Text inputLabel = new Text("ID Number");
        obNumberGrid.add(inputLabel, 1, 1);
        TextField obField = new TextField();
        obNumberGrid.add(obField, 1, 2);
        Button fetchCrimeBtn = new Button("Search Crime Database");
        fetchCrimeBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String ob = obField.getText();
                if(!ob.isEmpty()){
                    try {
                        ArrayList<Criminal> criminals = getCriminals(Integer.parseInt(ob));
                        if(criminals.size()>0) {
                            for (int i = 0; i < criminals.size(); i++) {
                                criminals.get(i).crime = client.getCrime(criminals.get(i).crimeID);
                            }
                            crimeList = FXCollections.observableArrayList(criminals);
                            table.setItems(crimeList);
                        }
                        else{
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setContentText("Criminal not present");
                            alert.show();
                        }

                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (RemoteException e) {
                        throw new RuntimeException(e);
                    }
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("A field is empty");
                    alert.show();
                }


            }
        });
        obNumberGrid.add(fetchCrimeBtn, 2, 2);
        //CRIME DETAILS
        TableColumn<Criminal, String> obNumber = new TableColumn("Ob Number");
        obNumber.setCellValueFactory(data -> {
            return new SimpleStringProperty(data.getValue().crime.obNumber);
        });
        TableColumn<Criminal, String> criminalTable = new TableColumn("Criminal Name");
        criminalTable.setCellValueFactory(data -> {
            return new SimpleStringProperty(data.getValue().criminalName);
        });
        TableColumn<Criminal, String> criminalNAID = new TableColumn("Criminal NationalID");
        criminalNAID.setCellValueFactory(data -> {
            return new SimpleStringProperty(String.valueOf(data.getValue().nationalID));
        });

        criminalTable.setMinWidth(100);
        TableColumn<Criminal, String> crimeDate = new TableColumn<>("Crime Date");
        crimeDate.setCellValueFactory(data -> {
            return new SimpleStringProperty(String.valueOf(data.getValue().crime.date));
        });

        TableColumn<Criminal, String> date = new TableColumn("Date of Arrest");
        date.setCellValueFactory(data -> {
            return new SimpleStringProperty(data.getValue().dateFormat());
        });
        date.setMinWidth(200);
        TableColumn<Criminal, String> description = new TableColumn("Crime Description");
        description.setCellValueFactory(data -> {
            return new SimpleStringProperty(data.getValue().dateFormat());
        });

        TableColumn<Criminal, String> serving = new TableColumn("Serving");
        serving.setCellValueFactory(data -> {
            return new SimpleStringProperty(String.valueOf(data.getValue().term));
        });
        table.getColumns().addAll(obNumber, criminalTable,criminalNAID,crimeDate, date, serving);

        parent.getChildren().addAll(obNumberGrid, table);
        parent.setSpacing(20);
        primaryStage.setTitle("Criminals Report");

        Scene scene = new Scene(parent);

        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
