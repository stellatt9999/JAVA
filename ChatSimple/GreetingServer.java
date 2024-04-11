import java.net.*;
import java.io.*;

public class GreetingServer extends Thread {
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        //serverSocket.setSoTimeout(10000);
    }

    public void run() {
        while(true) {
            try {
                //等待客户端连接socket
                System.out.println("========等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...========");
                Socket server = serverSocket.accept();
                System.out.println("服务端获取远程主机地址：" + server.getRemoteSocketAddress());
                //服务器输入流，来自客户端
                DataInputStream in = new DataInputStream(server.getInputStream());
                int number = 5;
                while (number > 0) {
                    System.out.println(in.readUTF());
                    number--;
                }
                //服务器输出流，用于写入客户端
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF(">>服务器响应: " + "Welcome connect : " + server.getLocalSocketAddress() + "\n>>服务器响应: Goodbye!");
                //关闭socket
                //server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String [] args) {
        int port = Integer.parseInt(args[0]);
        try {
            //建立服务端socketServer
            Thread t = new GreetingServer(port);
            t.run();   //自：这里 t.run(); 没有开启线程，没有new Thread()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}