import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.Socket;

public class Client {
    private static String name = "Client";
    private static String message;
    private static String output = "<html>Welcome to chat</html>";

    private static JFrame frame;
    private static JPanel outerPanel = new JPanel(new BorderLayout());
    private static JPanel topPanel = new JPanel(new BorderLayout());
    private static JPanel textPanel = new JPanel();
    private static JLabel label = new JLabel();
    private static JTextField text = new JTextField();
    private static JButton button = new JButton("Send");

    public Client(String name) {
        this.name = name;
    }

    private static JFrame getJFrame() {
        JFrame frame = new JFrame("Chat");

        label.setText(output);
        textPanel.add(label);

        topPanel.add(text, BorderLayout.CENTER);
        topPanel.add(button, BorderLayout.EAST);

        outerPanel.add(topPanel, BorderLayout.AFTER_LAST_LINE);
        outerPanel.add(textPanel, BorderLayout.WEST);

        frame.add(outerPanel);
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        return frame;
    }

    public static void main(String[] args) {
        frame = getJFrame();

        button.addActionListener(e -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            String begin = output.substring(0,output.length() - 7);
            String end = output.substring(output.length() - 7);
            message = text.getText();

            try (Socket socket = new Socket("127.0.0.1", 8000);
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ) {
                String request = name + ": " + message;

                writer.write(request);
                writer.newLine();
                writer.flush();

                String response = reader.readLine();
                output = begin + "<br>" + response + end;
                text.setText(null);
                label.setText(output);

                System.out.println(response);

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}
