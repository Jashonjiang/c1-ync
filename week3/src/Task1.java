import java.util.*;

/*
 * 1.三数之和：给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a， b，c ，
 * 使得 a + b + c =target。请你找出所有满足条件且不重复的三元组
 */
public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();

        System.out.print("请输入数组元素（以','为分隔符）：");
        String str = in.nextLine();
        System.out.print("请输入target的值：");
        int target = in.nextInt();

        // 当没有输入数组元素时，正常退出程序
        if (str.length() == 0)
        {
            System.out.print("输出：[]");
            System.exit(0);
        }

        // 把输入的字符串转成数组
        String[] n = str.split(",");
        for(String s : n)
        {
            nums.add(Integer.parseInt(s));
        }

        // 将满足a+b+c=target的数组[a,b,c]存到ArrayList<int[]>中
        ArrayList<int[]> tuples = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++)
        {
            for(int j = i+1; j < nums.size(); j++)
            {
                for(int k = j+1; k < nums.size(); k++)
                {
                    if(nums.get(i) + nums.get(j) + nums.get(k) == target)
                    {
                        int[] num = {nums.get(i), nums.get(j), nums.get(k)};
                        Arrays.sort(num);
                        tuples.add(num);
                    }
                }
            }
        }

        // 去除ArrayList<int[]>中重复的数组
        for(int i = 0; i < tuples.size(); i++)
        {
            for(int j = i+1; j < tuples.size(); j++)
            {
                if(tuples.get(i)[0] == tuples.get(j)[0]
                && tuples.get(i)[1] == tuples.get(j)[1]
                && tuples.get(i)[2] == tuples.get(j)[2])
                {
                    tuples.remove(j);
                }
            }
        }

        // 将ArratList转成int[][],方便输出
        int[][] tuple = new int[tuples.size()][3];
        for(int i = 0; i < tuples.size(); i++)
        {
            tuple[i] = tuples.get(i);
        }

        System.out.print("输出：" + Arrays.deepToString(tuple));
    }
}