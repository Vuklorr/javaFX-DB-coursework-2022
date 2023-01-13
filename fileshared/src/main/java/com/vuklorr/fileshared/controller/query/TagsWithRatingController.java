package com.vuklorr.fileshared.controller.query;

import com.vuklorr.fileshared.dao.query.TagsWithRatingDAO;
import com.vuklorr.fileshared.entity.query.TagsWithRating;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class TagsWithRatingController {

    @FXML
    private TableColumn<TagsWithRating, Integer> countTagColumn;

    @FXML
    private TableColumn<TagsWithRating, Integer> idFileColumn;

    @FXML
    private TableColumn<TagsWithRating, Double> ratingColumn;

    @FXML
    private TableView<TagsWithRating> tagsWithRatingTableView;

    private final TagsWithRatingDAO tagsWithRatingDAO = new TagsWithRatingDAO();

    public TagsWithRatingController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        idFileColumn.setCellValueFactory(new PropertyValueFactory<>("idFile"));
        countTagColumn.setCellValueFactory(new PropertyValueFactory<>("countTag"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        tagsWithRatingTableView.setItems(tagsWithRatingDAO.getData());
    }
}