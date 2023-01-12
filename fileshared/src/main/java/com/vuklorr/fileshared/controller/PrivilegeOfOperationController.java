package com.vuklorr.fileshared.controller;

import com.vuklorr.fileshared.dao.PrivilegeOfOperationDAO;
import com.vuklorr.fileshared.entity.PrivilegeOfOperation;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrivilegeOfOperationController {

    @FXML
    private TableColumn<PrivilegeOfOperation, Integer> idPrivilegeColumn;

    @FXML
    private TextField idPrivilegeTextField;

    @FXML
    private TextField idTypeOfOperationTextField;

    @FXML
    private TableColumn<PrivilegeOfOperation, Integer> idTypeOfOperationColumn;

    @FXML
    private TableView<PrivilegeOfOperation> privilegeOfOperationTableView;

    private final PrivilegeOfOperationDAO privilegeOfOperationDAO = new PrivilegeOfOperationDAO();
    private final List<Integer> idPrivilegeTypeOfOperationOld = new ArrayList<>();
    public PrivilegeOfOperationController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        outputDataToTable();

        TableView.TableViewSelectionModel<PrivilegeOfOperation> selectionModel = privilegeOfOperationTableView.getSelectionModel();
        selectionModel.selectedItemProperty()
                .addListener((observableValue, privilegeOfOperation, newPOO) -> {
                    if (newPOO != null) {
                        idPrivilegeTypeOfOperationOld.clear();

                        idPrivilegeTextField.setText(String.valueOf(newPOO.getIdPrivilege()));
                        idTypeOfOperationTextField.setText(String.valueOf(newPOO.getIdTypeOfOperation()));

                        idPrivilegeTypeOfOperationOld.add(Integer.valueOf(idPrivilegeTextField.getText()));
                        idPrivilegeTypeOfOperationOld.add(Integer.valueOf(idTypeOfOperationTextField.getText()));
                    }
                });
    }
    @FXML
    private void add() {
        privilegeOfOperationDAO.addData(idPrivilegeTextField.getText(), idTypeOfOperationTextField.getText());
        outputDataToTable();
    }

    @FXML
    private void update() {
        privilegeOfOperationDAO.updateData(idPrivilegeTextField.getText(), idTypeOfOperationTextField.getText(), idPrivilegeTypeOfOperationOld);
        outputDataToTable();
    }

    @FXML
    private void delete() {
        privilegeOfOperationDAO.deleteData(idPrivilegeTextField.getText(), idTypeOfOperationTextField.getText());
        outputDataToTable();
    }

    private void outputDataToTable() {
        idPrivilegeColumn.setCellValueFactory(new PropertyValueFactory<>("idPrivilege"));
        idTypeOfOperationColumn.setCellValueFactory(new PropertyValueFactory<>("idTypeOfOperation"));

        privilegeOfOperationTableView.setItems(privilegeOfOperationDAO.getData());
    }
}