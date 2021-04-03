import java.util.Scanner;

/**
 * 2.验证回文字符串
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        boolean flag = false;
        //直接判断该字符串是否是回文字符串
        if(fun(s)){
            flag = true;
        }
        //判断删除一个字符的情况下是否是回文字符串
        int i = 0;
        String temp = "";
        while (i < s.length() && flag != true){
            if(i == 0){
                temp = s.substring(i+1);
            }else if(i == s.length()-1){
                temp = s.substring(0,i);
            }else{
                temp = s.substring(0,i) + s.substring(i+1);
            }
            if(fun(temp)){
                flag = true;
            }
            i++;
        }
        System.out.println(flag);
    }

    //判断一个字符串是否为回文字符串
    public static boolean fun(String s){
        boolean flag = true;
        for(int i = 0; i < s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i)){
                flag = false;
            }
        }
        return flag;
    }
}
