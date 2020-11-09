package Handlers;

import Database.SQLDatabaseConnection;
import Models.Quiz;
import Models.QuizAttempts;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizAttemptsHandler extends BaseHandler {

    @Override
    public List<Object> executeQuery(String query) throws SQLException {
        Connection connection = SQLDatabaseConnection.getInstance().getConnection();

        Statement statement = connection.createStatement();

        ResultSet results = statement.executeQuery(query);

        List<QuizAttempts> attemptsList = new ArrayList<>();

        while (results.next()) {
            int attemptID = results.getInt("attemptID");
            int userID = results.getInt("userID");
            int questionID = results.getInt("questionID");
            String answerSubmitted = results.getString("answer_submitted");
            Date attempt_date = results.getDate("attempt_date");

            QuizAttempts attempt = new QuizAttempts(attemptID, userID, questionID, answerSubmitted);
            attempt.setAttemptDate(attempt_date);

            attemptsList.add(attempt);
        }

        return Collections.singletonList(attemptsList);
    }
}
