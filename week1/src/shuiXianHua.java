import java.util.Scanner;

public class shuiXianHua
{
    public static void main(String[] args)
    {
        int g, s, b, count;
        count = 0;
        System.out.print("1000以内水仙花数有：");
        for (int i = 100; i < 1000; i++)
        {
            g = i%10; // 个位
            s = i%100 / 10; // 十位
            b = i / 100; // 百位

            if (i == g*g*g + s*s*s + b*b*b)
            {
                count++;
                System.out.print(i + ",");
            }
        }
        System.out.println("\n1000以内水仙花数个数：" + count);
    }
}
