module ru.manikinos.profile {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.manikinos.profile to javafx.fxml;
    exports ru.manikinos.profile;
}