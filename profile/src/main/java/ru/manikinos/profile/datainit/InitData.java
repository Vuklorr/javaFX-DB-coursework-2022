package ru.manikinos.profile.datainit;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.manikinos.profile.dao.AllDataDAO;
import ru.manikinos.profile.entity.*;

import java.sql.SQLException;
import java.time.LocalDate;

public class InitData {
    private final AllDataDAO allDataDAO = new AllDataDAO();
    private final SelectionMode selectionMode = new SelectionMode();

    public InitData() throws SQLException, ClassNotFoundException {
    }

    public void initAddress(TableColumn<Address, Integer> idAddressColumn,
                            TableColumn<Address, String> countryAddressColumn,
                            TableColumn<Address, String> cityAddressColumn,
                            TableColumn<Address, String> regionAddressColumn,
                            TableColumn<Address, String> streetAddressColumn,
                            TableColumn<Address, String> houseAddressColumn,
                            TableColumn<Address, Integer> flatAddressColumn,
                            TableView<Address> addressTable) {

        idAddressColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        countryAddressColumn.setCellValueFactory(new PropertyValueFactory<>("country"));
        cityAddressColumn.setCellValueFactory(new PropertyValueFactory<>("city"));
        regionAddressColumn.setCellValueFactory(new PropertyValueFactory<>("region"));
        streetAddressColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
        houseAddressColumn.setCellValueFactory(new PropertyValueFactory<>("house"));
        flatAddressColumn.setCellValueFactory(new PropertyValueFactory<>("flat"));

        addressTable.setItems(allDataDAO.getAddressData());
    }
    
    public void initDocument(TableColumn<Document, Integer> idDocumentColumn,
                             TableColumn<Document, Integer> idTypeDocumentColumn,
                             TableColumn<Document, Integer> idPDDocumentColumn,
                             TableColumn<Document, LocalDate> dataStartDocumentColumn,
                             TableColumn<Document, LocalDate> dataEndDocumentColumn,
                             TableView<Document> documentTable) {
        idDocumentColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idTypeDocumentColumn.setCellValueFactory(new PropertyValueFactory<>("idType"));
        idPDDocumentColumn.setCellValueFactory(new PropertyValueFactory<>("idPersonalData"));
        dataStartDocumentColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        dataEndDocumentColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        documentTable.setItems(allDataDAO.getDocumentData());
    }

    public void initFamilyRelationsData(TableColumn<FamilyRelations, Integer> idFirstFRColumn, TableColumn<FamilyRelations, Integer> idSecondFRColumn, TableColumn<FamilyRelations, Integer> idTypeFRColumn, TableView<FamilyRelations> familyRelationsTable) {
        idFirstFRColumn.setCellValueFactory(new PropertyValueFactory<>("idFirstPerson"));
        idSecondFRColumn.setCellValueFactory(new PropertyValueFactory<>("idSecondPerson"));
        idTypeFRColumn.setCellValueFactory(new PropertyValueFactory<>("idTypeOfRelationship"));

        familyRelationsTable.setItems(allDataDAO.getFRData());
    }

    public void initPersonalData(TableColumn<PersonalData, Integer> idPDColumn,
                                 TableColumn<Address, Integer> idAddressPDColumn,
                                 TableColumn<PersonalData, String> namePDColumn,
                                 TableColumn<PersonalData, String> patronymicPDColumn,
                                 TableColumn<PersonalData, String> surnamePDColumn,
                                 TableColumn<PersonalData, String> phoneNumberPDColumn,
                                 TableView<PersonalData> personalDataTable) {
        idPDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        idAddressPDColumn.setCellValueFactory(new PropertyValueFactory<>("idAddress"));
        namePDColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        patronymicPDColumn.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        surnamePDColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        phoneNumberPDColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        personalDataTable.setItems(allDataDAO.getPDData());
    }

    public void initType(TableColumn<Type, Integer> idTypeColumn,
                                TableColumn<Type, String> nameTypeColumn,
                                TableView<Type> typeTable) {
        idTypeColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTypeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        typeTable.setItems(allDataDAO.getTypeData());
    }

    public void initTypeOfRelationship(TableColumn<TypeOfRelationship, Integer> idTypeRelationshipColumn, TableColumn<TypeOfRelationship, String> nameTypeRelationshipColumn, TableView<TypeOfRelationship> typeRelationshipTable) {
        idTypeRelationshipColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTypeRelationshipColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        typeRelationshipTable.setItems(allDataDAO.getTypeOfRelationshipData());
    }
}
