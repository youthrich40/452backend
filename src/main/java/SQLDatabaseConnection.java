import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {
    private Connection connection;

    public void connectWithDatabase() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:mysql://localhost:3306/cs452project?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "password";

        System.out.println("Trying to connect to the database...");

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(connectionUrl, username, password);

        System.out.println("Database connected.");
    }
}
