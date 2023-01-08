package ru.manikinos.profile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import ru.manikinos.profile.controller.ProfileRelativeController;
import ru.manikinos.profile.dao.AddDAO;
import ru.manikinos.profile.dao.DeleteDAO;
import ru.manikinos.profile.dao.QueryDAO;
import ru.manikinos.profile.dao.UpdateDAO;
import ru.manikinos.profile.datainit.SelectionMode;
import ru.manikinos.profile.entity.*;
import ru.manikinos.profile.datainit.InitData;
import ru.manikinos.profile.entity.query.NearestPerson;
import ru.manikinos.profile.entity.query.SearchPerson;
import ru.manikinos.profile.util.SceneMoves;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    @FXML
    private TextField nameSearchTextField;
    @FXML
    private TextField patronymicSearchTextField;
    @FXML
    private TextField surnameSearchTextField;
    @FXML
    private TextField phoneNumberSearchTextField;
    @FXML
    private TextField documentSearchTextField;
    @FXML
    private Button searchButton;
    @FXML
    private Label searchPersonLabel;
    @FXML
    private Button processingOfPDButton;
    @FXML
    private Button profileRelativeButton;
    @FXML
    private Button workBookButton;
    @FXML
    private Button profileButton;
    @FXML
    private Button privateContactButton;
    @FXML
    private Button listAllWorksButton;
    @FXML
    private Button listAllDocumentsButton;
    @FXML
    private Button nearestPersonButton;
    @FXML
    private Label nearestPersonLabel;
    @FXML
    private TableView<PersonalData> personalDataTable;
    @FXML
    private Button listRecruit;

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
    private TableColumn<Document, LocalDate> dateEndDocumentColumn;

    @FXML
    private TableColumn<Document, LocalDate> dateStartDocumentColumn;
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
    @FXML
    private Button addWAButton;
    @FXML
    private Button deleteWAButton;
    @FXML
    private Button updateWAButton;
    @FXML
    private Button addWAPButton;
    @FXML
    private Button deleteWAPButton;
    @FXML
    private Button updateWAPButton;
    @FXML
    private TableView<WorkActivity> workActivityTable;
    @FXML
    private TableColumn<WorkActivity, Integer> idWAColumn;
    @FXML
    private TableColumn<WorkActivity, String> nameCompanyWAColumn;
    @FXML
    private TableColumn<WorkActivity, String> nameWAColumn;
    @FXML
    private TableColumn<WorkActivity, Integer> salaryWAColumn;
    @FXML
    private TextField idWATextField;
    @FXML
    private TextField nameCompanyWATextField;
    @FXML
    private TextField nameWATextField;
    @FXML
    private TextField salaryWATextField;
    @FXML
    private TableView<WorkActivityPersonal> workActivityPersonalTable;
    @FXML
    private TableColumn<WorkActivityPersonal, Integer> idWorkWAPColumn;
    @FXML
    private TableColumn<WorkActivityPersonal, Integer> idPersonWAPColumn;
    @FXML
    private TableColumn<WorkActivityPersonal, LocalDate> dateOfHiringWAPColumn;
    @FXML
    private TableColumn<WorkActivityPersonal, LocalDate> dateOfDismissalWAPColumn;
    @FXML
    private TextField idWorkWAPTextField;
    @FXML
    private TextField idPersonWAPTextField;
    @FXML
    private DatePicker dateOfHiringWAPDatePicker;
    @FXML
    private DatePicker dateOfDismissalWAPDatePicker;

    private final List<String> firstSecondOldFR = new ArrayList<>(2);

    private final List<String> personWorkOldWAP = new ArrayList<>(2);

    private final InitData initData = new InitData();
    private final SelectionMode selectionMode = new SelectionMode();
    private final AddDAO addDAO = new AddDAO();
    private final UpdateDAO updateDAO = new UpdateDAO();
    private final DeleteDAO deleteDAO = new DeleteDAO();
    private final QueryDAO queryDAO = new QueryDAO();
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
                dateStartDocumentColumn,
                dateEndDocumentColumn,
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

        initData.initWorkActivity(idWAColumn, nameCompanyWAColumn, nameWAColumn, salaryWAColumn, workActivityTable);
        selectionMode.workActivitySelected(idWATextField, nameCompanyWATextField, nameWATextField, salaryWATextField, workActivityTable);

        initData.initWorkActivityPersonal(idPersonWAPColumn, idWorkWAPColumn, dateOfHiringWAPColumn, dateOfDismissalWAPColumn, workActivityPersonalTable);
        selectionMode.workActivityPersonSelected(idPersonWAPTextField, idWorkWAPTextField, dateOfHiringWAPDatePicker, dateOfDismissalWAPDatePicker, workActivityPersonalTable, personWorkOldWAP);
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
                    dateStartDocumentColumn,
                    dateEndDocumentColumn,
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
                dateStartDocumentColumn,
                dateEndDocumentColumn,
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
                    dateStartDocumentColumn,
                    dateEndDocumentColumn,
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

    @FXML
    private void addWorkActivity(ActionEvent event) {
        addDAO.addWorkActivity(idWATextField.getText(),
                nameCompanyWATextField.getText(),
                nameWATextField.getText(),
                salaryWATextField.getText());
        initData.initWorkActivity(idWAColumn, nameCompanyWAColumn, nameWAColumn, salaryWAColumn,workActivityTable);
    }

    @FXML
    private void deleteWorkActivity(ActionEvent event) {
        deleteDAO.deleteWorkActivity(idWATextField.getText());
        initData.initWorkActivity(idWAColumn, nameCompanyWAColumn, nameWAColumn, salaryWAColumn,workActivityTable);
    }

    @FXML
    private void updateWorkActivity(ActionEvent event) {
        updateDAO.updateWorkActivity(idWATextField.getText(),
                nameCompanyWATextField.getText(),
                nameWATextField.getText(),
                salaryWATextField.getText());
        initData.initWorkActivity(idWAColumn, nameCompanyWAColumn, nameWAColumn, salaryWAColumn,workActivityTable);
    }

    @FXML
    private void addWorkActivityPersonal(ActionEvent event) {
        if(dateOfHiringWAPDatePicker.getValue().isBefore(dateOfDismissalWAPDatePicker.getValue())) {
            addDAO.addWorkActivityPersonal(idPersonWAPTextField.getText(),
                    idWorkWAPTextField.getText(),
                    dateOfHiringWAPDatePicker.getValue().toString(),
                    dateOfDismissalWAPDatePicker.getValue().toString());
            initData.initWorkActivityPersonal(idPersonWAPColumn, idWorkWAPColumn, dateOfHiringWAPColumn, dateOfDismissalWAPColumn, workActivityPersonalTable);
        } else {
            throw new UnsupportedOperationException("Date of hiring should be before Date of dismissal");
        }
    }

    @FXML
    private void deleteWorkActivityPersonal(ActionEvent event) {
        deleteDAO.deleteWorkActivityPerson(idPersonWAPTextField.getText(), idWorkWAPTextField.getText());
        initData.initWorkActivityPersonal(idPersonWAPColumn, idWorkWAPColumn, dateOfHiringWAPColumn, dateOfDismissalWAPColumn, workActivityPersonalTable);
    }

    @FXML
    private void updateWorkActivityPersonal(ActionEvent event) {
        updateDAO.updateWorkActivityPersonal(idPersonWAPTextField.getText(),
                idWorkWAPTextField.getText(),
                dateOfHiringWAPDatePicker.getValue().toString(),
                dateOfDismissalWAPDatePicker.getValue().toString(),
                personWorkOldWAP);
        initData.initWorkActivityPersonal(idPersonWAPColumn, idWorkWAPColumn, dateOfHiringWAPColumn, dateOfDismissalWAPColumn, workActivityPersonalTable);
    }

    @FXML
    private void searchNearestPerson(ActionEvent event) {
        NearestPerson person = null;
        try {
            person = queryDAO.getNearestPerson(countryAddressTextField.getText(),
                    cityAddressTextField.getText(),
                    regionAddressTextField.getText(),
                    streetAddressTextField.getText(),
                    houseAddressTextField.getText(),
                    idAddressTextField.getText(),
                    flatAddressTextField.getText());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        nearestPersonLabel.setText(person.getId() + " " + person.getSurname() + " " + person.getName() + " " + person.getPatronymic());

    }

    @FXML
    private void getListAllWorks(ActionEvent event) {
        SceneMoves.openNewScene("listAllWorks-view.fxml", listAllWorksButton, "Список всех мест работы с отработанным стажем и ставкой");
    }

    @FXML
    private void getListAllDocuments(ActionEvent event) {
        SceneMoves.openNewScene("listAllDocuments-view.fxml", listAllDocumentsButton, "Список всех документов человека и их количество");
    }

    @FXML
    private void getListRecruit(ActionEvent event) {
        SceneMoves.openNewScene("listRecruit-view.fxml", listRecruit, "Список всех людей, подлежащих ближайшему призыву");
    }

    @FXML
    private void getPrivateContact(ActionEvent event) {
        SceneMoves.openNewScene("privateContact-view.fxml", privateContactButton, "Приватные контакты человека");
    }

    @FXML
    private void getProfile(ActionEvent event) {
        SceneMoves.openNewScene("profile-view.fxml", profileButton, "Анкета");
    }

    @FXML
    private void getWorkBook(ActionEvent event) {
        SceneMoves.openNewScene("workBook-view.fxml", workBookButton, "Трудовая книжка");
    }

    @FXML
    private void getProfileRelative(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("profileRelative-view.fxml"));
        Parent root = loader.load();

        ProfileRelativeController profileRelativeController = loader.getController();
        profileRelativeController.setIdRelativeLabel(idSecondFRTextField.getText());

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Анкета родственника");
        stage.show();
        //SceneMoves.openNewScene("profileRelative-view.fxml", profileRelativeButton, "Анкета родственника");
    }

    @FXML
    private void getProcessingOfPD(ActionEvent event) {
        SceneMoves.openNewScene("processingPD-view.fxml", processingOfPDButton, "Согласие на обработку персональных данных");
    }

    @FXML
    private void searchPerson(ActionEvent event) {
        SearchPerson person = queryDAO.searchPerson(nameSearchTextField.getText(), patronymicSearchTextField.getText(), surnameSearchTextField.getText(), phoneNumberSearchTextField.getText(), documentSearchTextField.getText());
        searchPersonLabel.setText(person.getId() + " " + person.getName() + " " + person.getPatronymic() + " " + person.getSurname());
    }
}