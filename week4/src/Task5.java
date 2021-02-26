import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 5.数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没 有，返回-1。
 */
public class Task5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个数组（以逗号为分隔符）：");
        String str = in.nextLine();
        String[] s = str.split(",");

        //该元素出现次数为key，元素为value
        Map<Integer,String> map = new HashMap<>();
        for (int i = 0; i < s.length; i++){
            int k = 0;
            for (int j = 0; j < s.length; j++){
                if (s[i].equals(s[j])){
                    k++;
                }
            }
            map.put(k,s[i]);
        }

        int max = 0;
        for (int i : map.keySet()){
            if (i > max){
                max = i;
            }
        }
        if (max > s.length/2){
            System.out.println("输出：" + map.get(max));
        }
        else {
            System.out.println("输出：-1");
        }
    }
}
