import java.util.Random;
import java.util.Scanner;

public class JavaPrimer8 {
    //模拟双色球
    //投注号码由6个红球号码和1个蓝球号码组成
    //红球号码从1-33中选择，蓝球号码从1-16中选择
    public static void main(String[] args) {
        //随机生成中奖号码
        int[] arr = createNumber();

        System.out.println("---------------");
        for (int i = 0; i < arr.length; i ++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        System.out.println("---------------");

        int[] inputArr = userinputArr();
        for (int i = 0; i < inputArr.length; i ++) {
            System.out.print(inputArr[i] + " ");
        }
        System.out.println("");

        //判断有没有中奖
        int redcount = 0;
        int bluecount = 0;

        //判断红球中奖情况：不考虑位置，只要有就行
        for (int i = 0; i < inputArr.length - 1; i ++) {
            int rednumber = inputArr[i];
            for (int j = 0; j < arr.length - 1; j ++) {
                if (rednumber == arr[j]) {
                    redcount ++;
                    //如果找到了后面数字就没有必要了
                    break;
                }
            }
        }

        //判断蓝球中奖情况
        int bluenumber = inputArr[inputArr.length - 1];
        if (bluenumber == arr[arr.length - 1])
            bluecount ++;

        System.out.println("红球中奖个数为：" + redcount);
        System.out.println("蓝球中奖个数为：" + bluecount);

        if (redcount == 6 && bluecount == 1) 
            System.out.println("恭喜你，中奖1000w");
        else if (redcount == 6 && bluecount == 0)
            System.out.println("恭喜你，中奖500w");
        else if (redcount == 5 && bluecount == 1)
            System.out.println("恭喜你，中奖3000");
        else if ((redcount == 5 && bluecount == 0) || (redcount == 4 && bluecount == 1)) 
            System.out.println("恭喜你，中奖200");
        else if ((redcount == 4 && bluecount == 0) || (redcount == 3 && bluecount == 1)) 
            System.out.println("恭喜你，中奖10");        
        else if ((redcount == 3 && bluecount == 0) || (redcount == 2 && bluecount == 1)) 
            System.out.println("恭喜你，中奖5");
        else 
            System.out.println("感谢参与");
        //main end
    }

    public static int[] createNumber() {
        //添加中奖号码：6个红球 1个蓝球
        int arr[] = new int[7];

        //随机添加号码，并添加到数组当中
        //红球不能重复，蓝球可以重复
        Random random = new Random();
        for (int i = 0; i < 6; ) {
            int rednumber = random.nextInt(33) + 1;
            boolean flag = judge(arr, rednumber);
            if (! flag) {
                arr[i] = rednumber;
                i ++; //不能放到for里面，不符合判断条件，则不+1
            }
        }

        //生成蓝球号码
        int bluenumber = random.nextInt(16) + 1;
        arr[arr.length - 1] = bluenumber;
        return arr;
    }


    //用户输入中奖号码
    public static int[] userinputArr() {
        Scanner scanner = new Scanner(System.in);
        int arr[] = new int[7];

        //用户输入红球号码
        for (int i = 0; i < 6; ) {
            System.out.println("请输入第" + (i + 1) + "个红球号码：");
            int rednumber = scanner.nextInt();
            //1-33 唯一不重复
            if (rednumber >= 1 && rednumber <= 33) {
                boolean flag = judge(arr, rednumber);
                if (! flag) {
                    arr[i] = rednumber;
                    i ++; //不能放到for里面，不符合判断条件，则不+1
                } else {
                    System.out.println("当前红球号码已经存在，请重新输入");
                }
            } else {
                System.out.println("当前红球号码超出范围");
            }
        }

        System.out.println("请输入你的蓝球号码");
        //用户输入蓝球号码
        while (true) {
            int bluenumber = scanner.nextInt();
            if (bluenumber >= 1 && bluenumber <= 16) {
                System.out.println("你的号码录取成功");
                arr[arr.length - 1] = bluenumber;
                break;
            } else {
                System.out.println("你的蓝球号码超出规格，请重新输入");
            }
        }

        return arr;
    }

    //判断数字在数组中是否存在
    public static boolean judge(int[] arr, int number) {
        for (int i = 0; i < arr.length; i ++) {
            if (arr[i] == number) {
                return true;
            }
        }

        return false;
    }

}