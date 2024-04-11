import java.io.*;

public class SerializeDemo {
    public static void main(String [] args) {
        People p = new People();
        p.name = "Reyan Ali";
        p.address = "Phokka Kuan, Ambehta Peer";
        p.SSN = 11122333;
        p.number = 101;

        try {
            FileOutputStream fileOut = new FileOutputStream("/data/home/stellattshi/JAVA/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(p);//序列化people对象
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /data/home/stellattshi/JAVA/tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}