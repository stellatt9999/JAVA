import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); //服务端广播发送输入
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        new Thread(new ServerHandler(in)).start();

        Scanner scanner = new Scanner(System.in); //本客户端输入
        while (true) {
            String message = scanner.nextLine();
            out.println(message); //服务端输出
        }
    }

    private static class ServerHandler implements Runnable {
        private BufferedReader in;

        public ServerHandler(BufferedReader in) {
            this.in = in;
        }

        public void run() {
            try {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received server message: " + inputLine); //本客户端输出
                }
            } catch (IOException e) {
                System.err.println("Error handling server message: " + e);
            }
        }
    }
}