package ru.manikinos.profile.util;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.manikinos.profile.dao.AllDataDAO;
import ru.manikinos.profile.entity.Document;
import ru.manikinos.profile.entity.Type;

public class InitData {
    public static void initType(TableColumn<Type, Integer> idTypeColumn,
                                TableColumn<Type, String> nameTypeColumn,
                                TableView<Type> typeTable,
                                AllDataDAO allDataDAO) {
        idTypeColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTypeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        typeTable.setItems(allDataDAO.getTypeData());
    }
}
