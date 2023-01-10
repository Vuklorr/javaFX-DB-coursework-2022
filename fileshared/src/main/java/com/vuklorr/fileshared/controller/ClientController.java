package com.vuklorr.fileshared.controller;

import com.vuklorr.fileshared.dao.ClientDAO;
import com.vuklorr.fileshared.entity.Client;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class ClientController {

    @FXML
    private TableView<Client> clientTableView;

    @FXML
    private TableColumn<Client, Integer> idClientColumn;

    @FXML
    private TextField idTextField;

    @FXML
    private TableColumn<Client, String> nameClientColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TableColumn<Client, String> patronymicClientColumn;

    @FXML
    private TextField patronymicTextField;

    @FXML
    private TableColumn<Client, String> surnameClientColumn;

    @FXML
    private TextField surnameTextField;

    private final ClientDAO clientDAO = new ClientDAO();

    public ClientController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        outputDataToTable();

        TableView.TableViewSelectionModel<Client> selectionModel = clientTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, client, newClient) -> {
            if(newClient != null) {
                idTextField.setText(String.valueOf(newClient.getId()));
                nameTextField.setText(newClient.getName());
                patronymicTextField.setText(newClient.getPatronymic());
                surnameTextField.setText(newClient.getSurname());
            }
        });
    }

    @FXML
    private void add() {
        clientDAO.addData(idTextField.getText(),
                nameTextField.getText(),
                patronymicTextField.getText(),
                surnameTextField.getText());

        outputDataToTable();
    }

    @FXML
    private void update() {
        clientDAO.updateData(idTextField.getText(),
                nameTextField.getText(),
                patronymicTextField.getText(),
                surnameTextField.getText());
        outputDataToTable();
    }

    @FXML
    private void delete() {
        clientDAO.deleteData(idTextField.getText());
        outputDataToTable();
    }

    private void outputDataToTable() {
        idClientColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameClientColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        patronymicClientColumn.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        surnameClientColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        clientTableView.setItems(clientDAO.getData());
    }
}