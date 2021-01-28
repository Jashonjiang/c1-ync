import java.util.Scanner;

/*
 *6. 编写一个银行账户类，类的构成包括： 数据成员：用户的账户名称、用户的账户余额;
 * 方法包括：开户（设置账户名称及余额, 利用构造方法完成)；查询余额
 */

public class yinHang
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("请输入账户名：");
        String n = in.next();

        System.out.print("请输入账户余额：");
        double b = in.nextDouble();

        bankAccount user = new bankAccount(n, b);

        System.out.println("您的账户名：" + user.getName());
        System.out.printf("您的账户余额：%.2f", user.getBalance());
    }
}

class bankAccount
{
    private String name;
    private double balance;

    public bankAccount(String n, double b)
    {
        name = n;
        balance = b;
    }

    public String getName()
    {
        return name;
    }

    public double getBalance()
    {
        return balance;
    }
}
