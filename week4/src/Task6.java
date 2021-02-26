import java.util.ArrayList;
import java.util.Scanner;

/**
 * 6.给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
 */
public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String s = in.nextLine();
        char[] str = s.toCharArray();
        boolean flag = true;
        ArrayList<Character> strs = new ArrayList<Character>(); //以此为栈, length-1即为栈顶
        for (char ch : str){
            if(ch == '(' || ch == '{' || ch == '['){
                strs.add(ch);
            }
            if(ch == ')'){
                if(strs.size() != 0 && strs.get(strs.size()-1) == '('){
                    strs.remove(strs.size()-1);
                }
                else {
                    flag = false;
                }
            }
            if(ch == ']'){
                if(strs.size() != 0 && strs.get(strs.size()-1) == '['){
                    strs.remove(strs.size()-1);
                }
                else {
                    flag = false;
                }
            }
            if(ch == '}'){
                if(strs.size() != 0 && strs.get(strs.size()-1) == '{'){
                    strs.remove(strs.size()-1);
                }
                else {
                    flag = false;
                }
            }
        }
        if(strs.size() != 0){
            flag = false;
        }

        System.out.println("输出：" + flag);
    }
}
