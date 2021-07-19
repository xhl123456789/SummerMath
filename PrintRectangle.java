package SummerMath;

public class PrintRectangle {
    //顺时针打印矩阵
    //主要就是运用两个对角坐标
    public static void printRectangle(int[][] arr,int hang,int lie){
        int s_hang = 0;  //起始坐标的行
        int s_lie = 0; //其实坐标的列
        int r_hang = hang - 1; //对角坐标的行
        int r_lie = lie - 1; // 对角坐标的列
        while(s_hang <= r_hang && s_lie <= r_lie){
            printEdge(arr,s_hang++,s_lie++,r_hang--,r_lie--);
        }
    }

    public static void printEdge(int[][] arr,int s_hang,int s_lie,int r_hang, int r_lie){
        if(s_hang == r_hang){  //行相等，说明只需要打印最后一行了
            for(int i = s_lie; i <= r_lie; i++){
                System.out.println(arr[s_hang][i]+" ");
            }
        }else if(s_lie == r_lie){ //列相等 ，说明只要打印最后一列了
            for(int i = s_hang;i<=r_hang;i++){
                System.out.println(arr[i++][s_lie]);
            }
        }else{
            int curRow = s_lie;
            int curCrown = s_hang;
            while(curRow < r_lie){
                System.out.println(arr[s_hang][curRow++]+" ");
            }
            while(curCrown < r_hang){
                System.out.println(arr[curCrown++][curRow]+" ");
            }
            while(curRow > s_lie){
                System.out.println(arr[curCrown][curRow--]+" ");
            }
            while(curCrown > s_hang){
                System.out.println(arr[curCrown--][curRow]+" ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{ 4,5,6},{7,8,9}};
        printRectangle(arr,3,3);
    }
}
