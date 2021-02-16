import java.util.*;

/*
 * 3. 现获取到用户输入的一段字符串（可从键盘录入），例如：aaaabbbcccccdd。
 * 请编写程序 获取其中无重复的字符组成一个新的字符串，即：abcd。请不要改变字符的输入顺序。
 * 提示：可以利用 set 集合的去重
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一段字符串：");
        String s = in.next();

        // 用Set自动去重，LinkedHashSet不会自动排序
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(String.valueOf(s.charAt(i)));
        }

        // 打印
        System.out.print("输出：");
        for (String i : set) {
            System.out.print(i);
        }
    }
}