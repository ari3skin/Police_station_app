module application.police_station_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires eu.hansolo.tilesfx;
    requires java.rmi;

    requires java.sql;
    requires org.jetbrains.annotations;

    opens application.police_station_app to javafx.fxml;
    exports application.police_station_app;
}