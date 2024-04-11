import java.util.Scanner;
import java.util.Random;

public class JavaPrimer1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int indexRandom = random.nextInt(10);

        int[] sum = {0};
        int month;
        System.out.println("请输入您购买时机票原价");
        int cost = scanner.nextInt();
        System.out.println("请输入您购买时的月份");
        while(true){
            month = scanner.nextInt();
            if (month > 12 || month <= 0)
                System.out.println("请输入正确的月份");
            else {
                break;
            }
        }
        System.out.println("请问您购买的是头等舱还是经济舱");
        System.out.println("1----头等舱");
        System.out.println("2----经济舱");
        while(true){
            int paysize = scanner.nextInt();
            if (paysize == 1 || paysize == 2) {
                System.out.println("已经调查完毕，正在计算您的价格");
                judgement(cost, month, paysize, sum);
                break;
            } else {
                System.out.println("请输入正确的数字");
            }
        }
        System.out.println("计算完成");
        System.out.println("您购买本次机票花费为：" + sum[0]);
    }

    public static void judgement(int cost, int month, int paysize, int[] sum){
        if (paysize == 1) {
            //头等舱
            calculation(cost, month, sum, 10, 9, 7);
        }

        if (paysize == 2) {
            //经济舱
            calculation(cost, month, sum, 100, 85, 65);
        }
    }

    public static void calculation(int cost, int month, int[] sum, int i1, int i2, int i3) {
        if (month <= 10 && month >= 5) {
            sum[0] = (cost / i1) * i2;
        } else {
            sum[0] = cost * i3 / i1;
        }
    }
}
