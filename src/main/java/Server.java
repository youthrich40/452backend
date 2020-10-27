import java.net.InetSocketAddress;
import java.sql.SQLException;

import Handlers.RootHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        System.out.println("Server listening on port: 8080");

        server.createContext("/", new RootHandler());
        server.setExecutor(null); // creates a default executor
        server.start();

        SQLDatabaseConnection connection = new SQLDatabaseConnection();

        try {
            connection.connectWithDatabase();
        } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Error: could not connect with the database.");

            server.stop(0);
        }
    }
}