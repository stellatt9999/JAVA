public class GuessANumber extends Thread {
    //Java 提供了三种创建线程的方法：
    //  通过实现 Runnable 接口；   
    //  通过继承 Thread 类本身；  --- 当前方式
    //  通过 Callable 和 Future 创建线程。

    private int number;

    public GuessANumber(int number) {
        this.number = number;
    }

    public void run() {
        int counter = 0;
        int guess = 0;
        do {
            guess = (int)(Math.random() * 100 + 1);
            System.out.println(this.getName() + " guesses " + guess);
            counter ++;
        } while (guess != number);
        System.out.println("** Correct! " + this.getName() + " in " + counter + " guesses.**");
    }
}    
