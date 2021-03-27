import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4. 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Task4 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= nums.length - k; i++){
            list.add(max(Arrays.copyOfRange(nums, i, i+k)));
        }
        System.out.println(list);
    }

    public static int max(int[] nums){
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > max) max = nums[i];
        }
        return max;
    }
}
