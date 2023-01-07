package ru.manikinos.profile.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ru.manikinos.profile.dao.QueryDAO;
import ru.manikinos.profile.entity.query.AllWorks;
import ru.manikinos.profile.entity.query.WorkBook;
import ru.manikinos.profile.util.SceneMoves;
import ru.manikinos.profile.util.WorkExperience;

import java.sql.SQLException;

public class WorkBookController {

    @FXML
    private Button backButton;

    @FXML
    private TextField idPersonalDataTextField;

    @FXML
    private TableView<AllWorks> listWorksTable;

    @FXML
    private TableColumn<AllWorks, String> nameCompanyColumn;

    @FXML
    private Label nameLabel;

    @FXML
    private TableColumn<AllWorks, String> nameWorkColumn;

    @FXML
    private Button profileButton;

    @FXML
    private TableColumn<AllWorks, Integer> salaryColumn;

    @FXML
    private TableColumn<AllWorks, Integer> workExperienceColumn;

    @FXML
    void back(ActionEvent event) {
        SceneMoves.openNewScene("main-view.fxml", backButton, "Анкетирование");
    }

    @FXML
    void getProfile(ActionEvent event) throws SQLException, ClassNotFoundException {
        QueryDAO queryDAO = new QueryDAO();
        WorkBook workBook = queryDAO.getWorkBook(idPersonalDataTextField.getText());

        nameLabel.setText(workBook.getSurname() + " " + workBook.getName() + " " + workBook.getSurname());
        WorkExperience.workExperience(nameCompanyColumn, nameWorkColumn, salaryColumn, workExperienceColumn, listWorksTable, idPersonalDataTextField.getText());
    }
}