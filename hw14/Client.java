import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static String name;
    private static Scanner scanner = new Scanner(System.in);

    public Client(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to chat! Write your name, please!");

        Client client = new Client(scanner.nextLine());

        System.out.println("Write your message.");

        while (true)
            try (Socket socket = new Socket("127.0.0.1", 8000);
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                String request = name + ": " + scanner.nextLine();

                writer.write(request);
                writer.newLine();
                writer.flush();

                String response = reader.readLine();
                System.out.println(response);

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
