package ru.manikinos.profile.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import ru.manikinos.profile.Main;

import java.io.IOException;

public class SceneMoves {
    public static void openNewScene(String window, Button button, String title) {
        button.getScene().getWindow().hide();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(window));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }
}
