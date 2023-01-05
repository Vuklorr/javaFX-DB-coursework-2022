package ru.manikinos.profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ru.manikinos.profile.dao.AddDAO;
import ru.manikinos.profile.dao.DeleteDAO;
import ru.manikinos.profile.dao.UpdateDAO;
import ru.manikinos.profile.datainit.SelectionMode;
import ru.manikinos.profile.entity.*;
import ru.manikinos.profile.datainit.InitData;

import java.sql.SQLException;
import java.time.LocalDate;

public class MainController {

    @FXML
    private TableView<PersonalData> PDTable;

    @FXML
    private Button updateAddressButton;

    @FXML
    private Button addAddressButton;
    @FXML
    private Button deleteAddressButton;
    @FXML
    private TextField idAddressTextField;
    @FXML
    private TextField countryAddressTextField;
    @FXML
    private TextField cityAddressTextField;
    @FXML
    private TextField regionAddressTextField;
    @FXML
    private TextField streetAddressTextField;
    @FXML
    private TextField houseAddressTextField;
    @FXML
    private TextField flatAddressTextField;

    @FXML
    private TableView<Address> addressTable;

    @FXML
    private TableColumn<Address, String> cityAddressColumn;

    @FXML
    private TableColumn<Address, String> countryAddressColumn;

    @FXML
    private TableColumn<Document, LocalDate> dataEndDocumentColumn;

    @FXML
    private TableColumn<Document, LocalDate> dataStartDocumentColumn;

    @FXML
    private TableColumn<WorkActivity, LocalDate> dateOfDismissalWAColumn;

    @FXML
    private TableColumn<WorkActivity, LocalDate> dateOfHiringWAColumn;

    @FXML
    private Button documentAcceptButton;

    @FXML
    private Button documentAddButton;

    @FXML
    private Button documentCancelButton;

    @FXML
    private Button documentDeleteButton;

    @FXML
    private TableView<Document> documentTable;

    @FXML
    private TableColumn<Address, Integer> flatAddressColumn;

    @FXML
    private TableColumn<WorkActivity, Integer> hoursWorkedWAColumn;

    @FXML
    private TableColumn<Address, String> houseAddressColumn;

    @FXML
    private TableColumn<Address, Integer> idAddressColumn;

    @FXML
    private TableColumn<Address, Integer> idAddressPDColumn;

    @FXML
    private TableColumn<Document, Integer> idDocumentColumn;

    @FXML
    private TableColumn<PersonalData, Integer> idPDColumn;

    @FXML
    private TableColumn<Document, Integer> idPDDocumentColumn;

    @FXML
    private TableColumn<Relative, Integer> idRelativeColumn;

    @FXML
    private TableColumn<PersonalData, Integer> idRelativePDColumn;

    @FXML
    private TableColumn<Type, Integer> idTypeColumn;

    @FXML
    private TableColumn<Document, Integer> idTypeDocumentColumn;

    @FXML
    private TableColumn<WorkActivity, Integer> idWAColumn;

    @FXML
    private TableColumn<PersonalData, Integer> idWorkPDColumn;

    @FXML
    private TableColumn<PersonalData, String> namePDColumn;

    @FXML
    private TableColumn<Relative, String> nameRelativeColumn;

    @FXML
    private TableColumn<Type, String> nameTypeColumn;

    @FXML
    private TableColumn<WorkActivity, String> nameWAColumn;

    @FXML
    private TableColumn<PersonalData, String> patronymicPDColumn;

    @FXML
    private TableColumn<PersonalData, String> patronymicRelativeColumn;

    @FXML
    private Button pdAcceptButton;

    @FXML
    private Button pdAddButton;

    @FXML
    private Button pdCancelButton;

    @FXML
    private Button pdDeleteButton;

    @FXML
    private TableColumn<PersonalData, String> phoneNumberPDColumn;

    @FXML
    private TableColumn<Relative, String> phoneNumberRelativeColumn;

    @FXML
    private TableColumn<Address, String> regionAddressColumn;

    @FXML
    private Button relativeAcceptButton;

    @FXML
    private Button relativeAddButton;

    @FXML
    private Button relativeCancelButton;

