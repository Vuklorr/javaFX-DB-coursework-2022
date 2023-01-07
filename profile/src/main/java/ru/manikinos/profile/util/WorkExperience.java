package ru.manikinos.profile.util;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.manikinos.profile.dao.QueryDAO;
import ru.manikinos.profile.entity.query.AllWorks;

import java.sql.SQLException;

public class WorkExperience {
    public static void workExperience(TableColumn<AllWorks, String> nameCompanyColumn, TableColumn<AllWorks, String> nameWorkColumn, TableColumn<AllWorks, Integer> salaryColumn, TableColumn<AllWorks, Integer> workExperienceColumn, TableView<AllWorks> listWorksTable, TextField idPersonalDataTextField) throws SQLException, ClassNotFoundException {
        QueryDAO queryDAO = new QueryDAO();

        nameCompanyColumn.setCellValueFactory(new PropertyValueFactory<>("nameCompany"));
        nameWorkColumn.setCellValueFactory(new PropertyValueFactory<>("nameWork"));
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        workExperienceColumn.setCellValueFactory(new PropertyValueFactory<>("workExperience"));

        listWorksTable.setItems(queryDAO.getListAllWorks(idPersonalDataTextField.getText()));
    }
}
