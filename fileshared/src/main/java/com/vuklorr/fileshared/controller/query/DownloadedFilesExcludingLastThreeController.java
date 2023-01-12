package com.vuklorr.fileshared.controller.query;

import com.vuklorr.fileshared.dao.query.DownloadedFilesExcludingLastThreeDAO;
import com.vuklorr.fileshared.entity.query.DownloadedFilesExcludingLastThree;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.LocalDate;

public class DownloadedFilesExcludingLastThreeController {

    @FXML
    private TableColumn<DownloadedFilesExcludingLastThree, LocalDate> dataOfOperationColumn;

    @FXML
    private TableView<DownloadedFilesExcludingLastThree> downloadedFilesExcludingLastThreeTableView;

    @FXML
    private TableColumn<DownloadedFilesExcludingLastThree, Integer> idFileColumn;

    @FXML
    private TableColumn<DownloadedFilesExcludingLastThree, String> nameFileColumn;

    @FXML
    private TableColumn<DownloadedFilesExcludingLastThree, String> pathFileColumn;

    @FXML
    private TableColumn<DownloadedFilesExcludingLastThree, Integer> sizeFileColumn;

    private final DownloadedFilesExcludingLastThreeDAO dao = new DownloadedFilesExcludingLastThreeDAO();

    public DownloadedFilesExcludingLastThreeController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        idFileColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameFileColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        pathFileColumn.setCellValueFactory(new PropertyValueFactory<>("path"));
        sizeFileColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        dataOfOperationColumn.setCellValueFactory(new PropertyValueFactory<>("dateOfOperation"));

        downloadedFilesExcludingLastThreeTableView.setItems(dao.getData());
    }
}