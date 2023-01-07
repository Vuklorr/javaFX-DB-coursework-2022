package ru.manikinos.profile.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.manikinos.profile.dao.QueryDAO;
import ru.manikinos.profile.entity.query.PrivateContact;
import ru.manikinos.profile.util.SceneMoves;

import java.sql.SQLException;

public class PrivateContactController {

    @FXML
    private Button backButton;

    @FXML
    private TextField idPersonalDataTextField;

    @FXML
    private TableColumn<PrivateContact, String> namePersonColumn;

    @FXML
    private TableColumn<PrivateContact, String> nameRelativeColumn;

    @FXML
    private TableColumn<PrivateContact, String> phoneNumberRelativeColumn;

    @FXML
    private Button privateContactButton;

    @FXML
    private TableView<PrivateContact> privateContactTable;

    @FXML
    private TableColumn<PrivateContact, String> phoneNumberPersonColumn;

    @FXML
    private void back(ActionEvent event) {
        SceneMoves.openNewScene("main-view.fxml", backButton, "Анкетирование");
    }

    @FXML
    private void getPrivateContact(ActionEvent event) throws SQLException, ClassNotFoundException {
        QueryDAO queryDAO = new QueryDAO();

        namePersonColumn.setCellValueFactory(new PropertyValueFactory<>("namePerson"));
        phoneNumberPersonColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumberPerson"));
        nameRelativeColumn.setCellValueFactory(new PropertyValueFactory<>("nameRelative"));
        phoneNumberRelativeColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumberRelative"));

        privateContactTable.setItems(queryDAO.getPrivateContact(idPersonalDataTextField.getText()));

    }
}
