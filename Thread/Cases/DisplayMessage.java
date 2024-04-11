public class DisplayMessage implements Runnable {
    //Java 提供了三种创建线程的方法：
    //  通过实现 Runnable 接口；   --- 当前方式
    //  通过继承 Thread 类本身；
    //  通过 Callable 和 Future 创建线程。

    private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    public void run() {
        while(true) {
            System.out.println(message);
        }
    }
}