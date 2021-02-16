import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * 4.wordCount（用 hashMap 实现） 输入一串由英文单词组成的字符串，现在需要统计出每个英文字母出现的频数。
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个英文字符串：");
        String s = in.next();

        // 把字符串中不重复的字符穿在set里
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
        {
            set.add(String.valueOf(s.charAt(i)));
        }

        // 用HashMap键值对记录每个字符出现的次数
        HashMap<String, Integer> hashMap = new HashMap();
        for(String i : set)
        {
            int n = 0;
            for(int j = 0; j < s.length(); j++)
            {
                if(i.equals(String.valueOf(s.charAt(j))))
                {
                    n++;
                }
            }
            hashMap.put(i, n);
        }

        // 打印HashMap
        for(String i : hashMap.keySet())
        {
            System.out.println(i + ": " + hashMap.get(i));
        }
    }
}
