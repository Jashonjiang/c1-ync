import java.util.Arrays;
import java.util.Scanner;

/*
 * 1. 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 */
public class Task1 {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入行数n：");
        int n = in.nextInt();

        int[][] matrix = new int[n][n];
        for (int i = 1; i <= n; i++)
        {
            System.out.printf("请输入第%d行元素（以逗号为分隔符）：", i);
            String s = in.next().toString();
            String[] q = s.split(",");
            for (int j = 0; j < n; j++)
            {
                matrix[i-1][j] = Integer.parseInt(q[j]);
            }
        }

        System.out.println();
        System.out.println("输入：matrix = " + Arrays.deepToString(matrix));

        int[][] newMatrix = spin(matrix);

        System.out.println("输入：newMatrix = " + Arrays.deepToString(newMatrix));
    }

    public static int[][] spin(int[][] matrix)
    {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                newMatrix[i][j] = matrix[n-1-j][i];
            }
        }
        return newMatrix;
    }
}
