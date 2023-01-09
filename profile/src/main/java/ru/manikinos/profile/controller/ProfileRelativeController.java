package ru.manikinos.profile.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.manikinos.profile.MainController;
import ru.manikinos.profile.dao.QueryDAO;
import ru.manikinos.profile.entity.query.AllWorks;
import ru.manikinos.profile.entity.query.ProfileRelative;
import ru.manikinos.profile.util.SceneMoves;
import ru.manikinos.profile.util.WorkExperience;

import java.sql.SQLException;

public class ProfileRelativeController {

    @FXML
    private Button outputButton;
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
    private Label regionLabel;

    @FXML
    private TableColumn<AllWorks, Integer> salaryColumn;

    @FXML
    private Label streetLabel;

    @FXML
    private Label surnameLabel;

    @FXML
    private Label typeRelativeLabel;

    @FXML
    private TableColumn<AllWorks, Integer> workExperienceColumn;

    @FXML
    private Label idRelativeLabel;

    public void setIdRelativeLabel(String str) {
        idRelativeLabel.setText(str);
    }

    @FXML
    private void outputProfileRelative(ActionEvent event) throws SQLException, ClassNotFoundException {
        QueryDAO queryDAO = new QueryDAO();
        ProfileRelative profileRelative = queryDAO.getProfileRelative(idRelativeLabel.getText());

        nameLabel.setText(profileRelative.getProfile().getName());
        patronymicLabel.setText(profileRelative.getProfile().getPatronymic());
        surnameLabel.setText(profileRelative.getProfile().getSurname());
        phoneNumberLabel.setText(profileRelative.getProfile().getPhoneNumber());
        typeRelativeLabel.setText(profileRelative.getTypeRelative());

        countryLabel.setText(profileRelative.getProfile().getCountry());
        cityLabel.setText(profileRelative.getProfile().getCity());
        regionLabel.setText(profileRelative.getProfile().getRegion());
        streetLabel.setText(profileRelative.getProfile().getStreet());
        houseLabel.setText(profileRelative.getProfile().getHouse());
        flatLabel.setText(String.valueOf(profileRelative.getProfile().getFlat()));

        WorkExperience.workExperience(nameCompanyColumn, nameWorkColumn, salaryColumn, workExperienceColumn, listWorksTable, idRelativeLabel.getText());
    }
    @FXML
    void back(ActionEvent event) {
        SceneMoves.openNewScene("main-view.fxml", backButton, "Анкетирование");
    }
}