package com.vuklorr.fileshared.controller.query;

import com.vuklorr.fileshared.dao.query.FrequentFileOperationDAO;
import com.vuklorr.fileshared.entity.query.FrequentFileOperation;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class FrequentFileOperationController {

    @FXML
    private TableColumn<FrequentFileOperation, Integer> countOperationsColumn;

    @FXML
    private TableView<FrequentFileOperation> frequentFileOperationsTableView;

    @FXML
    private TableColumn<FrequentFileOperation, String> nameOperationColumn;

    private final FrequentFileOperationDAO frequentFileOperationDAO = new FrequentFileOperationDAO();

    public FrequentFileOperationController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        nameOperationColumn.setCellValueFactory(new PropertyValueFactory<>("nameOperation"));
        countOperationsColumn.setCellValueFactory(new PropertyValueFactory<>("countOperation"));

        frequentFileOperationsTableView.setItems(frequentFileOperationDAO.getData());
    }
}