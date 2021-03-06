package Communication;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by Topper on 5/14/2018.
 */

public class ServerCommunicator {

    private final int MAX_WAITING = 20;
    private HttpServer server;

    private void run(String portNum) {
        try {
            server = HttpServer.create(new InetSocketAddress(Integer.parseInt(portNum)), MAX_WAITING);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error starting server");
            return;
        }

        server.setExecutor(null);

        server.createContext("/command", new CommandHandler());

        server.start();

    }

    public static void main(String[] portNum) {
        String port = "";
        if (portNum.length == 0) {
            port = "8080";
        }
        else {
            port = portNum[0];
        }
        System.out.println("Starting Server on port " + port);
        new ServerCommunicator().run(port);
        System.out.println("Server started successfully on port " + port);
    }
}
