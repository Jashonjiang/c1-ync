import java.util.Scanner;

/**
 * 1.字符串匹配
 * 输入一个原字符串（string）和子串（pattern），要求返回子串在原字符串中首次出现的位置。
 */

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String s1 = in.nextLine();
        System.out.print("请输入一个子串：");
        String s2 = in.nextLine();

        System.out.println("该子串在原字符串首次出现的位置：" + weiZhi(s1,s2));
    }

    public static int weiZhi(String s1, String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int d = 0;
        for (int i = 0; i <= str1.length - str2.length; i++){
            for (int j = 0; j < str2.length; j++){
                if (str2[j] == str1[i+j]){
                    d++;
                }
            }
            if(d == str2.length){
                return i;
            }
        }
        return -1;
    }
}
