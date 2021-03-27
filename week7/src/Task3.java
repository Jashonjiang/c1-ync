import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3. 给你一个整数数组nums 。数组中唯一元素是那些只出现恰好一次的元素。请你返回 nums中唯一元素的和。
 */
public class Task3 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,2,9,4,4,5};
        int count = 0;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>(); //键为数组中的值，值为次数；
        for (int e : nums){
            count = 0;
            for(int m :nums){
                if (e == m){
                    count++;
                }
            }
            map.put(e, count);
        }

        for(int key : map.keySet()){
            if(map.get(key) == 1){
                sum += key;
            }
        }

        System.out.println(sum);
    }
}
