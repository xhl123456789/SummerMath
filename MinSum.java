package SummerMath;

public class MinSum {
    /**
     * 求最小和：
     * 给定一个数组【1，3，4，2，5】
     * 比1小的：无
     * 比3小的：1
     * 比四小的：1，3
     * 比2小的：1
     * 比5小的：1，3，4，2
     * 最小和：1+1+3+1+1+3+4+2
     */
    //第一种办法：比较笨但是容易想到的办法
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(sumMin1(arr));
    }
    public static int sumMin1(int[] arr){
        int res = 0;
        for(int i = arr.length - 1; i > 0;i--){
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i]){
                    res += arr[j];
                }
            }
        }
        return res;
    }
    //第二种办法 利用堆结构
}
