import java.net.InetSocketAddress;

import Handlers.RootHandler;
import com.sun.net.httpserver.HttpServer;

public class Server {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        System.out.println("Server listening on port: 8080");

        server.createContext("/", new RootHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }
}