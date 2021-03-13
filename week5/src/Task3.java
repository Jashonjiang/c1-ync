import java.util.ArrayList;
import java.util.List;

/**
 * 3.求子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集
 * 注意：解集不能包含重复的子集。你可以按任意顺序返回解集。
 */
public class Task3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        List<List<Integer>> q = enumerate(nums);
        System.out.println(q);
    }

    public static List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }
}