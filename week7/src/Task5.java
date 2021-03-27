import java.util.Arrays;

/**
 * 5. 给定一个二进制数组，计算其中最大连续 1 的个数
 */
public class Task5 {
    public static void main(String[] args) {
        boolean flag = false;
        int[] nums = new int[]{1,1,0,0,1,1,1,1};
        for(int i = nums.length; i > 0; i--){
            for(int j = 0; j <= nums.length - i; j++){
                flag = A(Arrays.copyOfRange(nums, j, j+i));
                if(flag){
                    System.out.println(i);
                    return;
                }
            }
        }
    }
    //判断一个数组是否元素全为1，是返回true
    public static boolean A(int[] nums){
        boolean flag = true;
        for(int n : nums){
            if(n != 1) flag = false;
        }
        return flag;
    }
}
