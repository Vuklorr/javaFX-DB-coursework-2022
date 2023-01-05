package ru.manikinos.profile.datainit;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.manikinos.profile.dao.AllDataDAO;
import ru.manikinos.profile.entity.Address;
import ru.manikinos.profile.entity.Document;
import ru.manikinos.profile.entity.Type;

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

    public void initType(TableColumn<Type, Integer> idTypeColumn,
                                TableColumn<Type, String> nameTypeColumn,
                                TableView<Type> typeTable) {
        idTypeColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameTypeColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        typeTable.setItems(allDataDAO.getTypeData());
    }
}
