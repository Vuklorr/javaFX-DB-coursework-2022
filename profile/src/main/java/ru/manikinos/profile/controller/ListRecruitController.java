package ru.manikinos.profile.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.manikinos.profile.dao.QueryDAO;
import ru.manikinos.profile.entity.query.Recruit;
import ru.manikinos.profile.util.SceneMoves;

import java.sql.SQLException;
import java.time.LocalDate;

public class ListRecruitController {

    @FXML
    private Button backButton;

    @FXML
    private TableColumn<Recruit, LocalDate> dateRecruitColumn;

    @FXML
    private TableView<Recruit> listRecruitTable;

    @FXML
    private TableColumn<Recruit, String> nameRecruitColumn;
    @FXML
    private TableColumn<Recruit, String> patronymicRecruitColumn;

    @FXML
    private TableColumn<Recruit, String> surnameRecruitColumn;

    private final QueryDAO queryDAO = new QueryDAO();

    public ListRecruitController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        nameRecruitColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        patronymicRecruitColumn.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        surnameRecruitColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        dateRecruitColumn.setCellValueFactory(new PropertyValueFactory<>("dateRecruit"));

        listRecruitTable.setItems(queryDAO.getListRecruit());
    }

    @FXML
    void back(ActionEvent event) {
        SceneMoves.openNewScene("main-view.fxml", backButton, "Анкетирование");
    }
}
