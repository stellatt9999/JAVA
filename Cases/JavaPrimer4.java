public class JavaPrimer4 {
    public static void main(String[] args) {
        //把一个数组的元素复制到另一个数组去
        int[] oldArr = {1, 2, 3, 4, 5};     //int oldArr[] 也可以
        int[] newArr = new int[oldArr.length];
        for (int i = 0; i < oldArr.length; i++) {
            newArr[i] = oldArr[i];
        }
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
        System.out.println("");
    }
}