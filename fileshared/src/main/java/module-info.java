module com.vuklorr.fileshared {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.h2database;


    opens com.vuklorr.fileshared to javafx.fxml;
    exports com.vuklorr.fileshared;
}