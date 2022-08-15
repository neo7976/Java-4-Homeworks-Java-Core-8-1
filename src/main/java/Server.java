import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Hello! Server started!");
        int port = 2125;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept(); // ожидание подтверждения
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                System.out.println("New connection accept! Port: " + clientSocket.getPort());
                final String name = in.readLine();
                out.println(String.format("Привет %s!, твой порт подключения: [%d ]", name, clientSocket.getPort()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
