import java.util.Arrays;
import java.util.Scanner;

/**
 * ①某商场周年庆举办了一次抽奖活动：
 * n 个人参与抽奖，每人抽到一个初始序号 a[i]，如果 a[i]是某个数的平方，那么这个人就能够获奖。
 * 现在商场为了吸引人流量，决定发放一些修改劵，修改劵的作用是：能使序号 a[i]加一或者减一。
 * 问：如果要使至少一半的人获奖，商场最少需要发放多少修 改劵
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入人数：");
        int n = in.nextInt();
        System.out.print("请输入每个人抽到的数：");
        int[] nums = new int[n];
        int[] counts = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
            for(int j = 0;; j++){
                if(is(nums[i]+j) || is(nums[i]-j)){
                    counts[i] = j;
                    break;
                }
            }
        }

        sort(counts);
        System.out.println(Arrays.toString(counts));
        int sum = 0;
        for(int i = 0; i < (n+1)/2; i++){
            sum += counts[i];
        }
        System.out.println(sum);
    }

    //判断一个数是否是一个数的平方
    public static boolean is(int x){
        if (x == 1) return true;
        for(int i = 0; i <= x/2; i++){
            if(x == i*i) return true;
        }
        return false;
    }

    public static void sort(int[] nums){
        int temp;
        for(int i = nums.length-1; i > 1; i--){
            for(int j = 0; j < i; j++){
                if(nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
