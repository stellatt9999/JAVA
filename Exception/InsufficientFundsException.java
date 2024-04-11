package Exception;

import java.io.*;

//自定义异常类，继承Exception
public class InsufficientFundsException extends Exception {
    //amount 储存当出现异常（取出钱多于余额时）所缺的钱
    private double amount;

    public InsufficientFundsException(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}