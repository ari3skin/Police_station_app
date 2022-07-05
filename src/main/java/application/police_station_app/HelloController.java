package application.police_station_app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private LineChart<?, ?> lineChart;

    @FXML
    private LineChart<?,?> lineChart2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inLineChart();
        inLineChart2();
    }

    public XYChart.Series buildSeries(){
        XYChart.Series series = new XYChart.Series();
        return series;
    }
    private void inLineChart() {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("January",8));
        series.getData().add(new XYChart.Data("February",10));
        series.getData().add(new XYChart.Data("March",7));
        series.getData().add(new XYChart.Data("April",29));


//        this.lineChart.getData().addAll(series);
        lineChart.getData().addAll(series);
        lineChart.lookup(".chart-plot-background").setStyle("-fx-background-color:transparent;");
        series.getNode().setStyle("-fx-stroke:#FFD64C");
    }

    private void inLineChart2() {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("January",2));
        series.getData().add(new XYChart.Data("February",3));
        series.getData().add(new XYChart.Data("March",4));
        series.getData().add(new XYChart.Data("April",8));


//        this.lineChart.getData().addAll(series);
        lineChart2.getData().addAll(series);
        lineChart2.lookup(".chart-plot-background").setStyle("-fx-background-color:transparent;");
        series.getNode().setStyle("-fx-stroke:#FFD64C");
    }
}