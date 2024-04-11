import java.io.*; //BufferedReader
import java.util.*;  //Scanner

public class HelloWorld {
    //javac HelloWorld.java   //编译生成字节码文件 HelloWorld.class
    //java HelloWorld         //执行字节码文件 HelloWorld.class
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World");

        String hello = "hello";
        String hello1 = new String("hello1");
        System.out.println(hello);
        System.out.println(hello1);

        hello = "world"  + "999";
        hello1 = "world1" + "999";
        System.out.println(hello);
        System.out.println(hello1);

        //Scanner实现控制台输入
        Scanner scanner = new Scanner(System.in); //本客户端输入
        int count = 2;
        //while (true) {
        while (count > 0) {
            String message = scanner.nextLine();
            System.out.println(message); //服务端输出
            count --;
        }



        //BufferedReader实现控制台输入
        //从控制台读取多字符输入
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');


        //从控制台读取字符串--BufferedReader
        BufferedReader brStr = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
            str = brStr.readLine();
            System.out.println(str);
        } while (!str.equals("end"));

        //从控制台读取字符串--Scanner
        System.out.println("Enter lines of text using scanner.");
        System.out.println("Enter 'end' to quit");
        Scanner scannerS = new Scanner(System.in);
        String strS = "";
        while (! strS.equals("end")) {
            strS = scannerS.nextLine();
            System.out.println(strS);
        }


    }

}