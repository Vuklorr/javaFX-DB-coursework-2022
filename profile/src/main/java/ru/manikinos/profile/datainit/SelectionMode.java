package ru.manikinos.profile.datainit;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ru.manikinos.profile.entity.*;

import java.util.List;

public class SelectionMode {
    public void addressSelected(TextField idAddressTextField,
                                TextField countryAddressTextField,
                                TextField cityAddressTextField,
                                TextField regionAddressTextField,
                                TextField streetAddressTextField,
                                TextField houseAddressTextField,
                                TextField flatAddressTextField,
                                TableView<Address> addressTable) {
        TableView.TableViewSelectionModel<Address> selectionModel = addressTable.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, address, newAddress) -> {
            if(newAddress != null) {
                idAddressTextField.setText(String.valueOf(newAddress.getId()));
                countryAddressTextField.setText(newAddress.getCountry());
                cityAddressTextField.setText(newAddress.getCity());
                regionAddressTextField.setText(newAddress.getRegion());
                streetAddressTextField.setText(newAddress.getStreet());
                houseAddressTextField.setText(newAddress.getHouse());
                flatAddressTextField.setText(String.valueOf(newAddress.getFlat()));
            }
        });
    }

    public void documentSelected(TextField idDocumentTextField,
                                 TextField idTypeDocumentTextField,
                                 TextField idPDDocumentTextField,
                                 DatePicker startDocumentDatePicker,
                                 DatePicker endDocumentDatePicker,
                                 TableView<Document> documentTable) {
        TableView.TableViewSelectionModel<Document> selectionModel = documentTable.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, document, newDocument) -> {
            if(newDocument != null) {
                idDocumentTextField.setText(String.valueOf(newDocument.getId()));
                idTypeDocumentTextField.setText(String.valueOf(newDocument.getIdType()));
                idPDDocumentTextField.setText(String.valueOf(newDocument.getIdPersonalData()));
                startDocumentDatePicker.setValue(newDocument.getStartDate());
                endDocumentDatePicker.setValue(newDocument.getEndDate());
            }
        });
    }

    public void familyRelationsSelected(TextField idFirstFRTextField, TextField idSecondFRTextField, TextField idTypeTextField, TableView<FamilyRelations> familyRelationsTable, List<String> firstSecondOldFR) {
        TableView.TableViewSelectionModel<FamilyRelations> selectionModel = familyRelationsTable.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, familyRelations, newFR) -> {
            if(newFR != null) {
                firstSecondOldFR.clear();

                idFirstFRTextField.setText(String.valueOf(newFR.getIdFirstPerson()));
                idSecondFRTextField.setText(String.valueOf(newFR.getIdSecondPerson()));
                idTypeTextField.setText(String.valueOf(newFR.getIdTypeOfRelationship()));

                firstSecondOldFR.add(idFirstFRTextField.getText());
                firstSecondOldFR.add(idSecondFRTextField.getText());
            }
        });
    }

    public void personalDataSelected(TextField idPDTextField,
                             TextField idAddressPDTextField,
                             TextField namePDTextField,
                             TextField patronymicPDTextField,
                             TextField surnamePDTextField,
                             TextField phoneNumberPDTextField,
                             TableView<PersonalData> personalDataTable) {
        TableView.TableViewSelectionModel<PersonalData> selectionModel = personalDataTable.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, personalData, newPD) -> {
            if(newPD != null) {
                idPDTextField.setText(String.valueOf(newPD.getId()));
                idAddressPDTextField.setText(String.valueOf(newPD.getIdAddress()));
                namePDTextField.setText(newPD.getName());
                patronymicPDTextField.setText(newPD.getPatronymic());
                surnamePDTextField.setText(newPD.getSurname());
                phoneNumberPDTextField.setText(String.valueOf(newPD.getPhoneNumber()));
            }
        });
    }

    public void typeSelected(TextField idTypeTextField, TextField nameTypeTextField, TableView<Type> typeTable) {
        TableView.TableViewSelectionModel<Type> selectionModel = typeTable.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, type, newType) -> {
            if(newType != null) {
                idTypeTextField.setText(String.valueOf(newType.getId()));
                nameTypeTextField.setText(newType.getName());
            }
        });
    }

    public void typeOfRelationshipSelected(TextField idTypeRelationshipTextField, TextField nameTypeRelationshipTextField, TableView<TypeOfRelationship> typeRelationshipTable) {
        TableView.TableViewSelectionModel<TypeOfRelationship> selectionModel = typeRelationshipTable.getSelectionModel();
        selectionModel.selectedItemProperty().addListener((observableValue, type, newType) -> {
            if(newType != null) {
                idTypeRelationshipTextField.setText(String.valueOf(newType.getId()));
                nameTypeRelationshipTextField.setText(newType.getName());
            }
        });
    }
}
