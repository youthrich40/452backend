package Handlers;

import Database.SQLDatabaseConnection;
import Models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserHandler extends BaseHandler {

    @Override
    public List<Object> executeQuery(String query) throws SQLException {
        Connection connection = SQLDatabaseConnection.getInstance().getConnection();

        Statement statement = connection.createStatement();

        ResultSet results = statement.executeQuery(query);

        List<User> userList = new ArrayList<>();

        while (results.next()) {
            int userID = results.getInt("userID");
            String purchaseInfo = results.getString("purchaseInfo");

            User user = new User(userID, purchaseInfo);

            userList.add(user);
        }

        return Collections.singletonList(userList);
    }
}
