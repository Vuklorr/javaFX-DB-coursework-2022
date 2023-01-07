module ru.manikinos.profile {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.h2database;


    opens ru.manikinos.profile to javafx.fxml;
    opens ru.manikinos.profile.entity to javafx.fxml;
    opens ru.manikinos.profile.entity.query to javafx.fxml;
    opens ru.manikinos.profile.controller to javafx.fxml;
    exports ru.manikinos.profile;
    exports ru.manikinos.profile.entity;
    exports ru.manikinos.profile.entity.query;
    exports ru.manikinos.profile.controller;
}