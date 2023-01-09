module com.vuklorr.fileshared {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vuklorr.fileshared to javafx.fxml;
    exports com.vuklorr.fileshared;
}