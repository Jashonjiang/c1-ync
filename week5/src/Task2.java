/**
 * 2.爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */

public class Task2 {
    public static void main(String[] args) {
        int n = 3;
        int sum = 0;
        for (int i = 0; i <= (n+1)/2; i++){
            sum += C(n-i,i) / D(i);
        }

        System.out.print(sum);
    }

    //计算a*(a-1)*(a-2)*...*(a-k)
    public static int C(int a, int b){
        int result = 1;
        while(b > 0){
            result = result * a;
            a--;
            b--;
        }
        return result;
    }

    //计算阶乘k！
    public static int D(int k){
        if (k == 0 || k == 1) return 1;
        else return k * D(k-1);
    }
}
