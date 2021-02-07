import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 3.找出字符串中的数字
 */
public class Task3
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("输入：");
        String str = in.next().toString();

        ArrayList nums = new ArrayList();
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57)
            {
                int j = i;
                while (j < str.length() && str.charAt(j) >= 48 && str.charAt(j) <= 57)
                {
                    j++;
                }
                if (j < str.length())
                {
                    nums.add(Integer.valueOf(str.substring(i, j)));
                }
                else
                {
                    nums.add(Integer.valueOf(str.substring(i)));
                }
                i = j;
            }
        }

        System.out.println("输出：" + nums.toString());

    }
}
