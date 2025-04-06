import java.io.*;
import java.net.*;

public class Server {
    private int PORT = 8080;

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            serverSocket.setSoTimeout(10000);

            while (true) {
                System.out.println("Server is listening on port " + PORT);
                Socket acceptedConnection = serverSocket.accept();

                System.out.println("Connection accepted from client " + acceptedConnection.getRemoteSocketAddress());

                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream());

                BufferedReader fromClient = new BufferedReader(
                        new InputStreamReader(acceptedConnection.getInputStream()));

                toClient.println("Hello from the server");

                toClient.close();
                fromClient.close();
                acceptedConnection.close();
            }

        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + PORT + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}