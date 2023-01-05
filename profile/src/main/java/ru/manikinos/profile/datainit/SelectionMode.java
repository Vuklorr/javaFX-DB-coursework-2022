package ru.manikinos.profile.datainit;

import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import ru.manikinos.profile.entity.Address;
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
