import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {


    public static void main(String[] args) {
        try (Socket clientSocket = new Socket("localhost", 8080);
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            System.out.println("Connected");
            writer.println("Dimka");
            System.out.println("Прислано: " + reader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
