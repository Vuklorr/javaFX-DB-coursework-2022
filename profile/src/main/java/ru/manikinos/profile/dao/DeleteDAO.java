package ru.manikinos.profile.dao;

import ru.manikinos.profile.util.Connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDAO {
    Connection connection = Connections.getConnection();

    public DeleteDAO() throws SQLException, ClassNotFoundException {
    }

    public void deleteAddress(String id) {
        final String DELETE_ADDRESS_QUERY = "DELETE FROM Address WHERE id = ?;";
        delete(DELETE_ADDRESS_QUERY, Integer.parseInt(id));
    }

    public void deleteDocument(String id) {
        final String DELETE_DOCUMENT_QUERY = "DELETE FROM Document WHERE id = ?;";
        delete(DELETE_DOCUMENT_QUERY, Integer.parseInt(id));

    }

    public void deleteFamilyRelations(String idFirstPerson, String idSecondPerson) {
        final String DELETE_FR_QUERY = "DELETE FROM Family_relations WHERE id_first_person = ? AND id_second_person = ?;";

        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE_FR_QUERY)) {
            preparedStatement.setInt(1, Integer.parseInt(idFirstPerson));
            preparedStatement.setInt(2, Integer.parseInt(idSecondPerson));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePersonalData(String id) {
        final String DELETE_DOCUMENT_QUERY = "DELETE FROM Personal_data WHERE id = ?;";
        delete(DELETE_DOCUMENT_QUERY, Integer.parseInt(id));
    }

    public void deleteType(String id) {
        final String DELETE_TYPE_QUERY = "DELETE FROM Type WHERE id = ?;";
        delete(DELETE_TYPE_QUERY, Integer.parseInt(id));

    }

    public void deleteTypeOfRelationship(String id) {
        final String DELETE_TYPE_QUERY = "DELETE FROM Type_of_relationship WHERE id = ?;";
        delete(DELETE_TYPE_QUERY, Integer.parseInt(id));
    }

    private void delete(final String QUERY, final int id) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
