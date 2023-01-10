package com.vuklorr.fileshared.controller;

import com.vuklorr.fileshared.dao.TypeOfOperationDAO;
import com.vuklorr.fileshared.entity.TypeOfOperation;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class TypeOfOperationController {

    @FXML
    private TextField idTextField;

    @FXML
    private TableColumn<TypeOfOperation, Integer> idTypeOfOperationColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TableColumn<TypeOfOperation, String> nameTypeOfOperationColumn;

    @FXML
    private TableView<TypeOfOperation> typeOfOperationTableView;

    TypeOfOperationDAO typeOfOperationDAO = new TypeOfOperationDAO();

    public TypeOfOperationController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        outputDataToTable();

        TableView.TableViewSelectionModel<TypeOfOperation> selectionModel = typeOfOperationTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, typeOfOperation, newTypeOfOperation) -> {
            if(newTypeOfOperation != null) {
                idTextField.setText(String.valueOf(newTypeOfOperation.getId()));
                nameTextField.setText(newTypeOfOperation.getName());
            }
        });
    }

    @FXML
    private void add() {
        typeOfOperationDAO.addData(idTextField.getText(), nameTextField.getText());
        outputDataToTable();
    }

    @FXML
    private void update() {
        typeOfOperationDAO.updateData(idTextField.getText(), nameTextField.getText());
        outputDataToTable();
    }

    @FXML
    private void delete() {
        typeOfOperationDAO.deleteData(idTextField.getText());
        outputDataToTable();
    }

    private void outputDataToTable() {
        idTypeOfOperationColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTypeOfOperationColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        typeOfOperationTableView.setItems(typeOfOperationDAO.getData());
    }
}