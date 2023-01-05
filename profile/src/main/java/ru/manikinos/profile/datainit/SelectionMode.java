package ru.manikinos.profile.datainit;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ru.manikinos.profile.entity.Address;
import ru.manikinos.profile.entity.Document;
import ru.manikinos.profile.entity.PersonalData;
import ru.manikinos.profile.entity.Type;

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

    public void personalData(TextField idPDTextField,
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
}
