package com.vuklorr.fileshared.controller;

import com.vuklorr.fileshared.dao.TagDAO;
import com.vuklorr.fileshared.entity.Tag;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class TagController {

    @FXML
    private TableColumn<Tag, Integer> idTagColumn;

    @FXML
    private TextField idTextField;

    @FXML
    private TableColumn<Tag, String> nameTagColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TableView<Tag> tagTableView;

    private final TagDAO tagDAO = new TagDAO();

    public TagController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        outputDataToTable();

        TableView.TableViewSelectionModel<Tag> selectionModel = tagTableView.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, tag, newTag) -> {
            if(newTag != null) {
                idTextField.setText(String.valueOf(newTag.getId()));
                nameTextField.setText(newTag.getName());
            }
        });
    }

    @FXML
    private void add() {
        tagDAO.addData(idTextField.getText(), nameTextField.getText());
        outputDataToTable();
    }

    @FXML
    private void update() {
        tagDAO.updateData(idTextField.getText(), nameTextField.getText());
        outputDataToTable();
    }

    @FXML
    private void delete() {
        tagDAO.deleteData(idTextField.getText());
        outputDataToTable();
    }

    private void outputDataToTable() {
        idTagColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTagColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        tagTableView.setItems(tagDAO.getData());
    }
}