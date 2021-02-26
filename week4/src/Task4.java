import java.util.ArrayList;
import java.util.Scanner;

/**
 * 4.给定一个整数数组，找出该数组中第 k 小的数。
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("请输入一个数组（以逗号为分隔符）：");
        String str = in.nextLine();
        System.out.print("请输入k：");
        int k = in.nextInt();
        String[] n = str.split(",");
        ArrayList<Integer> nums = new ArrayList<>();
        for(String s : n){
            nums.add(Integer.parseInt(s));
        }

        //排序
        for (int i = 0; i < nums.size() - 1; i++){
            for (int j = i+1; j < nums.size(); j++){
                if (nums.get(j) < nums.get(i)){
                    int temp = nums.get(i);
                    nums.set(i,nums.get(j));
                    nums.set(j,temp);
                }
            }
        }

        System.out.println("该数组中第k小的值是：" + nums.get(k-1));
    }
}
