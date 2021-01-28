import java.util.Scanner;

/*
 * 7. 声明并测试一个复数类，其中包括 add()、reduce()、multiply()三种方法，分别实现两 个复数的相加、相减、相乘，然后输出计算的结果
 */

public class fuShu
{
    public static void main(String[] args) {
        Scanner in1 = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.println("请输入两个复数的实部和虚部：");
        String s1 = in1.nextLine();
        String s2 = in2.nextLine();

        int a1, a2, b1, b2;
        a1 = Integer.valueOf(s1.substring(0,1)); //第一个复数的实部
        b1 = Integer.valueOf(s1.substring(s1.length()-1)); //第一个复数的虚部
        a2 = Integer.valueOf(s2.substring(0,1)); //第二个复数的实部
        b2 = Integer.valueOf(s2.substring(s2.length()-1)); //第二个复数的虚部

        plural fs1 = new plural(a1,b1); //第一个复数
        plural fs2 = new plural(a2,b2); //第二个复数

        plural y1 = new plural(0,0);
        y1 = fs1.add(fs2);
        plural y2 = new plural(0,0);
        y2 = fs1.reduce(fs2);
        plural y3 = new plural(0,0);
        y3 = fs1.multiply(fs2);

        System.out.print("\n两个复数相加的结果为：");
        printPlural(y1);
        System.out.print("\n两个复数相减的结果为：");
        printPlural(y2);
        System.out.print("\n两个复数相乘的结果为：");
        printPlural(y3);
    }

    // 打印复数的函数
    public static void printPlural(plural p)
    {
        if (p.getReal() == 0)
        {
            if (p.getImaginary() == 0)
            {
                System.out.printf("0");
            }
            else
            {
                System.out.printf("%di", p.getImaginary());
            }
        }
        else
        {
            if (p.getImaginary() == 0)
            {
                System.out.printf("%d", p.getReal());
            }
            else if (p.getImaginary() < 0)
            {
                System.out.printf("%d%di", p.getReal(), p.getImaginary());
            }
            else if (p.getImaginary() == 1)
            {
                System.out.printf("%d+i", p.getReal());
            }
            else
            {
                System.out.printf("%d+%di", p.getReal(), p.getImaginary());
            }
        }
    }
}

class plural
{
    private int real; // 实部
    private int imaginary; // 虚部

    public plural(int r, int i)
    {
        real = r;
        imaginary = i;
    }

    public int getReal()
    {
        return this.real;
    }

    public int getImaginary()
    {
        return this.imaginary;
    }

    public plural add(plural p)
    {
        int r,i;
        r = this.real + p.getReal();
        i = this.imaginary + p.getImaginary();
        plural temp = new plural(r,i);
        return temp;
    }

    public plural reduce(plural p)
    {
        int r,i;
        r = this.real - p.getReal();
        i = this.imaginary - p.getImaginary();
        plural temp = new plural(r,i);
        return temp;
    }

    public plural multiply(plural p)
    {
        int r,i;
        r = this.real * p.getReal() - this.imaginary * p.getImaginary();
        i = this.real * p.getImaginary() + this.imaginary * p.getReal();
        plural temp = new plural(r,i);
        return temp;
    }
}
