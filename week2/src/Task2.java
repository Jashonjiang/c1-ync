import java.util.Arrays;
import java.util.Scanner;

/*
 * 2. 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符 串 ""。
 */

public class Task2
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入字符串数组（以逗号为分隔符）：");
        String s = in.next().toString();
        String[] str = s.split(",");

        System.out.println("输出：\"" + commonPrefix(str) + "\"");
        if(commonPrefix(str).equals(""))
            System.out.println("解释：输入不存在公共前缀");
    }

    public static String commonPrefix(String[] s)
    {
        int minLenth = s[0].length();
        for(int i = 1; i < s.length; i++)
        {
            if (s[i].length() < minLenth)
            {
                minLenth = s[i].length();
            }
        }

        String cPrefix = "";
        boolean flag = true;
        int j = 0;

        while (flag && j<minLenth)
        {
            j++;
            for(int i = 0; i < s.length - 1; i++)
            {
                if (!((s[i].substring(0,j)).equals(s[i+1].substring(0,j))))
                {
                    flag = false;
                }
            }
        }

        if (j < minLenth || minLenth == 1)
        {
            return cPrefix + s[0].substring(0,j-1);
        }
        else
        {
            return cPrefix + s[0].substring(0,j);
        }
    }
}
