import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String hostname = "192.168.0.62"; // 服务器的IP地址
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            System.out.println("Connected to server");

            // 输入输出流
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            // 通信
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String text;

            do {
                System.out.print("Enter message: ");
                text = consoleReader.readLine(); // 从控制台输入
                writer.println(text);           // 发送到服务器

                String response = reader.readLine(); // 从服务器接收
                System.out.println("Server replied: " + response);
            } while (!text.equalsIgnoreCase("bye"));

            socket.close();
        } catch (UnknownHostException ex) {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
