import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private int PORT = 8080;

    public void run() throws UnknownHostException, IOException {
        InetAddress address = InetAddress.getByName("localhost");
        Socket clientSocket = new Socket(address, PORT);

        PrintWriter toServer = new PrintWriter(clientSocket.getOutputStream());

        BufferedReader fromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        toServer.println("Hello from the client");

        String line = fromServer.readLine();

        System.out.println("Response from the socket is: " + line);

        toServer.close();
        fromServer.close();
        clientSocket.close();
    }

    public static void main(String[] args) {
        Client client = new Client();
        try {
            client.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
