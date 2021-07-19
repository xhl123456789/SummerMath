package SummerMath;

public class RevolveSquare {
    //一个正方形矩阵，顺时针旋转九十度
    //一层一层转,
    public static void revovleSquare(int[][] arr) {
        int s_hang = 0;
        int s_lie = 0;
        int r_hang = arr.length - 1;
        int r_lie = arr[0].length - 1;
        while (s_hang < r_hang) {
            Revovle(arr, s_hang++, s_lie++, r_hang--, r_lie--);
        }
    }

    public static void Revovle(int[][] arr, int s_hang, int s_lie, int r_hang, int r_lie) {
        int temp = 0;
        int times = r_hang - s_hang;
        for (int i = 0; i != times; i++) {
            temp = arr[s_hang + i][s_lie];
            arr[s_hang + i][s_lie] = arr[r_hang][s_lie + i];
            arr[r_hang][s_lie + i] = arr[r_hang - i][r_lie];
            arr[r_hang - i][r_lie] = arr[s_hang][r_lie - i];
            arr[s_hang][r_lie - i] = temp;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        printMatrix(matrix);
        revovleSquare(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
