package MultiThreading;
// package MultiThreaded;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    private int PORT = 8080;

    public Runnable getRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    InetAddress address = InetAddress.getByName("localhost");
                    Socket clientSocket = new Socket(address, PORT);

                    PrintWriter toServer = new PrintWriter(clientSocket.getOutputStream());
                    BufferedReader fromServer = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

                    toServer.println("hello from client " + clientSocket.getInetAddress());

                    String line = fromServer.readLine();

                    System.out.println("Response from server " + line);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public static void main(String[] args) {
        Client client = new Client();

        for (int i = 0; i < 100; i++) {
            try {
                Thread thread = new Thread(client.getRunnable());

                thread.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
