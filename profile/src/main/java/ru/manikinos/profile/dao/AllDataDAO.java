package ru.manikinos.profile.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.manikinos.profile.entity.*;
import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AllDataDAO {
    private final Connection connection = Connections.getConnection();

    public AllDataDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<Address> getAddressData()  {
        ObservableList<Address> addresses = FXCollections.observableArrayList();
        final String GET_ADDRESSES_QUERY = "SELECT*\n" +
                "FROM Address;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_ADDRESSES_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String country = resultSet.getString(2);
                String city = resultSet.getString(3);
                String region = resultSet.getString(4);
                String street = resultSet.getString(5);
                String house = resultSet.getString(6);
                int flat = resultSet.getInt(7);

                addresses.add(new Address(id, country, city, region, street, house, flat));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return addresses;
    }

    public ObservableList<Document> getDocumentData() {
        ObservableList<Document> documents = FXCollections.observableArrayList();
        final String GET_DOCUMENTS_QUERY = "SELECT*\n" +
                "FROM Document;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_DOCUMENTS_QUERY)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int idType = resultSet.getInt(2);
                int idPersonalData = resultSet.getInt(3);
                LocalDate startDate = LocalDate.parse(resultSet.getString(4));
                LocalDate endDate = LocalDate.parse(resultSet.getString(5));

                documents.add(new Document(id, idType, idPersonalData, startDate, endDate));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return documents;
    }

    public ObservableList<FamilyRelations> getFRData() {
        ObservableList<FamilyRelations> familyRelations = FXCollections.observableArrayList();
        final String GET_FR_QUERY = "SELECT*\n" +
                "FROM Family_relations;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_FR_QUERY)){
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idFirstPerson = resultSet.getInt(1);
                int idSecondPerson = resultSet.getInt(2);
                int idTypeOfRelationship = resultSet.getInt(3);

                familyRelations.add(new FamilyRelations(idFirstPerson, idSecondPerson, idTypeOfRelationship));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return familyRelations;
    }

    public ObservableList<PersonalData> getPDData() {
        ObservableList<PersonalData> personalData = FXCollections.observableArrayList();
        final String GET_PD_QUERY = "SELECT*\n" +
                "FROM Personal_data;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_PD_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                int idAddress = resultSet.getInt(2);
                String name = resultSet.getString(3);
                String patronymic = resultSet.getString(4);
                String surname = resultSet.getString(5);
                String phoneNumber = resultSet.getString(6);

                personalData.add(new PersonalData(id, idAddress, name, patronymic, surname, phoneNumber));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return personalData;
    }

    public ObservableList<Type> getTypeData() {
        ObservableList<Type> types = FXCollections.observableArrayList();
        final String GET_TYPES_QUERY = "SELECT*\n" +
                "FROM Type;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_TYPES_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                types.add(new Type(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return types;
    }

    public ObservableList<TypeOfRelationship> getTypeOfRelationshipData() {
        ObservableList<TypeOfRelationship> types = FXCollections.observableArrayList();
        final String GET_TYPES_QUERY = "SELECT*\n" +
                "FROM Type_of_relationship;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_TYPES_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                types.add(new TypeOfRelationship(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return types;
    }

    public ObservableList<WorkActivity> getWorkActivityData() {
        ObservableList<WorkActivity> workActivities = FXCollections.observableArrayList();
        final String GET_WA_QUERY = "SELECT*\n" +
                "FROM Work_activity;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_WA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String nameCompany = resultSet.getString(2);
                String nameWork = resultSet.getString(3);
                int salary = resultSet.getInt(4);

                workActivities.add(new WorkActivity(id, nameCompany, nameWork, salary));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workActivities;
    }

    public ObservableList<WorkActivityPersonal> getWorkActivityPersonData() {
        ObservableList<WorkActivityPersonal> workActivityPersonals = FXCollections.observableArrayList();
        final String GET_WAP_QUERY = "SELECT*\n" +
                "FROM Work_activity_personal;";
        try(PreparedStatement preparedStatement = connection.prepareStatement(GET_WAP_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idPersonal = resultSet.getInt(1);
                int idWork = resultSet.getInt(2);
                LocalDate dateOfHiring = LocalDate.parse(resultSet.getString(3));
                LocalDate dateOfDismissal = LocalDate.parse(resultSet.getString(4));

                workActivityPersonals.add(new WorkActivityPersonal(idPersonal, idWork, dateOfHiring, dateOfDismissal));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return workActivityPersonals;
    }
}
