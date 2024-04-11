import java.io.*;  //BufferedReader
import java.util.*; //Scanner
import java.io.File; //File

public class ExceptionTest {
    public static void checkNumber(int num) throws IllegalArgumentException {
        if (num < 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
    }
    
    public static void main(String[] args) {
        // try {
        //     int numberArr[] = new int[4];
        //     System.out.println("Access elment three : " + numberArr[9]);
        // } catch (java.lang.Throwable e1) {  //可用Throwable  可用RuntimeException  可用java.lang.Exception但不能直接用Exception？ 
        //     System.out.println("Throwable thrown :" + e1);
        // } 
        // // catch (java.lang.RuntimeException e2) {   //这种多重catch不行，会报错误
        // //     System.out.println("RuntimeException thrown :" + e2);
        // // } catch (java.lang.ArrayIndexOutOfBoundsException e3) {
        // //     System.out.println("ArrayIndexOutOfBoundsException thrown :" + e3);
        // // } 
        // System.out.println("Out of the block");

        // try {
        //     String fileName = "aaa.text";
        //     InputStream file = new FileInputStream(fileName);
        //     byte x = (byte) file.read();
        // } catch (FileNotFoundException f) {  //Not valid!
        //     f.printStackTrace();
        //     //return -1;  //错误: 不兼容的类型: 意外的返回值
        // } catch (IOException i) {
        //     i.printStackTrace();
        //     //return -1;
        // } finally {
        //     int a = 6;
        //     System.out.println("a = " + a);
        // }

        //checkNumber(-1);

        //使用自定义异常类
        CheckingAccount c = new CheckingAccount(101);
        System.out.println("Depositing $500......");
        c.deposit(500.00);
        try {
            System.out.println("\nWithdrawing $100......");
            c.withdraw(100.00);
            System.out.println("\nWithdrawing $600......");
            c.withdraw(600.00);
        } catch (InsufficientFundsException e) {
            System.out.println("Sorry, but you are short $" + e.getAmount());

            e.printStackTrace();
        }
    }



}