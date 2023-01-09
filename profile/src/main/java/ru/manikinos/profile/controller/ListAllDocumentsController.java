package ru.manikinos.profile.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.manikinos.profile.dao.QueryDAO;
import ru.manikinos.profile.entity.query.AllDocuments;
import ru.manikinos.profile.util.SceneMoves;

import java.sql.SQLException;

public class ListAllDocumentsController {

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<AllDocuments, Integer> countDocumentColumn;

    @FXML
    private TextField idPersonalDataTextField;

    @FXML
    private Button listAllDocumentsButton;

    @FXML
    private TableView<AllDocuments> listDocumentsTable;

    @FXML
    private TableColumn<AllDocuments, String> nameDocumentColumn;

    @FXML
    private void back(ActionEvent event) {
        SceneMoves.openNewScene("main-view.fxml", backButton, "Анкетирование");
    }

    @FXML
    private void getListAllDocuments(ActionEvent event) throws SQLException, ClassNotFoundException {
        QueryDAO queryDAO = new QueryDAO();

        nameDocumentColumn.setCellValueFactory(new PropertyValueFactory<>("nameDocument"));
        countDocumentColumn.setCellValueFactory(new PropertyValueFactory<>("countDocument"));

        listDocumentsTable.setItems(queryDAO.getListAllDocuments(idPersonalDataTextField.getText()));
    }
}
