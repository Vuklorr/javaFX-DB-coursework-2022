module ru.manikinos.profile {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.h2database;


    opens ru.manikinos.profile to javafx.fxml;
    exports ru.manikinos.profile;
}