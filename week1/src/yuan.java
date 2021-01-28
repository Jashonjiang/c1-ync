import java.util.Scanner;

/*
 * 5. 定义一个 Circle 类，其中成员变量 radius 表示圆的半径，
 * 编写方法 getArea() 计 算圆的面积、getPerimeter()计算圆的周长，并在主函数中构造一个 Circle 的对象进行测试。
 */

public class yuan
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入圆的半径：");
        double r = in.nextDouble();

        Circle c = new Circle(r);
        System.out.printf("圆的面积：%.2f\n圆的周长：%.2f", c.getArea(), c.getPerimeter());
    }
}

class Circle
{
    private double R;

    public Circle(double r)
    {
        R = r;
    }

    public double getArea()
    {
        return Math.PI * R * R;
    }

    public double getPerimeter()
    {
        return 2 * Math.PI * R;
    }
}