package Handlers;

import Database.SQLDatabaseConnection;
import Models.Vocab;
import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VocabHandler extends BaseHandler {

//    public void handle(HttpExchange t) throws IOException {
//        if(t.getRequestMethod().equals("GET")) {
//            handleGetRequest(t);
//        } else {
//            handlePostRequest(t);
//        }
//    }
//
//    private void handleGetRequest(HttpExchange t) throws IOException {
//        InputStreamReader isReader = new InputStreamReader(t.getRequestBody(), StandardCharsets.UTF_8);
//
//        BufferedReader reader = new BufferedReader(isReader);
//        String query = reader.readLine();
//
//        String response = "";
//
//        try {
//            List<Vocab> vocab = executeQuery(query);
//
//            Headers headers = t.getResponseHeaders();
//            headers.set("Content-Type", String.format("application/json; charset=%s", StandardCharsets.UTF_8));
//
//            response = new Gson().toJson(vocab);
//
//            final byte[] rawResponseBody = response.getBytes(StandardCharsets.UTF_8);
//            t.sendResponseHeaders(200, rawResponseBody.length);
//            t.getResponseBody().write(rawResponseBody);
//
//        } catch (SQLException e) {
//            response = e.getMessage();
//
//            t.sendResponseHeaders(e.getErrorCode(), response.length());
//
//            OutputStream os = t.getResponseBody();
//            os.write(response.getBytes());
//            os.close();
//        }
//    }
//
//    private void handlePostRequest(HttpExchange t) throws IOException {
//        InputStreamReader isReader = new InputStreamReader(t.getRequestBody(), StandardCharsets.UTF_8);
//
//        BufferedReader reader = new BufferedReader(isReader);
//        String update = reader.readLine();
//
//        String response = "";
//
//        try {
//            executeUpdate(update);
//            response = "Successfully executed query.";
//
//            t.sendResponseHeaders(200, response.length());
//        } catch (SQLException e) {
//            response = e.getMessage();
//
//            t.sendResponseHeaders(417, response.length());
//        }
//
//        OutputStream os = t.getResponseBody();
//        os.write(response.getBytes());
//        os.close();
//
//        System.out.println(response);
//    }

    public List<Vocab> executeQuery(String query) throws SQLException {
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

        return vocabList;
    }

//    public void executeUpdate(String update) throws SQLException {
//        Connection connection = SQLDatabaseConnection.getInstance().getConnection();
//
//        Statement statement = connection.createStatement();
//
//        statement.executeUpdate(update);
//    }
}