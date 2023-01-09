package ru.manikinos.profile.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.manikinos.profile.dao.AllDataDAO;
import ru.manikinos.profile.dao.QueryDAO;
import ru.manikinos.profile.entity.query.ProcessingOfPersonalData;
import ru.manikinos.profile.util.SceneMoves;

import java.sql.SQLException;

public class ProcessingOfDataController {

    @FXML
    private Label addressProcessingLabel;

    @FXML
    private Button backButton;

    @FXML
    private TextField idPersonalDataTextField;

    @FXML
    private Label nameProcessingLabel;

    @FXML
    private Button processingButton;

    @FXML
    void back(ActionEvent event) {
        SceneMoves.openNewScene("main-view.fxml", backButton, "Анкетирование");
    }

    @FXML
    void getProcessing(ActionEvent event) throws SQLException, ClassNotFoundException {
        QueryDAO queryDAO = new QueryDAO();
        ProcessingOfPersonalData processing = queryDAO.getProcessing(idPersonalDataTextField.getText());
        nameProcessingLabel.setText(" " + processing.getSurname() + " " + processing.getName() + " "  +processing.getPatronymic());
        addressProcessingLabel.setText(processing.getCountry() + ", г." + processing.getCity() + ", рег." + processing.getRegion() + ", ул." + processing.getStreet() + ", д." + processing.getHouse() + ", кв." + processing.getFlat());
    }

}