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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class CrimeReport extends Application {
    Client client;

    {
        try {
            client = new Client();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Crime getCrime(int obNumber) throws SQLException, RemoteException {
        return client.getCrime(obNumber);
    }
    public ArrayList<Criminal> getCriminals() throws SQLException, RemoteException {
        ArrayList<Criminal> _criminals = client.criminalList("SELECT * FROM criminals;");
        for(int i=0;i< _criminals.size();i++){
            _criminals.get(i).crime = client.getCrime(_criminals.get(i).crimeID);
        }
        return _criminals;
    }
    public ArrayList<Criminal> getCriminals(int crimeID) throws SQLException, RemoteException {
        return client.criminalList("SELECT * FROM criminals INNER JOIN crimes_commited ON criminals.Crime_ID=crimes_commited.id WHERE ob_number="+crimeID+";");
    }

    public static void main(String[] args) {
        launch(args);
    }
    private TableView table = new TableView();
    private ObservableList<Criminal> criminalsList;
    @Override
    public void start(Stage primaryStage) throws SQLException, RemoteException {
        criminalsList = FXCollections.observableArrayList(getCriminals());
        table.setItems(criminalsList);
        VBox parent = new VBox();
        parent.setPadding(new Insets(20,20,20,20));
        parent.setMinSize(1000,360);
        //OB NUMBER FIELDS
        GridPane obNumberGrid = new GridPane();
        obNumberGrid.setVgap(20);
        obNumberGrid.setHgap(20);
        Text inputLabel = new Text("OB Number");
        obNumberGrid.add(inputLabel,1,1);
        TextField obField = new TextField();
        obNumberGrid.add(obField,1,2);
        Button fetchCrimeBtn = new Button("Fetch Crime");
        fetchCrimeBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                String ob = obField.getText();
                if(!ob.isEmpty()) {
                    try {
                        Crime crime = getCrime(Integer.parseInt(ob));
                        if (!Objects.isNull(crime)) {
                            ArrayList<Criminal> criminals = getCriminals(crime.id);
                            for (int i = 0; i < criminals.size(); i++) {
                                criminals.get(i).crime = crime;
                            }
                            criminalsList = FXCollections.observableArrayList(criminals);
                            table.setItems(criminalsList);
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setContentText("Crime not found");
                            alert.setTitle("Invalid OB Number");
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
        obNumberGrid.add(fetchCrimeBtn,2,2);
        //CRIME DETAILS
        TableColumn<Criminal,String> obNumber = new TableColumn("Ob Number");
        obNumber.setCellValueFactory(data-> {
            return new SimpleStringProperty(data.getValue().crime.obNumber);
        });
        TableColumn<Criminal,String> criminalTable = new TableColumn("Criminal Name");
        criminalTable.setCellValueFactory(data-> {
            return new SimpleStringProperty(data.getValue().criminalName);
        });
        criminalTable.setMinWidth(100);
        TableColumn<Criminal,String> nationalIDTable = new TableColumn<>("National Id");
        nationalIDTable.setCellValueFactory(data-> {
            return new SimpleStringProperty(String.valueOf(data.getValue().nationalID));
        });

        TableColumn<Criminal,String> date = new TableColumn("Date of Arrest");
        date.setCellValueFactory(data-> {
            return new SimpleStringProperty(data.getValue().dateFormat());
        });
        date.setMinWidth(200);

        TableColumn<Criminal,String> serving = new TableColumn("Serving");
        serving.setCellValueFactory(data-> {
            return new SimpleStringProperty(String.valueOf(data.getValue().term));
        });
        table.getColumns().addAll(obNumber,criminalTable,nationalIDTable,date,serving);

        parent.getChildren().addAll(obNumberGrid,table);
        parent.setSpacing(20);
        primaryStage.setTitle("Crime Report");

        Scene scene = new Scene(parent);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
