class ThreadDemo extends Thread {
    //Java 提供了三种创建线程的方法：
    //  通过实现 Runnable 接口；   
    //  通过继承 Thread 类本身； --- 当前方式
    //  通过 Callable 和 Future 创建线程。
    
    private Thread t;
    private String threadName;

    ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i --) {
                System.out.println("Thread: " + threadName + "- " + i);
                //让线程睡眠一会儿
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

public class ThreadDemoTest {
    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo("ThreadA");
        T1.start();  
        //T1.run();  //自：这里 T1.run(); 没有开启线程，没有new Thread()

        ThreadDemo T2 = new ThreadDemo("ThreadB");
        T2.start();
        //T2.run();
    }
}
