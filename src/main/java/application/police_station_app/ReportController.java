package application.police_station_app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportController implements Initializable {

    @FXML
    private LineChart<?,?> lineChart;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inlineChart();
    }

    private void inlineChart() {
        XYChart.Series series = new XYChart.Series();
        series.getData().add(new XYChart.Data("January",8));
        series.getData().add(new XYChart.Data("February",10));
        lineChart.getData().addAll(series);
    }




}
