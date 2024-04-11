import java.io.*;

public class DeserializeDemo {
    public static void main(String [] args) {
        People p = null;
        try {
            FileInputStream fileIn = new FileInputStream("/data/home/stellattshi/JAVA/tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (People)in.readObject(); //反序列化people对象
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("People class not found");
            c.printStackTrace();
            return;
        }

        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + p.name);
        System.out.println("Address: " + p.address);
        System.out.println("SSN: " + p.SSN);
        System.out.println("Number: " + p.number);
    }
}