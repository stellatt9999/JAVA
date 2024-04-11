public class ThreadTest implements Runnable {
    private static int static_i; //静态变量: 线程非安全                       --自：静态成员变量
    private int instance_i;      //实例变量：单实例线程非安全，非单实例线程安全  --自：普通成员变量

    public void run() {
        // static_i = 4;
        // System.out.println("[" + Thread.currentThread().getName() + "] 获取static_i的值：" + static_i);  //自：多线程可能会输出 4 10
        // static_i = 10;
        // System.out.println("[" + Thread.currentThread().getName() + "] 获取static_i * 2 的值：" + static_i * 2); //自：多线程可能会输出 20 8

        instance_i = 4;
        System.out.println("[" + Thread.currentThread().getName() + "] 获取instance_i的值：" + instance_i);         //自：单实例同静态变量，多实例同局部变量
        instance_i = 10;
        System.out.println("[" + Thread.currentThread().getName() + "] 获取instance_i * 2 的值：" + instance_i * 2);   //自：单实例同静态变量，多实例同局部变量

        // int local_i = 4;        //局部变量：线程安全
        // System.out.println("[" + Thread.currentThread().getName() + "] 获取local_i的值：" + local_i);      //自：多线程只会输出 4
        // local_i = 10;
        // System.out.println("[" + Thread.currentThread().getName() + "] 获取local_i * 2 的值：" + local_i * 2);  //自：多线程只会输出 20

    }

    public static void main(String[] args) {
        //启动尽量多的线程才能很容易模拟问题
        ThreadTest t = new ThreadTest();  //单实例-step1
        for (int i = 0; i < 3000; i ++) {
            //t可以换成new Test, 保证每个线程都在不同的对象中执行，
            new Thread(t, "线程" + i).start();  //单实例-step2
            //new Thread(new ThreadTest(), "线程" + i).start();  //多实例

            //静态变量结果一样：都非安全
            //实例变量结果不一样：单实例非安全，多实例安全
            //局部变量结果一样，都安全
        }
    }
}