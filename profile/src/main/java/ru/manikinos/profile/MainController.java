package ru.manikinos.profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ru.manikinos.profile.dao.AddDAO;
import ru.manikinos.profile.dao.DeleteDAO;
import ru.manikinos.profile.dao.UpdateDAO;
import ru.manikinos.profile.datainit.SelectionMode;
import ru.manikinos.profile.entity.*;
import ru.manikinos.profile.datainit.InitData;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private TableView<PersonalData> personalDataTable;

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
    private Button addDocumentButton;

    @FXML
    private Button updateDocumentButton;

    @FXML
    private Button deleteDocumentButton;

    @FXML
    private TextField idDocumentTextField;
    @FXML
    private TextField idTypeDocumentTextField;
    @FXML
    private TextField idPDDocumentTextField;
    @FXML
    private DatePicker startDocumentDatePicker;
    @FXML
    private DatePicker endDocumentDatePicker;
    @FXML
    private TableView<Document> documentTable;

    @FXML
    private TableColumn<Address, Integer> flatAddressColumn;

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
    private TableColumn<Type, Integer> idTypeColumn;

    @FXML
    private TableColumn<Document, Integer> idTypeDocumentColumn;

    @FXML
    private TableColumn<PersonalData, String> namePDColumn;
    @FXML
    private TableColumn<Type, String> nameTypeColumn;
    @FXML
    private TableColumn<PersonalData, String> patronymicPDColumn;

    @FXML
    private Button updatePDButton;

    @FXML
    private Button addPDButton;

    @FXML
    private Button deletePDButton;
    @FXML
    private TextField idPDTextField;
    @FXML
    private TextField idAddressPDTextField;
    @FXML
    private TextField namePDTextField;
    @FXML
    private TextField patronymicPDTextField;
    @FXML
    private TextField surnamePDTextField;
    @FXML
    private TextField phoneNumberPDTextField;

    @FXML
    private TableColumn<PersonalData, String> phoneNumberPDColumn;
    @FXML
    private TableColumn<Address, String> regionAddressColumn;

    @FXML
    private Button addTypeRelationshipButton;

    @FXML
    private Button updateTypeRelationshipButton;

    @FXML
    private Button deleteTypeRelationshipButton;

    @FXML
    private Button addFRButton;
    @FXML
    private Button deleteFRButton;
    @FXML
    private Button updateFRButton;
    @FXML
    private TableColumn<Address, String> streetAddressColumn;

    @FXML
    private TableColumn<PersonalData, String> surnamePDColumn;
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
    private TextField idTypeTextField;
    @FXML
    private TextField nameTypeTextField;
    @FXML
    private TextField idTypeRelationshipTextField;
    @FXML
    private TextField nameTypeRelationshipTextField;
    @FXML
    private TextField idFirstFRTextField;
    @FXML
    private TextField idSecondFRTextField;
    @FXML
    private TextField idTypeFRTextField;
    @FXML
    private TableView<TypeOfRelationship> typeRelationshipTable;
    @FXML
    private TableColumn<TypeOfRelationship,Integer> idTypeRelationshipColumn;
    @FXML
    private TableColumn<TypeOfRelationship,String> nameTypeRelationshipColumn;
    @FXML
    private TableView<FamilyRelations> familyRelationsTable;
    @FXML
    private TableColumn<FamilyRelations,Integer> idFirstFRColumn;
    @FXML
    private TableColumn<FamilyRelations,Integer> idSecondFRColumn;
    @FXML
    private TableColumn<FamilyRelations,Integer> idTypeFRColumn;

    private final List<String> firstSecondOldFR = new ArrayList<>(2);

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

        initData.initDocument(idDocumentColumn,
                idTypeDocumentColumn,
                idPDDocumentColumn,
                dataStartDocumentColumn,
                dataEndDocumentColumn,
                documentTable);
        selectionMode.documentSelected(idDocumentTextField,
                idTypeDocumentTextField,
                idPDDocumentTextField,
                startDocumentDatePicker,
                endDocumentDatePicker,
                documentTable);

        initData.initFamilyRelationsData(idFirstFRColumn, idSecondFRColumn, idTypeFRColumn, familyRelationsTable);
        selectionMode.familyRelationsSelected(idFirstFRTextField, idSecondFRTextField, idTypeFRTextField, familyRelationsTable, firstSecondOldFR);

        initData.initPersonalData(idPDColumn,
                idAddressPDColumn,
                namePDColumn,
                patronymicPDColumn,
                surnamePDColumn,
                phoneNumberPDColumn,
                personalDataTable);
        selectionMode.personalDataSelected(idPDTextField,
                idAddressPDTextField,
                namePDTextField,
                patronymicPDTextField,
                surnamePDTextField,
                phoneNumberPDTextField,
                personalDataTable);

        initData.initType(idTypeColumn, nameTypeColumn, typeTable);
        selectionMode.typeSelected(idTypeTextField, nameTypeTextField, typeTable);

        initData.initTypeOfRelationship(idTypeRelationshipColumn, nameTypeRelationshipColumn, typeRelationshipTable);
        selectionMode.typeOfRelationshipSelected(idTypeRelationshipTextField, nameTypeRelationshipTextField, typeRelationshipTable);
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
    private void addDocument(ActionEvent event) {
        if(startDocumentDatePicker.getValue().isBefore(endDocumentDatePicker.getValue())) {
            addDAO.addDocument(idDocumentTextField.getText(),
                    idTypeDocumentTextField.getText(),
                    idPDDocumentTextField.getText(),
                    startDocumentDatePicker.getValue().toString(),
                    endDocumentDatePicker.getValue().toString());
            initData.initDocument(idDocumentColumn,
                    idTypeDocumentColumn,
                    idPDDocumentColumn,
                    dataStartDocumentColumn,
                    dataEndDocumentColumn,
                    documentTable);
        } else {
            throw new UnsupportedOperationException("StartDate should be before EndDate");
        }
    }

    @FXML
    private void deleteDocument(ActionEvent event) {
        deleteDAO.deleteDocument(idDocumentTextField.getText());
        initData.initDocument(idDocumentColumn,
                idTypeDocumentColumn,
                idPDDocumentColumn,
                dataStartDocumentColumn,
                dataEndDocumentColumn,
                documentTable);
    }

    @FXML
    private void updateDocument(ActionEvent event) {
        if(startDocumentDatePicker.getValue().isBefore(endDocumentDatePicker.getValue())) {


            updateDAO.updateDocument(idDocumentTextField.getText(),
                    idTypeDocumentTextField.getText(),
                    idPDDocumentTextField.getText(),
                    startDocumentDatePicker.getValue()
                            .toString(),
                    endDocumentDatePicker.getValue()
                            .toString());
            initData.initDocument(idDocumentColumn,
                    idTypeDocumentColumn,
                    idPDDocumentColumn,
                    dataStartDocumentColumn,
                    dataEndDocumentColumn,
                    documentTable);
        } else {
            throw new UnsupportedOperationException("StartDate should be before EndDate");
        }
    }

    @FXML
    private void addFamilyRelations(ActionEvent event) {
        addDAO.addFamilyRelations(idFirstFRTextField.getText(), idSecondFRTextField.getText(), idTypeFRTextField.getText());
        initData.initFamilyRelationsData(idFirstFRColumn, idSecondFRColumn, idTypeFRColumn, familyRelationsTable);
    }

    @FXML
    private void deleteFamilyRelations(ActionEvent event) {
        deleteDAO.deleteFamilyRelations(idFirstFRTextField.getText(), idSecondFRTextField.getText());
        initData.initFamilyRelationsData(idFirstFRColumn, idSecondFRColumn, idTypeFRColumn, familyRelationsTable);
    }

    @FXML
    private void updateFamilyRelations(ActionEvent event) {
        updateDAO.updateFamilyRelations(idFirstFRTextField.getText(), idSecondFRTextField.getText(), idTypeFRTextField.getText(), firstSecondOldFR);
        initData.initFamilyRelationsData(idFirstFRColumn, idSecondFRColumn, idTypeFRColumn, familyRelationsTable);
    }
    @FXML
    private void addPersonalData(ActionEvent event) {
        addDAO.addPersonalData(idPDTextField.getText(),
                idAddressPDTextField.getText(),
                namePDTextField.getText(),
                patronymicPDTextField.getText(),
                surnamePDTextField.getText(),
                phoneNumberPDTextField.getText());
        initData.initPersonalData(idPDColumn,
                idAddressPDColumn,
                namePDColumn,
                patronymicPDColumn,
                surnamePDColumn,
                phoneNumberPDColumn,
                personalDataTable);
    }

    @FXML
    private void deletePersonalData(ActionEvent event) {
        deleteDAO.deletePersonalData(idPDTextField.getText());
        initData.initPersonalData(idPDColumn,
                idAddressPDColumn,
                namePDColumn,
                patronymicPDColumn,
                surnamePDColumn,
                phoneNumberPDColumn,
                personalDataTable);
    }

    @FXML
    private void updatePersonalData(ActionEvent event) {
        updateDAO.updatePersonalData(idPDTextField.getText(),
                idAddressPDTextField.getText(),
                namePDTextField.getText(),
                patronymicPDTextField.getText(),
                surnamePDTextField.getText(),
                phoneNumberPDTextField.getText());
        initData.initPersonalData(idPDColumn,
                idAddressPDColumn,
                namePDColumn,
                patronymicPDColumn,
                surnamePDColumn,
                phoneNumberPDColumn,
                personalDataTable);
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

    @FXML
    private void addTypeRelationship(ActionEvent event) {
        addDAO.addTypeOfRelationship(idTypeRelationshipTextField.getText(), nameTypeRelationshipTextField.getText());
        initData.initTypeOfRelationship(idTypeRelationshipColumn, nameTypeRelationshipColumn, typeRelationshipTable);
    }

    @FXML
    private void deleteTypeRelationship(ActionEvent event) {
        deleteDAO.deleteTypeOfRelationship(idTypeRelationshipTextField.getText());
        initData.initTypeOfRelationship(idTypeRelationshipColumn, nameTypeRelationshipColumn, typeRelationshipTable);
    }
    @FXML
    private void updateTypeRelationship(ActionEvent event) {
        updateDAO.updateTypeOfRelationship(idTypeRelationshipTextField.getText(), nameTypeRelationshipTextField.getText());
        initData.initTypeOfRelationship(idTypeRelationshipColumn, nameTypeRelationshipColumn, typeRelationshipTable);
    }
}
