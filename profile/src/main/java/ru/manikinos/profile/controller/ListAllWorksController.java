package ru.manikinos.profile.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.manikinos.profile.dao.QueryDAO;
import ru.manikinos.profile.entity.query.AllWorks;
import ru.manikinos.profile.util.SceneMoves;
import ru.manikinos.profile.util.WorkExperience;

import java.sql.SQLException;

public class ListAllWorksController {

    @FXML
    private Button backButton;
    @FXML
    private Button listAllWorkButton;

    @FXML
    private TextField idPersonalDataTextField;

    @FXML
    private TableView<AllWorks> listWorksTable;

    @FXML
    private TableColumn<AllWorks, String> nameCompanyColumn;

    @FXML
    private TableColumn<AllWorks, String> nameWorkColumn;

    @FXML
    private TableColumn<AllWorks, Integer> salaryColumn;

    @FXML
    private TableColumn<AllWorks, Integer> workExperienceColumn;

    @FXML
    private void getListAllWorks(ActionEvent event) throws SQLException, ClassNotFoundException {
        WorkExperience.workExperience(nameCompanyColumn, nameWorkColumn, salaryColumn, workExperienceColumn, listWorksTable, idPersonalDataTextField.getText());
    }

    @FXML
    private void back(ActionEvent event) {
        SceneMoves.openNewScene("main-view.fxml", backButton, "Анкетирование");
    }
}