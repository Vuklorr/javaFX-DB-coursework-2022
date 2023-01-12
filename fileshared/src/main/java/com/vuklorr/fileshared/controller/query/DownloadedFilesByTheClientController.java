package com.vuklorr.fileshared.controller.query;

import com.vuklorr.fileshared.dao.query.DownloadedFilesByTheClientDAO;
import com.vuklorr.fileshared.entity.File;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class DownloadedFilesByTheClientController {

    @FXML
    private TableView<File> fileTableView;

    @FXML
    private TextField idClientTextField;

    @FXML
    private TableColumn<File, Integer> idFileColumn;

    @FXML
    private TableColumn<File, String > nameFileColumn;

    @FXML
    private TableColumn<File, String> pathFileColumn;

    @FXML
    private TableColumn<File, Integer> sizeFileColumn;

    private final DownloadedFilesByTheClientDAO downloadedFilesByTheClientDAO = new DownloadedFilesByTheClientDAO();

    public DownloadedFilesByTheClientController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void show() {
        idFileColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameFileColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pathFileColumn.setCellValueFactory(new PropertyValueFactory<>("path"));
        sizeFileColumn.setCellValueFactory(new PropertyValueFactory<>("size"));

        fileTableView.setItems(downloadedFilesByTheClientDAO.getData(idClientTextField.getText()));
    }
}