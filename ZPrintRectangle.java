package SummerMath;

public class ZPrintRectangle {
    //只字形打印矩阵，这个题不要去想下标的变化，
    //而是去考虑两个点走对角线,然后打印这条线
    //一个坐标对应两个点
    public static void printZRec(int[][] arr){
        int s_hang = 0;
        int s_lie = 0;
        int e_hang = 0;
        int e_lie = 0;
        int r_hang = arr.length - 1;
        int r_lie = arr[0].length-1;
        boolean flag = true;
        while(s_hang != r_hang+1){
            //谁先不动谁就在前面
            printLevel(arr,s_hang,s_lie,e_hang,e_lie,flag);
            s_hang = s_lie == r_lie ? s_hang+1 : s_hang;
            s_lie = s_lie == r_lie ? s_lie : s_lie+1;
            e_lie = e_hang == r_hang ? e_lie+1 : e_lie; //位置不能反
            e_hang = e_hang == r_hang ? e_hang: e_hang+1;
            flag = !flag;
        }
    }
    public  static void printLevel(int[][] arr,int s_hang,int s_lie, int e_hang,int e_lie,boolean flag){
        if(flag){
            while(s_lie >= e_lie){
                System.out.println(arr[s_hang][s_lie]+" ");
                s_hang++;
                s_lie--;
            }
        }else {
            while(e_lie <= s_lie){
                System.out.println(arr[e_hang][e_lie]+" ");
                e_hang--;
                e_lie++;
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printZRec(matrix);

    }

}
