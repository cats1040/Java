package MultiThreading;
// package MultiThreaded;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public class Server {

    private static int PORT = 8080;

    // function interface ??? first class citizen
    public Consumer<Socket> getConsumer() {
        return (clientSocket) -> {
            try {
                PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream());
                toClient.println("Hello from the server");
                toClient.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();

            ServerSocket serverSocket = new ServerSocket(PORT);

            serverSocket.setSoTimeout(10000); // 10s

            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket acceptedSocket = serverSocket.accept();

                Thread thread = new Thread(() -> server.getConsumer().accept(acceptedSocket));

                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
