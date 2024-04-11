public class People implements java.io.Serializable {  //可以序列化
    String name;
    String address;
    transient int SSN;
    int number;

    public void mailCheck(){
        System.out.println("Mailing a check to " + name + " " + address);
    }
}