import java.util.Scanner;

public class BMI
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("输入体重(kg)：");
        float m = in.nextFloat();

        System.out.print("输入身高(m)：");
        float h = in.nextFloat();

        float BMI;
        BMI = m / (h*h);
        System.out.printf("BMI=%.1f\n", BMI);

        if (BMI < 18.5)
        {
            System.out.println("过轻");
        }

        else if (BMI < 25)
        {
            System.out.println("正常");
        }

        else if (BMI < 28)
        {
            System.out.println("过重");
        }

        else if (BMI < 32)
        {
            System.out.println("肥胖");
        }

        else
        {
            System.out.println("非常肥胖");
        }
    }
}
