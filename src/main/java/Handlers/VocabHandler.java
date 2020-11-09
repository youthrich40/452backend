package Handlers;

import Database.SQLDatabaseConnection;
import Models.Vocab;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VocabHandler extends BaseHandler {

    public List<Object> executeQuery(String query) throws SQLException {
        Connection connection = SQLDatabaseConnection.getInstance().getConnection();

        Statement statement = connection.createStatement();

        ResultSet results = statement.executeQuery(query);

        List<Vocab> vocabList = new ArrayList<>();

        while (results.next()) {
            int vocabID = results.getInt("vocabID");
            int userID = results.getInt("userID");
            String value = results.getString("value");
            String englishValue = results.getString("english_value");
            String description = results.getString("description");
            Date prevReviewed = results.getDate("prev_reviewed");
            Date curReviewed = results.getDate("cur_reviewed");
            int totalViews = results.getInt("total_views");

            Vocab vocab = new Vocab(vocabID, userID, value, description, englishValue, prevReviewed, curReviewed, totalViews);

            vocabList.add(vocab);
        }

        return Collections.singletonList(vocabList);
    }
}