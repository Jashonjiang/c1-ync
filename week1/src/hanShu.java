import java.util.Scanner;

/*
 * 3. 编写一个函数，其作用是将输入的字符串反转过来
 */

public class hanShu
{
    public static String stReverse( String s)
    {
        String sReverse = "";
        for (int i = 0; i < s.length(); i++)
        {

            sReverse = s.substring(i, i+1) + sReverse;
        }
        return sReverse;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("输入：");
        String str = in.next();
        String strReverse = stReverse(str);
        System.out.println("输出：" + strReverse);
    }
}
