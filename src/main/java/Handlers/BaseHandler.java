package Handlers;

import Database.SQLDatabaseConnection;
import Models.Vocab;
import com.google.gson.Gson;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if(httpExchange.getRequestMethod().equals("GET")) {
            handleGetRequest(httpExchange);
        } else {
            handlePostRequest(httpExchange);
        }
    }

    private void handleGetRequest(HttpExchange t) throws IOException {
        InputStreamReader isReader = new InputStreamReader(t.getRequestBody(), StandardCharsets.UTF_8);

        BufferedReader reader = new BufferedReader(isReader);
        String query = reader.readLine();

        String response = "";

        try {
            List<Object> list = executeQuery(query);

            Headers headers = t.getResponseHeaders();
            headers.set("Content-Type", String.format("application/json; charset=%s", StandardCharsets.UTF_8));

            response = new Gson().toJson(list);

            final byte[] rawResponseBody = response.getBytes(StandardCharsets.UTF_8);
            t.sendResponseHeaders(200, rawResponseBody.length);
            t.getResponseBody().write(rawResponseBody);

        } catch (SQLException e) {
            response = e.getMessage();

            t.sendResponseHeaders(e.getErrorCode(), response.length());

            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    private void handlePostRequest(HttpExchange t) throws IOException {
        InputStreamReader isReader = new InputStreamReader(t.getRequestBody(), StandardCharsets.UTF_8);

        BufferedReader reader = new BufferedReader(isReader);
        String update = reader.readLine();

        String response = "";

        try {
            executeUpdate(update);
            response = "Successfully executed query.";

            t.sendResponseHeaders(200, response.length());
        } catch (SQLException e) {
            response = e.getMessage();

            t.sendResponseHeaders(417, response.length());
        }

        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();

        System.out.println(response);
    }

    public abstract List<Object> executeQuery(String query) throws SQLException;

    public void executeUpdate(String update) throws SQLException {
        Connection connection = SQLDatabaseConnection.getInstance().getConnection();

        Statement statement = connection.createStatement();

        statement.executeUpdate(update);
    }
}
