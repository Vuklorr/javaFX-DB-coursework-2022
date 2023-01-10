package com.vuklorr.fileshared.controller;

import com.vuklorr.fileshared.dao.HistoryOfOperationDAO;
import com.vuklorr.fileshared.entity.HistoryOfOperation;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.LocalDate;

public class HistoryOfOperationController {

    @FXML
    private TableColumn<HistoryOfOperation, LocalDate> dataOfOperationHistoryOfOperationTableView;

    @FXML
    private DatePicker dateOfOperationDatePicker;

    @FXML
    private TableView<HistoryOfOperation> historyOfOperationTableView;

    @FXML
    private TableColumn<HistoryOfOperation, Integer> idClientHistoryOfOperationColumn;

    @FXML
    private TextField idClientTextField;

    @FXML
    private TableColumn<HistoryOfOperation, Integer> idFileHistoryOfOperationColumn;

    @FXML
    private TextField idFileTextField;

    @FXML
    private TableColumn<HistoryOfOperation, Integer> idHistoryOfOperationColumn;

    @FXML
    private TextField idTextField;

    @FXML
    private TableColumn<HistoryOfOperation, Integer> idTypeOfOperationHistoryOfOperationColumn;

    @FXML
    private TextField idTypeOfOperationTextField;

    private final HistoryOfOperationDAO historyOfOperationDAO = new HistoryOfOperationDAO();

    public HistoryOfOperationController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        outputDataToTable();

        TableView.TableViewSelectionModel<HistoryOfOperation> selectionModel = historyOfOperationTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, historyOfOperation, newHOO) -> {
            if(newHOO != null) {
                idTextField.setText(String.valueOf(newHOO.getId()));
                idTypeOfOperationTextField.setText(String.valueOf(newHOO.getIdTypeOfOperation()));
                idClientTextField.setText(String.valueOf(newHOO.getIdClient()));
                idFileTextField.setText(String.valueOf(newHOO.getIdFile()));
                dateOfOperationDatePicker.setValue(newHOO.getDateOfOperation());
            }
        });
    }

    @FXML
    private void add() {
        historyOfOperationDAO.addData(idTextField.getText(),
                idTypeOfOperationTextField.getText(),
                idClientTextField.getText(),
                idFileTextField.getText(),
                dateOfOperationDatePicker.getValue().toString());

        outputDataToTable();
    }

    @FXML
    private void update() {
        historyOfOperationDAO.updateData(idTextField.getText(),
                idTypeOfOperationTextField.getText(),
                idClientTextField.getText(),
                idFileTextField.getText(),
                dateOfOperationDatePicker.getValue().toString());
        outputDataToTable();
    }

    @FXML
    private void delete() {
        historyOfOperationDAO.deleteData(idTextField.getText());
        outputDataToTable();
    }

    private void outputDataToTable() {
        idHistoryOfOperationColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idTypeOfOperationHistoryOfOperationColumn.setCellValueFactory(new PropertyValueFactory<>("idTypeOfOperation"));
        idClientHistoryOfOperationColumn.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        idFileHistoryOfOperationColumn.setCellValueFactory(new PropertyValueFactory<>("idFile"));
        dataOfOperationHistoryOfOperationTableView.setCellValueFactory(new PropertyValueFactory<>("dateOfOperation"));

        historyOfOperationTableView.setItems(historyOfOperationDAO.getData());
    }
}