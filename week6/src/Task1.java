import java.util.Arrays;

/**
 * ①给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 */
public class Task1 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}};
//        int[][] matrix = new int[][]{
//                {1,2, 3, 4},
//                {5,6, 7, 8},
//                {9,10,11,12}};


        int m = matrix.length; //行数
        int n = matrix[0].length; //列数
        int min = m < n ? m : n;
        int[] nums = new int[m*n];
        int k = 0;
        int i = 0; //行标初始化在第一行
        int j = 0; //列标初始化在第一列
        int a = 1;
        int q = 2 * min - 1;
        while (a <= q){
            if (a%4 == 1){ //从左至右
                for(int x = 0; x < n; x++){
                    nums[k] = matrix[i][j];
                    k++;
                    j++; //列标加一，最后一次执行完会超出范围
                }
                j--; //将超出返回的列标减一回到正确位置
                i++; //行标加一
                m--; //把遍历过的数据去除
            }
            if (a%4 == 2) { //从上到下
                for(int x = 0; x < m; x++){
                    nums[k] = matrix[i][j];
                    k++;
                    i++;
                }
                i--;
                j--;
                n--;
            }
            if (a%4 == 3) { //从右至左
                for(int x = 0; x < n; x++){
                    nums[k] = matrix[i][j];
                    k++;
                    j--;
                }
                j++;
                i--;
                m--;
            }
            if (a%4 == 0) {//从下到上
                for(int x = 0; x < m; x++){
                    nums[k] = matrix[i][j];
                    k++;
                    i--;
                }
                i++;
                j++;
                n--;
            }
            a++;
        }

        System.out.println(Arrays.toString(nums));
    }
}