    @FXML
    private Button relativeDeleteButton;

    @FXML
    private TableView<Relative> relativeTable;

    @FXML
    private TableColumn<WorkActivity, Integer> salaryWAColumn;

    @FXML
    private TableColumn<Address, String> streetAddressColumn;

    @FXML
    private TableColumn<PersonalData, String> surnamePDColumn;

    @FXML
    private TableColumn<Relative, String> surnameRelativeColumn;

    @FXML
    private Button updateTypeButton;

    @FXML
    private Button addTypeButton;

    @FXML
    private Button deleteTypeButton;

    @FXML
    private TableView<Type> typeTable;

    @FXML
    private Button waAcceptButton;

    @FXML
    private Button waAddButton;

    @FXML
    private Button waCancelButton;

    @FXML
    private Button waDeleteButton;

    @FXML
    private TableView<WorkActivity> waTable;

    @FXML
    private TextField idTypeTextField;

    @FXML
    private TextField nameTypeTextField;
    private final InitData initData = new InitData();
    private final SelectionMode selectionMode = new SelectionMode();
    private final AddDAO addDAO = new AddDAO();
    private final UpdateDAO updateDAO = new UpdateDAO();
    private final DeleteDAO deleteDAO = new DeleteDAO();
    public MainController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    private void initialize() {
        initData.initAddress(idAddressColumn,
                countryAddressColumn,
                cityAddressColumn,
                regionAddressColumn,
                streetAddressColumn,
                houseAddressColumn,
                flatAddressColumn,
                addressTable);
        selectionMode.addressSelected(idAddressTextField,
                countryAddressTextField,
                cityAddressTextField,
                regionAddressTextField,
                streetAddressTextField,
                houseAddressTextField,
                flatAddressTextField,
                addressTable);

        initData.initType(idTypeColumn, nameTypeColumn, typeTable);
        selectionMode.typeSelected(idTypeTextField, nameTypeTextField, typeTable);

        //TODO init all table
    }

    @FXML
    private void addAddress(ActionEvent event) {
        addDAO.addAddress(idAddressTextField.getText(),
                countryAddressTextField.getText(),
                cityAddressTextField.getText(),
                regionAddressTextField.getText(),
                streetAddressTextField.getText(),
                houseAddressTextField.getText(),
                flatAddressTextField.getText());

        initData.initAddress(idAddressColumn,
                countryAddressColumn,
                cityAddressColumn,
                regionAddressColumn,
                streetAddressColumn,
                houseAddressColumn,
                flatAddressColumn,
                addressTable);
    }

    @FXML
    private void deleteAddress(ActionEvent event) {
        deleteDAO.deleteAddress(idAddressTextField.getText());
        initData.initAddress(idAddressColumn,
                countryAddressColumn,
                cityAddressColumn,
                regionAddressColumn,
                streetAddressColumn,
                houseAddressColumn,
                flatAddressColumn,
                addressTable);
    }

    @FXML
    private void updateAddress(ActionEvent event) {
        updateDAO.updateAddress(idAddressTextField.getText(),
                countryAddressTextField.getText(),
                cityAddressTextField.getText(),
                regionAddressTextField.getText(),
                streetAddressTextField.getText(),
                houseAddressTextField.getText(),
                flatAddressTextField.getText());
        initData.initAddress(idAddressColumn,
                countryAddressColumn,
                cityAddressColumn,
                regionAddressColumn,
                streetAddressColumn,
                houseAddressColumn,
                flatAddressColumn,
                addressTable);
    }

    @FXML
    private void addType(ActionEvent event) {
        addDAO.addType(idTypeTextField.getText(), nameTypeTextField.getText());
        initData.initType(idTypeColumn, nameTypeColumn, typeTable);
    }

    @FXML
    private void deleteType(ActionEvent event) {
        deleteDAO.deleteType(idTypeTextField.getText());
        initData.initType(idTypeColumn, nameTypeColumn, typeTable);
    }

    @FXML
    private void updateType(ActionEvent event) {
        updateDAO.updateType(idTypeTextField.getText(), nameTypeTextField.getText());
        initData.initType(idTypeColumn, nameTypeColumn, typeTable);
    }

}
