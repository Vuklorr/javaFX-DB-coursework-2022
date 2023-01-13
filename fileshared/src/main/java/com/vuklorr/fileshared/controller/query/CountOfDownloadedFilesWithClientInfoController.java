package com.vuklorr.fileshared.controller.query;

import com.vuklorr.fileshared.dao.query.CountOfDownloadedFilesWithClientInfoControllerDAO;
import com.vuklorr.fileshared.entity.Client;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class CountOfDownloadedFilesWithClientInfoController {

    @FXML
    private Label countOfDownloadedFilesLabel;

    @FXML
    private TableView<Client> clientTableView;

    @FXML
    private TableColumn<Client, Integer> idClientColumn;

    @FXML
    private TableColumn<Client, String> nameClientColumn;

    @FXML
    private TableColumn<Client, String> patronymicClientColumn;

    @FXML
    private TableColumn<Client, String> surnameClientColumn;

    private final CountOfDownloadedFilesWithClientInfoControllerDAO dao = new CountOfDownloadedFilesWithClientInfoControllerDAO();

    public CountOfDownloadedFilesWithClientInfoController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        countOfDownloadedFilesLabel.setText(String.valueOf(dao.countOfDownloadedFiles()));

        idClientColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameClientColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        patronymicClientColumn.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        surnameClientColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));

        clientTableView.setItems(dao.getClientData());
    }
}