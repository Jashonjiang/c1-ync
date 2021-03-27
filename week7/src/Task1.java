import java.util.*;

/**
 * 1.给你两个没有重复元素的数组 nums1和 nums2 ，其中nums1 是 nums2 的子集。
 * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
 */
public class Task1 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{5,9,8,3};
        int[] nums2 = new int[]{1,7,6,5,3,15,4,9,0,8,2};
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums2){
            if(stack.empty()){
                stack.push(n);
            }
            else{
                while(!stack.empty() && stack.peek() < n){
                    map.put(stack.peek(), n);
                    stack.pop();
                }
                stack.push(n);
            }
        }

        System.out.println(map);
        int[] reslut = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                reslut[i] = map.get(nums1[i]);
            }else {
                reslut[i] = -1;
            }
        }

        System.out.println(Arrays.toString(reslut));
    }
}
