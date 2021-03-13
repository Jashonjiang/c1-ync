/**
 * 1.整数反转
 * 给你一个 32 位的有符号整数 x ，返回 x 中每位上的数字反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^31 − 1] ，就返回 0。
 */
public class Task1 {
    public static void main(String[] args) {
        int x = 123;
        String s = "" + x;
        char[] chs = s.toCharArray();
        //反转
        String s1 = "";
        for (char ch : chs){
            if (ch != '-'){
                s1 = ch + s1;
            }
        }
        //反转后
        int y = 0;
        if (chs[0] == '-'){
            y = -1 * Integer.parseInt(s1);
        }
        else {
            y = Integer.parseInt(s1);
        }
        //范围 [−2^31,  2^31 − 1]
        if(y >= Math.pow(-2,31) && y <= Math.pow(2,31)-1){
            System.out.print(y);
        }else {
            System.out.print(0);
        }

    }
}
