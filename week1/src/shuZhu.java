/*
 * 4. 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 */

public class shuZhu
{
    public static void main(String[] args)
    {
        int[] nums = {0,1,0,3,12};

        System.out.print("输入: [");
        for (int i = 0; i < nums.length - 1; i++)
        {
            System.out.print(nums[i] + ",");
        }
        System.out.println(nums[nums.length - 1] + "]");

        int[] newNums = hanShu(nums);

        System.out.print("输出: [");
        for (int i = 0; i < newNums.length - 1; i++)
        {
            System.out.print(newNums[i] + ",");
        }
        System.out.println(newNums[newNums.length - 1] + "]");
    }

    public static int[] hanShu(int[] nums)
    {
        int[] nn = new int[nums.length];
        for (int i = 0; i < nn.length; i++)
        {
            nn[i] = 0;
        }

        int k = 0;
        for(int n : nums)
        {
            if (n != 0)
            {
                nn[k] = n;
                k++;
            }
        }

        return nn;
    }
}
