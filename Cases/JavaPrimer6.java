import java.util.Scanner;

public class JavaPrimer6 {
    //某系统的数字密码（大于0），比如1983采用加密方式传输
    //规则：先得到每位数，然后每位数加上5，再对10求余，最后将所有数字反转，得到一串新的数字
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("请输入你的密码：");
        int password = scanner.nextInt();
        while (true) {
            if (password < 0) {
                System.out.println("不允许输入负数，请重新输入");
                password = scanner.nextInt();
            } else {
                break;
            }
        }

        //password的位数
        int count = getCount(password, 1);
        while (true) {
            if (count < 5) {
                System.out.println("密码不能少于五位");
                password = scanner.nextInt();
                count = getCount(password, 1);
            } else {
                break;
            }
        }

        System.out.println("正在进行加密");

        //得到每位数
        int[] everyDigit = getEveryDigit(password, count);
        //加密计算
        for (int i = 0; i < everyDigit.length; i++) {
            //给每位数加5
            everyDigit[i] = everyDigit[i] + 5;
            everyDigit[i] = everyDigit[i] % 10;
        }
        //颠倒加密
        for (int i = 0, j = everyDigit.length - 1; i < j; i++, j--) {
            if (everyDigit[i] != everyDigit[everyDigit.length - i - 1]) {
                int temp = everyDigit[i];
                everyDigit[i] = everyDigit[everyDigit.length - i - 1];
                everyDigit[everyDigit.length - i - 1] = temp;
            }
        }
        for (int i = 0; i < everyDigit.length ; i++) {
            System.out.print(everyDigit[i] + " ");
        }
        System.out.println("");

        //自
        // int[] newEveryDigit;
        // for(int i = everyDigit.length - 1, j = 0; i >= 0 ; i--, j++) {
        //     newEveryDigit[j] = everyDigit[i];
        // }

        // for (int i = 0; i < newEveryDigit.length ; i++) {
        //     System.out.print(newEveryDigit[i] + " ");
        // }
    }

    private static int[] getEveryDigit(int password, int count) {
        int arr[] = new int[count];
        //计数器
        while (count != 0) {
            int digit = password % 10;
            password = password / 10;
            arr[count - 1] = digit;
            count --;
        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + "");
        }
        System.out.println("");
        return arr;
    }

    private static int getCount(int password, int count) {
        for (int i = 0; ; i++) {
            if (password > 10) {
                password = password / 10;
                count ++;
            } else {
                break;
            }
        }
        return count;
    }
}