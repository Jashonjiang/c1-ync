import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 2. 约瑟夫环问题：圆圈中最后剩下的数字
 * 0,1,···,n-1 这 n 个数字排成一个圆圈，从数字 0 开始，每次从这个圆圈里删除第 m 个数字（删 除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4 这 5 个数字组成一个圆圈，从数字 0 开始每次删除第 3 个数字，则删 除的前 4 个数字依次是 2、0、4、1，因此最后剩下的数字是 3。
 */
public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("n=");
        int n = in.nextInt();
        System.out.print("m=");
        int m = in.nextInt();

        //初始化动态数组
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arrayList.add(i);
        }

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        //开始数数
        int k = 0;
        int d = -1;
        while(arrayList.size() > 1){
            k++;
            d++;
            if(d == arrayList.size()) d = 0;
            if(k%m == 0){
                arrayList1.add(arrayList.get(d));
                arrayList.remove(d);
                d--;
            }
        }

        System.out.println("依次删除：" + arrayList1);
        System.out.println("剩余：" + arrayList.get(0));
    }
}
