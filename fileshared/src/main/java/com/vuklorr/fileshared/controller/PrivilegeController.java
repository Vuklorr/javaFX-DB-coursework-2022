package com.vuklorr.fileshared.controller;

import com.vuklorr.fileshared.dao.PrivilegeDAO;
import com.vuklorr.fileshared.entity.Privilege;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class PrivilegeController {

    @FXML
    private TableColumn<Privilege, Integer> idClientPrivilegeColumn;

    @FXML
    private TextField idClientTextField;

    @FXML
    private TableColumn<Privilege, Integer> idFilePrivilegeColumn;

    @FXML
    private TextField idFileTextField;

    @FXML
    private TableColumn<Privilege, Integer> idPrivilegeColumn;

    @FXML
    private TextField idTextField;

    @FXML
    private TableView<Privilege> privilegeTableView;

    private final PrivilegeDAO privilegeDAO = new PrivilegeDAO();

    public PrivilegeController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        outputDataToTable();

        TableView.TableViewSelectionModel<Privilege> selectionModel = privilegeTableView.getSelectionModel();
        selectionModel.selectedItemProperty()
                .addListener((observableValue, privilege, newPrivilege) -> {
                    if (newPrivilege != null) {
                        idTextField.setText(String.valueOf(newPrivilege.getId()));
                        idClientTextField.setText(String.valueOf(newPrivilege.getIdClient()));
                        idFileTextField.setText(String.valueOf(newPrivilege.getIdFile()));
                    }
                });
    }

    @FXML
    private void add() {
        privilegeDAO.addData(idTextField.getText(),
                idClientTextField.getText(),
                idFileTextField.getText());

        outputDataToTable();
    }

    @FXML
    private void update() {
        privilegeDAO.updateData(idTextField.getText(),
                idClientTextField.getText(),
                idFileTextField.getText());
        outputDataToTable();
    }

    @FXML
    private void delete() {
        privilegeDAO.deleteData(idTextField.getText());
        outputDataToTable();
    }

    private void outputDataToTable() {
        idPrivilegeColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idClientPrivilegeColumn.setCellValueFactory(new PropertyValueFactory<>("idClient"));
        idFilePrivilegeColumn.setCellValueFactory(new PropertyValueFactory<>("idFile"));

        privilegeTableView.setItems(privilegeDAO.getData());
    }
}