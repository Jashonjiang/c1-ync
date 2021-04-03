import java.util.Scanner;

/**
 * 1.二进制转字符串
 * 给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
 * 如果该 数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 */

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x = in.nextDouble();
        String s = "0.";
        while(s.length() <= 33){ // 小数点不算在32位中
            if(x == 0) break;
            s += (int) (x*2);
            if(x*2 >= 1){
                x = x*2 - 1;
            }else {
                x = x*2;
            }
        }
        if(s.length() <= 33){
            System.out.println(s);
        }else //大于33说明无法用32位精确表示
        {
            System.out.println("ERROR");
        }
    }
}
