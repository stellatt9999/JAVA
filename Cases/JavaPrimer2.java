public class JavaPrimer2 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 2;       
        for (; i < 100; i++) {
            int j = 2;
            for (; j <= i / j ; j++) {
                if (i % j == 0) {
                    break;
                }
            }

            if (j > (i / j)) {
                System.out.println(i + "是一个素数");
                sum ++;
            }
        }
        System.out.println("一共有 " + sum + " 个素数");
    }
}