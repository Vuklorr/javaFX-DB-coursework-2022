package ru.manikinos.profile.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.manikinos.profile.entity.Address;
import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllDataDAO {
    public ObservableList<Address> getAddressData() throws SQLException, ClassNotFoundException {
        ObservableList<Address> addresses = FXCollections.observableArrayList();
        final String GET_ADDRESSES_QUERY = "SELECT*\n" +
                "FROM Address;";
        try(
            Connection connection = Connections.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ADDRESSES_QUERY)
            ) {
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
        }
        return addresses;
    }
}
