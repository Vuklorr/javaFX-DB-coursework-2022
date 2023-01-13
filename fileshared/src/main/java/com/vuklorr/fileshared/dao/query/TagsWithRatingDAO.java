package com.vuklorr.fileshared.dao.query;

import com.vuklorr.fileshared.entity.query.TagsWithRating;
import com.vuklorr.fileshared.util.Connections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TagsWithRatingDAO {
    Connection connection = Connections.getConnection();

    public TagsWithRatingDAO() throws SQLException, ClassNotFoundException {
    }

    public ObservableList<TagsWithRating> getData() {
        ObservableList<TagsWithRating> tags = FXCollections.observableArrayList();
        final String TAGS_WITH_RATING_DATA_QUERY = """
                SELECT ID_FILE, COUNT(ID_TAG), ROUND(1.0/COUNT(ID_TAG), 2) AS rating
                FROM FILE_TAG
                GROUP BY ID_FILE;
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(TAGS_WITH_RATING_DATA_QUERY)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idFile = resultSet.getInt(1);
                int countTag = resultSet.getInt(2);
                double rating = resultSet.getDouble(3);

                tags.add(new TagsWithRating(idFile, countTag, rating));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tags;
    }
}