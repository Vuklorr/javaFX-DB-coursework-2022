package com.vuklorr.fileshared.controller.query;

import com.vuklorr.fileshared.dao.query.FileOperationsWithClientDAO;
import com.vuklorr.fileshared.entity.query.FileOperationsWithClient;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class FileOperationsWithClientController {

    @FXML
    private TableView<FileOperationsWithClient> fileOperationsWithClientTableView;

    @FXML
    private TextField idFileTextField;

    @FXML
    private TableColumn<FileOperationsWithClient, String> nameClientColumn;

    @FXML
    private TableColumn<FileOperationsWithClient, String> nameOperationColumn;

    @FXML
    private TableColumn<FileOperationsWithClient, String> patronymicClientColumn;

    @FXML
    private TableColumn<FileOperationsWithClient, String> surnameClientColumn;

    private final FileOperationsWithClientDAO fileOperationsWithClientDAO = new FileOperationsWithClientDAO();

    public FileOperationsWithClientController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void show() {
        nameOperationColumn.setCellValueFactory(new PropertyValueFactory<>("nameOperation"));
        nameClientColumn.setCellValueFactory(new PropertyValueFactory<>("nameClient"));
        patronymicClientColumn.setCellValueFactory(new PropertyValueFactory<>("patronymicClient"));
        surnameClientColumn.setCellValueFactory(new PropertyValueFactory<>("surnameClient"));

        fileOperationsWithClientTableView.setItems(fileOperationsWithClientDAO.getData(idFileTextField.getText()));
    }
}