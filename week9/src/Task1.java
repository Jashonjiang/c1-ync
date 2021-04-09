import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 1. 给定一个集合，里面有 1000 个整数，请找出重复次数最多的那 10 个数。
 */

public class Task1 {
    public static void main(String[] args) {
        int[] nums = new int[1000];
        Map<Integer, Integer> map = new HashMap<>();
        int[] max10 = new int[10]; //存放出现次数最多的10个数，对应map中的key
        Random rand = new Random();
        //初始化1000个1~100的随机数
        for(int i = 0; i < 1000; i++){
            nums[i] = rand.nextInt(100) + 1;
            map.put(nums[i], 0);
        }

        //判断这1000个数中是否出现10个以上的数
        if(map.size() < 10){
            System.out.println("这一千个数出现的数少于十个");
            System.exit(0);
        }

        //用hashmap记录每个值出现的次数
        int count = 0;
        for(Map.Entry<Integer, Integer> vo : map.entrySet()){
            count = 0;
            for(int n : nums){
                if(n == vo.getKey()){
                    count++;
                }
            }
            map.put(vo.getKey(), count);
        }

        //把max10用map中的10个key进行初始化
        int k = 0;
        for(int key : map.keySet()){
            max10[k] = key;
            k++;
            if(k > 9) break;
        }

        //对max10根据map中对应的value进行排序
        int temp;
        for(int i = 0; i < 9; i++){
            for(int j = i+1; j < 10; j++){
                if(map.get(max10[i]) > map.get(max10[j])){
                    temp = max10[i];
                    max10[i] = max10[j];
                    max10[j] = temp;
                }
            }
        }

        //对比map中的各个value更新max10中的值
        for(Map.Entry<Integer, Integer> vo : map.entrySet()){
            int i = 9;
            while(i >= 0 && map.get(max10[i]) < vo.getValue()) i--;
            i++;
            for(int j = 9; j > i; j--){
                max10[j] = max10[j-1];
            }
            if(i == 10) continue;
            max10[i] = vo.getKey();
        }

        //打印
        System.out.println("出现次数最多的10个数为：" + Arrays.toString(max10));
        System.out.println("它们出现的次数：");
        for(int n : max10){
            System.out.println(n + ": " + map.get(n) + " 次");
        }
    }
}
