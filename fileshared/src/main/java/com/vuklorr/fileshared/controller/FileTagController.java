package com.vuklorr.fileshared.controller;

import com.vuklorr.fileshared.dao.FileTagDAO;
import com.vuklorr.fileshared.entity.FileTag;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FileTagController {

    @FXML
    private TableColumn<FileTag, Integer> idFileColumn;

    @FXML
    private TextField idFileTextField;

    @FXML
    private TableColumn<FileTag, Integer> idTagColumn;

    @FXML
    private TextField idTagTextField;

    @FXML
    private TableView<FileTag> fileTagTableView;

    private final List<Integer> idFileTagOld = new ArrayList<>();

    private final FileTagDAO fileTagDAO = new FileTagDAO();

    public FileTagController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        outputDataToTable();

        TableView.TableViewSelectionModel<FileTag> selectionModel = fileTagTableView.getSelectionModel();
        selectionModel.selectedItemProperty()
                .addListener((observableValue, fileTag, newFileTag) -> {
                    if (newFileTag != null) {
                        idFileTagOld.clear();

                        idFileTextField.setText(String.valueOf(newFileTag.getIdFile()));
                        idTagTextField.setText(String.valueOf(newFileTag.getIdTag()));

                        idFileTagOld.add(Integer.valueOf(idFileTextField.getText()));
                        idFileTagOld.add(Integer.valueOf(idTagTextField.getText()));
                    }
                });
    }
    @FXML
    private void add() {
        fileTagDAO.addData(idFileTextField.getText(), idTagTextField.getText());
        outputDataToTable();
    }

    @FXML
    private void update() {
        fileTagDAO.updateData(idFileTextField.getText(), idTagTextField.getText(), idFileTagOld);
        outputDataToTable();
    }

    @FXML
    private void delete() {
        fileTagDAO.deleteData(idFileTextField.getText(), idTagTextField.getText());
        outputDataToTable();
    }

    private void outputDataToTable() {
        idFileColumn.setCellValueFactory(new PropertyValueFactory<>("idFile"));
        idTagColumn.setCellValueFactory(new PropertyValueFactory<>("idTag"));

        fileTagTableView.setItems(fileTagDAO.getData());
    }
}