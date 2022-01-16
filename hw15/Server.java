import javax.swing.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    static class Handler implements Runnable {
        private final Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            Date dateNow = new Date();
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("E yyyy.MM.dd hh:mm:ss a");
            String currentDateTime = formatForDateNow.format(dateNow);

            try {
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String request = reader.readLine();
                String response = currentDateTime + " " + request;
                System.out.println(response);

                writer.write(response);
                writer.newLine();
                writer.flush();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (Exception exception) {
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 8000;
        System.out.println("Server starts working!");
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Handler(clientSocket));
        }
    }
}
