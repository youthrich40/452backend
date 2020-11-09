package Handlers;

import Database.SQLDatabaseConnection;
import Models.Quiz;
import Models.Vocab;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizHandler extends BaseHandler {

    public List<Object> executeQuery(String query) throws SQLException {
        Connection connection = SQLDatabaseConnection.getInstance().getConnection();

        Statement statement = connection.createStatement();

        ResultSet results = statement.executeQuery(query);

        List<Quiz> quizList = new ArrayList<>();

        while (results.next()) {
            int questionID = results.getInt("questionID");
            int userID = results.getInt("userID");
            int number_of_attempts = results.getInt("number_of_attempts");

            Quiz quiz = new Quiz(questionID, userID, number_of_attempts);

            quizList.add(quiz);
        }

        return Collections.singletonList(quizList);
    }
}
