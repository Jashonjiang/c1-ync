import java.util.Scanner;

/**
 * 3.编写一个程序，实现将小数转为分数的功能
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个小数：");
        String s = in.nextLine();
        String[] str = s.split("\\.");
        Point point = new Point(Integer.parseInt(str[0] + str[1]), (int)Math.pow(10,str[1].length()));
        point.println();
    }
}

class Point{
    private int fz;
    private int fm;

    public Point(int z, int m){
        for (int i = z/2; i > 1; i--){
            if (z%i == 0 && m%i == 0){
                z = z/i;
                m = m/i;
            }
        }
        this.fz = z;
        this.fm = m;
    }

    public void println(){
        System.out.println(this.fz + "/" + this.fm);
    }
}