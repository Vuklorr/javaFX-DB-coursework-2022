module com.vuklorr.fileshared {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.h2database;
    requires lombok;


    opens com.vuklorr.fileshared to javafx.fxml;
    opens com.vuklorr.fileshared.controller to javafx.fxml;
    opens com.vuklorr.fileshared.entity to javafx.fxml;
    exports com.vuklorr.fileshared;
    exports com.vuklorr.fileshared.controller;
    exports com.vuklorr.fileshared.entity;
}