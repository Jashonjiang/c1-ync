import java.util.*;

/**
 * 2.给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String s = in.nextLine();

        System.out.print("第一个不重复的字符的位置：" + weiZhi(s));
    }

    public static int weiZhi(String s){
        char[] str = s.toCharArray();
        ArrayList<Integer> nums = new ArrayList();
        for (char i : str){
            int k = 0;
            for (char j : str){
                if (i == j){
                    k++;
                }
            }
            nums.add(k);
        }

        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i) == 1) return i;
        }
        return -1;
    }
}
