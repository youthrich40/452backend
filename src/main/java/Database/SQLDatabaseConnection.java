package Database;

import java.sql.*;

public class SQLDatabaseConnection {
    private static SQLDatabaseConnection instance = new SQLDatabaseConnection();

    private Connection connection;

    private SQLDatabaseConnection(){}

    public static SQLDatabaseConnection getInstance() {
        return instance;
    }

    public void connectWithDatabase() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:mysql://localhost:3306/cs452project?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "password";

        System.out.println("Trying to connect to the database...");

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connectionUrl, username, password);

        System.out.println("Database connected.");
    }

    public Connection getConnection() {
        return connection;
    }
}
