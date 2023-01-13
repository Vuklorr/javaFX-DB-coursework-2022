package com.vuklorr.fileshared.controller.query;

import com.vuklorr.fileshared.dao.query.SimilarFilesDAO;
import com.vuklorr.fileshared.entity.File;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class SimilarFilesController {

    @FXML
    private TableView<File> fileTableView;

    @FXML
    private TableColumn<File, Integer> idFileColumn;

    @FXML
    private TableColumn<File, String> nameFileColumn;

    @FXML
    private TextField nameTextField;

    @FXML
    private TableColumn<File, String> pathFileColumn;

    @FXML
    private TextField pathTextField;

    @FXML
    private TableColumn<File, Integer> sizeFileColumn;

    @FXML
    private TextField sizeTextField;

    private final SimilarFilesDAO similarFilesDAO = new SimilarFilesDAO();

    public SimilarFilesController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        idFileColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameFileColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pathFileColumn.setCellValueFactory(new PropertyValueFactory<>("path"));
        sizeFileColumn.setCellValueFactory(new PropertyValueFactory<>("size"));

        fileTableView.setItems(similarFilesDAO.getFileData());
    }

    @FXML
    private void search() {
        fileTableView.setItems(similarFilesDAO.searchFile(nameTextField.getText(),
                pathTextField.getText(),
                sizeTextField.getText()));
    }

    @FXML
    private void clear() {
        nameTextField.clear();
        pathTextField.clear();
        sizeTextField.clear();
    }
}
