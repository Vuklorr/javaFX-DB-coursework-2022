package ru.manikinos.profile;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.manikinos.profile.entity.*;

import java.time.LocalDate;

public class MainController {

    @FXML
    private TableView<PersonalData> PDTable;

    @FXML
    private Button addressAcceptButton;

    @FXML
    private Button addressAddButton;

    @FXML
    private Button addressCancelButton;

    @FXML
    private Button addressDeleteButton;

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
    private Button typeAcceptButton;

    @FXML
    private Button typeAddButton;

    @FXML
    private Button typeCancelButton;

    @FXML
    private Button typeDeleteButton;

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
    private final ObservableList<Type> typeData = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        initDataType();

        idTypeColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTypeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        typeTable.setItems(typeData);
    }

    private void initDataType() {
        typeData.add(new Type(1, "qq"));
        typeData.add(new Type(2, "ww"));
        typeData.add(new Type(3, "ew"));
    }

}
