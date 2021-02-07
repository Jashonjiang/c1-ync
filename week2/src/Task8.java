/*
 * 8.抽象类练习题
 *  定义抽象类 A，抽象类B继承A，普通类C继承B
 *  A 类中，定义成员变量 numa，赋值为 10，抽象 showA 方法。
 *  B 类中，定义成员变量 numb，赋值为 20，抽象 showB 方法。
 *  C 类中，定义成员变量 numc，赋值为 30，重写 showA 方法，打印 numa，重写 showB 方法，打印 numb，定义 showC 方法，打印 numc。
 *  测试类中，创建 C 对象，调用 showA 方法，showB 方法，showC 方法。
 */

public class Task8
{
    public static void main(String[] args)
    {
        C c = new C();
        System.out.print("A中的numa：");
        c.showA();
        System.out.print("B中的numb：");
        c.showB();
        System.out.print("C中的numc：");
        c.showC();
    }
}

abstract class A
{
    private int numa = 10;

    public A(){}

    public abstract void showA();

    public int getNuma()
    {
        return numa;
    }
}

abstract class B extends A
{
    private int numb = 20;

    public B(){}

    public abstract void showB();

    public int getNumb()
    {
        return numb;
    }
}

class C extends B
{
    private int numc = 30;

    public C(){}

    public void showA()
    {
        System.out.println(super.getNuma());
    }

    public void showB()
    {
        System.out.println(super.getNumb());
    }

    public void showC()
    {
        System.out.println(numc);
    }

    public int getNumc()
    {
        return numc;
    }
}