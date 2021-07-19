package SummerMath;

public class WaiPai {
    /**
     * 打印数组B中所有不在A数组中的数
     * （1）拿B中的数值在A中逐一比较
     * (2)拿B中的数在A中进行二分查找
     * (3) 将B排序，然后再用类似外排的方式
     */
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {4,2,5};
        printNonOfA(arr1,arr2);
    }
    //方法一
    public static void printNonOfA(int[] A,int[] B){
        boolean temp = true;
        for(int i = 0; i < B.length;i++){
            for(int j=0;j<A.length;j++){
                if(A[i] == B[j]){
                    temp = false;
                    break;
                }
            }
            if(temp){
                System.out.println(B[i]);
            }
            temp = true;
        }
    }

}
