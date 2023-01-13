package com.vuklorr.fileshared;

import com.vuklorr.fileshared.util.MovingScenes;
import javafx.fxml.FXML;

public class MainController {
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
    private void showFrequentFileOperationsQuery() {
        MovingScenes.showNewScene("frequent-file-operations-view.fxml", "Список самых частых операций над файлами, учитываются только 2 последние операции создания файла");
    }

    @FXML
    private void showCountOfDownloadedFilesWithClientInfoQuery() {
        MovingScenes.showNewScene("count-of-downloaded-files-with-client-info-view.fxml", "Количество скачиваний файлов с информацей по каждому пользователю");
    }

    @FXML
    private void searchSimilarFilesQuery() {
        MovingScenes.showNewScene("similar-file-view.fxml", "Поиск похожих файлов");
    }

    @FXML
    private void showTagsWithRatingQuery() {
        MovingScenes.showNewScene("tags-with-rating-query-view.fxml", "Список тегов с указанием рейтинга");
    }
}