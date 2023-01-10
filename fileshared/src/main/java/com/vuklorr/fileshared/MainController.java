package com.vuklorr.fileshared;

import com.vuklorr.fileshared.util.MovingScenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    private Button clientTableButton;

    @FXML
    private Button countOfDownloadedFilesWithClientInfoQueryButton;

    @FXML
    private Button downloadedFilesByTheClientQueryButton;

    @FXML
    private Button downloadedFilesExcludingLastThreeQueryButton;

    @FXML
    private Button fileOperationsWithClientQueryButton;

    @FXML
    private Button fileTableButton;

    @FXML
    private Button fileTagTableButton;

    @FXML
    private Button frequentFileOperationsQueryButton;

    @FXML
    private Button historyOfOperationTableButton;

    @FXML
    private Button privilegeOfOperationTableButton;

    @FXML
    private Button privilegeTableButton;

    @FXML
    private Button similarFilesQueryButton;

    @FXML
    private Button tagTableButton;

    @FXML
    private Button tagsWithRatingQueryButton;

    @FXML
    private Button topThreeMostAccessibleFilesQueryButton;

    @FXML
    private Button typeOfOperationTableButton;

    @FXML
    private void showClientTable() {
        MovingScenes.showNewScene("client-view.fxml", "Пользователь");
    }

    @FXML
    private void showFileTable() {
        MovingScenes.showNewScene("file-view.fxml", "Файл");
    }

    @FXML
    private void showTagTable() {
        MovingScenes.showNewScene("tag-view.fxml", "Тег");
    }

    @FXML
    private void showTypeOfOperationTable() {
        MovingScenes.showNewScene("type-of-operation-view.fxml", "Тип операции");
    }

    @FXML
    private void showHistoryOfOperationTable() {
        MovingScenes.showNewScene("history-of-operation-view.fxml", "История операций");
    }

    @FXML
    void showFileTagTable(ActionEvent event) {

    }

    @FXML
    void searchSimilarFilesQuery(ActionEvent event) {

    }

    @FXML
    void showCountOfDownloadedFilesWithClientInfoQuery(ActionEvent event) {

    }

    @FXML
    void showDownloadedFilesByTheClientQueryButton(ActionEvent event) {

    }

    @FXML
    void showDownloadedFilesExcludingLastThreeQuery(ActionEvent event) {

    }

    @FXML
    void showFileOperationsWithClientQuery(ActionEvent event) {

    }

    @FXML
    void showFrequentFileOperationsQuery(ActionEvent event) {

    }

    @FXML
    void showPrivilegeOfOperationTable(ActionEvent event) {

    }

    @FXML
    void showPrivilegeTable(ActionEvent event) {

    }

    @FXML
    void showTagsWithRatingQuery(ActionEvent event) {

    }

    @FXML
    void showTopThreeMostAccessibleFilesQuery(ActionEvent event) {

    }
}