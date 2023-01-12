package com.vuklorr.fileshared.controller.query;

import com.vuklorr.fileshared.dao.query.TopThreeMostAccessibleFilesDAO;
import com.vuklorr.fileshared.entity.query.TopThreeMostAccessibleFiles;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class TopThreeMostAccessibleFilesController {

    @FXML
    private TableColumn<TopThreeMostAccessibleFiles, Integer> countClientColumn;

    @FXML
    private TableColumn<TopThreeMostAccessibleFiles, Integer> idFileColumn;

    @FXML
    private TableColumn<TopThreeMostAccessibleFiles, String> nameFileColumn;

    @FXML
    private TableView<TopThreeMostAccessibleFiles> topThreeMostAccessibleFilesTableView;

    private final TopThreeMostAccessibleFilesDAO topThreeMostAccessibleFilesDAO = new TopThreeMostAccessibleFilesDAO();

    public TopThreeMostAccessibleFilesController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        idFileColumn.setCellValueFactory(new PropertyValueFactory<>("idFile"));
        nameFileColumn.setCellValueFactory(new PropertyValueFactory<>("nameFile"));
        countClientColumn.setCellValueFactory(new PropertyValueFactory<>("countClient"));

        topThreeMostAccessibleFilesTableView.setItems(topThreeMostAccessibleFilesDAO.getData());
    }
}