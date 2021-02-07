/*
 * 4.猜数字游戏
 */

import java.util.Scanner;

public class Task4
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("欢迎来到猜字游戏，请输入一个数：");
        int x;
        Game game = new Game();
        boolean flag = false;
        while(!flag)
        {
            x = in.nextInt();
            flag = game.guess(x);
        }
    }
}

class Game
{
    private final int v = 100;

    public Game() {}

    public boolean guess(int x)
    {
        if (x < v)
        {
            System.out.println("猜的有点小，再试一下吧!");
            return false;
        }
        else if (x > v)
        {
            System.out.println("猜的有点大，再试一次吧!");
            return false;
        }
        else
        {
            System.out.println("恭喜你，猜对了!");
            return true;
        }
    }
}
