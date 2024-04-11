import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    private static Set<Socket> clients = new HashSet<Socket>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server started");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            clients.add(clientSocket);
            new Thread(new ClientHandler(clientSocket)).start();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;

        public ClientHandler(Socket socket) throws IOException {
            this.clientSocket = socket;
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //客户端输入
        }

        public void run() {
            try {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received client message: " + inputLine); //服务端输出
                    broadcast(inputLine);
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e);
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e);
                }
            }
        }

        private void broadcast(String message) {
            for (Socket client : clients) {
                if (client != clientSocket) {
                    try {
                        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                        out.println(message); //其他客户端输出
                    } catch (IOException e) {
                        System.err.println("Error broadcasting message: " + e);
                    }
                }
            }
        }
    }
}