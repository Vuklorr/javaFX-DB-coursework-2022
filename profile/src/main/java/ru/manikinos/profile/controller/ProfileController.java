package ru.manikinos.profile.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.manikinos.profile.dao.QueryDAO;
import ru.manikinos.profile.entity.query.AllWorks;
import ru.manikinos.profile.entity.query.Profile;
import ru.manikinos.profile.util.SceneMoves;
import ru.manikinos.profile.util.WorkExperience;

import java.sql.SQLException;

public class ProfileController {

    @FXML
    private Button backButton;

    @FXML
    private Label cityLabel;

    @FXML
    private Label countryLabel;

    @FXML
    private Label flatLabel;

    @FXML
    private Label houseLabel;

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
    private Label patronymicLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Button profileButton;

    @FXML
    private Label regionLabel;

    @FXML
    private TableColumn<AllWorks, Integer> salaryColumn;

    @FXML
    private Label streetLabel;

    @FXML
    private Label surnameLabel;

    @FXML
    private TableColumn<AllWorks, Integer> workExperienceColumn;

    @FXML
    void back(ActionEvent event) {
        SceneMoves.openNewScene("main-view.fxml", backButton, "Анкетирование");
    }

    @FXML
    void getProfile(ActionEvent event) throws SQLException, ClassNotFoundException {
        QueryDAO queryDAO = new QueryDAO();
        Profile profile = queryDAO.getProfile(idPersonalDataTextField.getText());

        nameLabel.setText(profile.getName());
        patronymicLabel.setText(profile.getPatronymic());
        surnameLabel.setText(profile.getSurname());
        phoneNumberLabel.setText(profile.getPhoneNumber());

        countryLabel.setText(profile.getCountry());
        cityLabel.setText(profile.getCity());
        regionLabel.setText(profile.getRegion());
        streetLabel.setText(profile.getStreet());
        houseLabel.setText(profile.getHouse());
        flatLabel.setText(String.valueOf(profile.getFlat()));

        WorkExperience.workExperience(nameCompanyColumn, nameWorkColumn, salaryColumn, workExperienceColumn, listWorksTable, idPersonalDataTextField.getText());
    }
}
