import java.util.Random;

public class JavaPrimer3 {
    public static void main(String[]  args) {
        //生成验证码格式：长度5，前四位是大小写字母，最后一位是数字
        char[] alphabetic = new char[52];
        System.out.println("ASCII码全部大小写字母如下：");
        for (int i = 0; i < alphabetic.length; i++) {
            //ASCII码表，小写字母a --97
            if (i <= 25) {
                alphabetic[i] = (char) (97 + i);
            }
            //大写字母A --65
            if (i > 25) {
                //i在26的时候添加大写字母
                alphabetic[i] = (char) (65 + i - 26);
            }

            System.out.print(alphabetic[i] + " ");
        }

        System.out.println("\n您的验证码为：");
        Random random = new Random();
        String result = verification(random, alphabetic);
        System.out.println(result);
    }

    private static String verification(Random random, char[] alphabetic) {
        //随机抽取数组中索引
        int digitRandom = random.nextInt(10);
        String result = "";
        for (int i = 0; i < 5; i++) {
            int alphaRandom = random.nextInt(52);
            if (i < 4) {
                result = result + alphabetic[alphaRandom];
            } else {
                result =  result + digitRandom;
            }
        }

        return result;
    }
}