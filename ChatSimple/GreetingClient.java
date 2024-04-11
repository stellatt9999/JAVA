import java.net.*;
import java.io.*;
import java.util.*;  //Scanner

public class GreetingClient
{
    public static void main(String [] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        int number = 5;
        // while(number > 0) {        
        //     try {
        //         //建立客户端socket
        //         System.out.println("=======连接到主机：" + serverName + " , 端口号：" + port + "========");
        //         Socket client = new Socket(serverName, port);
        //         System.out.println("客户端获取远程主机地址：" + client.getRemoteSocketAddress());
        //         //客户端输出流，用于写入服务器
        //         OutputStream outToServer = client.getOutputStream();
        //         DataOutputStream out = new DataOutputStream(outToServer);
        //         out.writeUTF(">>客户端请求：Hello from " + client.getLocalSocketAddress());
        //         //客户端输入流，来自服务器
        //         InputStream inFromServer = client.getInputStream();
        //         DataInputStream in = new DataInputStream(inFromServer);
        //         System.out.println(in.readUTF());
        //         //out.writeUTF("【客户端请求：I will close " + client.getLocalSocketAddress() + "】");  //不能继续写？？
        //         //关闭socket
        //         //client.close();
        //         number--;
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }

        Scanner scanner = new Scanner(System.in); 

        try {
            //建立客户端socket
            System.out.println("=======连接到主机：" + serverName + " , 端口号：" + port + "========");
            Socket client = new Socket(serverName, port);
            System.out.println("客户端获取远程主机地址：" + client.getRemoteSocketAddress());
            //客户端输出流，用于写入服务器
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            String inputStr = "";
            while(! inputStr.equals("end")) {
                inputStr = scanner.nextLine();
                out.writeUTF(">>客户端请求：" + inputStr);
            }
            //客户端输入流，来自服务器
            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println(in.readUTF());
            //out.writeUTF("【客户端请求：I will close " + client.getLocalSocketAddress() + "】");  //不能继续写？？
            //关闭socket
            //client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
