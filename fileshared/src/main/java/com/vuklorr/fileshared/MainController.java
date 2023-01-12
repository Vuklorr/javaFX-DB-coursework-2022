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
    private void showPrivilegeTable() {
        MovingScenes.showNewScene("privilege-view.fxml", "Право");
    }

    @FXML
    private void showPrivilegeOfOperationTable() {
        MovingScenes.showNewScene("privilege-of-operation-view.fxml", "Право на операцию");
    }

    @FXML
    private void showFileTagTable() {
        MovingScenes.showNewScene("file-tag-view.fxml", "Тег файла");
    }

    @FXML
    private void showDownloadedFilesByTheClientQueryButton() {
        MovingScenes.showNewScene("downloaded-files-by-the-client-view.fxml", "Список файлов, которые может скачать пользователь");
    }

    @FXML
    private void showFileOperationsWithClientQuery() {
        MovingScenes.showNewScene("file-operations-with-client-view.fxml", "Список операций над файлом с указанием пользователя");
    }

    @FXML
    private void showDownloadedFilesExcludingLastThreeQuery() {
        MovingScenes.showNewScene("downloaded-files-excluding-last-three-view.fxml", "Список скаченных файлов без учета последних 3");
    }

    @FXML
    private void showTopThreeMostAccessibleFilesQuery() {
        MovingScenes.showNewScene("top-three-most-accessible-files-view.fxml", "ТОП - 3 самых доступных файлов с указанием количества пользователей по каждому виду доступности");
    }

    @FXML
    void showFrequentFileOperationsQuery(ActionEvent event) {

    }

    @FXML
    void showCountOfDownloadedFilesWithClientInfoQuery(ActionEvent event) {

    }

    @FXML
    void searchSimilarFilesQuery(ActionEvent event) {

    }

    @FXML
    void showTagsWithRatingQuery(ActionEvent event) {

    }
}