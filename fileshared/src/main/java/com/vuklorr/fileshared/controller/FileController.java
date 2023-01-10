package com.vuklorr.fileshared.controller;

import com.vuklorr.fileshared.dao.FileDAO;
import com.vuklorr.fileshared.entity.File;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class FileController {

    @FXML
    private TableView<File> fileTableView;

    @FXML
    private TableColumn<File, Integer> idFileColumn;

    @FXML
    private TextField idTextField;

    @FXML
    private TableColumn<File, String> nameFileColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField pathTextField;

    @FXML
    private TableColumn<File, String> pathFileColumn;

    @FXML
    private TableColumn<File, Integer> sizeFileColumn;

    @FXML
    private TextField sizeTextField;

    private final FileDAO fileDAO = new FileDAO();

    public FileController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        outputDataToTable();

        TableView.TableViewSelectionModel<File> selectionModel = fileTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, file, newFile) -> {
            if(newFile != null) {
                idTextField.setText(String.valueOf(newFile.getId()));
                nameTextField.setText(newFile.getName());
                pathTextField.setText(newFile.getPath());
                sizeTextField.setText(String.valueOf(newFile.getSize()));
            }
        });
    }

    @FXML
    private void add() {
        fileDAO.addData(idTextField.getText(),
                nameTextField.getText(),
                pathTextField.getText(),
                sizeTextField.getText());
        outputDataToTable();
    }

    @FXML
    private void update() {
        fileDAO.updateData(idTextField.getText(),
                nameTextField.getText(),
                pathTextField.getText(),
                sizeTextField.getText());
        outputDataToTable();
    }

    @FXML
    private void delete() {
        fileDAO.deleteData(idTextField.getText());
        outputDataToTable();
    }

    private void outputDataToTable() {
        idFileColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameFileColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pathFileColumn.setCellValueFactory(new PropertyValueFactory<>("path"));
        sizeFileColumn.setCellValueFactory(new PropertyValueFactory<>("size"));

        fileTableView.setItems(fileDAO.getData());
    }
}