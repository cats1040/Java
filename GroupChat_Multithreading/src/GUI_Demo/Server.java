// package GUI_Demo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static Console console;

    private static int PORT = 8080;
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        console = new Console();
        this.serverSocket = serverSocket;
    }

    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected");

                console.textArea.append("A new client has connected\n");

                ClientHandler clientHandler = new ClientHandler(socket);

                Thread thread = new Thread(clientHandler); // clientHandler -> runnable target

                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Server server = new Server(serverSocket);
            server.startServer();
            // console.writeToConsole("hello");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
