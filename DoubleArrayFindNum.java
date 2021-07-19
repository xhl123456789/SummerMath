package SummerMath;

import java.util.Arrays;

public class DoubleArrayFindNum {
//一个有序的二维数组，在数组中查找有无该值
    //注意：不能从原点或者原点的对角点开始走，因为从这两个开始走的话都是往大的或者往小的走不知道往那个方向走的
    //要从两外两个点开始走，一个方向是往小一个是往大的走
    public static int[] findValue(int[][] arr,int vlaue){
        int row = arr.length -1;
        int col = 0;
        int[] res = {-1,-1};
        while(row > -1 && col < arr[0].length){
            if(arr[row][col] == vlaue){
                res[0] = row;
                res[1] = col;
                return res;
            }else if(arr[row][col] > vlaue){
                row--;
            }else {
                col++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int K = 233;
        System.out.println(Arrays.toString(findValue(matrix, K)));
    }
}
