import java.util.Arrays;

/**
 * ②用java语言实现冒泡排序、插入排序、快速排序、合并排序、堆排序
 */
public class Task2 {
    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1,10,11,12,13,14,15,20,19,18,17,16}; // 0~20乱序
        maoPao(nums);
        chaRu(nums);
        kuaiSu(nums);
        guiBing(nums);
        dui(nums);
        System.out.println(Arrays.toString(nums));
    }

    //冒泡排序
    public static void maoPao(int[] nums){
        if(nums.length <=1 ) return; // 元素过少，不需要排序
        for (int i = 0; i < nums.length - 1; i++){
            int min = nums[i];
            int k = i;
            for(int j = i+1; j < nums.length; j++){
                if (min > nums[j]){
                    min = nums[j];
                    k = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        };
    }
    //插入排序（折半插入）
    public static void chaRu(int[] nums){
        if(nums.length <=1 ) return; // 元素过少，不需要排序
        if(nums[0] > nums[1]){
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
        }
        for(int i = 2; i < nums.length; i++){
            int high = i-1;
            int low = 0;
            int m = 0;
            while(low <= high){
                m = (low + high) / 2;
                if(nums[i] <= nums[m]){
                    high = (high+low) / 2 - 1;
                }
                else if(nums[i] >= nums[m]){
                    low = (high+low) / 2 + 1;
                }
            }
            int temp = nums[i];
            for (int j = i; j > low; j--){
                nums[j] = nums[j-1];
            }
            nums[low] = temp;
        }
    }
    //快速排序
    public static void kuaiSu(int[] nums){
        ksort(nums, 0, nums.length-1);
    }
    public static void ksort(int[] nums, int low, int high){
        if (low < high) {
            int k = Partition(nums, low, high); //进行一趟递归排序
            ksort(nums, low, k - 1); //对低子表进行递归排序
            ksort(nums, k + 1, high); //对搞子表进行递归排序
        }
    }
    public static int Partition(int[] nums, int low, int high){ //一趟排序
        int pivotkey = nums[low];
        int temp;
        while (low < high){
            while(low < high && pivotkey <= nums[high]) high--;
            temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            while(low < high && pivotkey >= nums[low]) low++;
            temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
        }
        return low;
    }
    //归并排序
    public static void guiBing(int[] nums){
        fenZhi(nums,0, nums.length-1);
    }
    public static void fenZhi(int[] nums, int start, int end){
        if (start >= end) return;
        else {
            int m = (start+end) / 2;
            fenZhi(nums, start, m);
            fenZhi(nums,m + 1, end);
            merge(nums, start, m, end);
        }
    }
    public static void merge(int[] nums, int start, int m, int end){
        int[] nums1 = new int[end-start + 1];
        int j = m+1;
        int k = 0;
        int i = start;
        for(; i <= m && j <= end;){
            if(nums[i] < nums[j]) nums1[k++] = nums[i++];
            else nums1[k++] = nums[j++];
        }
        while(i <= m){
            nums1[k++] = nums[i++];
        }
        while(j <= end){
            nums1[k++] = nums[j++];
        }
        k = 0;
        for(int a = start; a <= end;){
            nums[a++] = nums1[k++];
        }
    }
    //堆排序（大根堆）
    public static void dui(int[] nums){
        //初始化堆
        for(int i = nums.length-2; i >=0; i--){
            saiXuan(nums, i, nums.length-1);
        }
        // 堆顶与最后一个元素交换
        int end = nums.length - 1;
        int temp = 0;
        while (end > 0) {
            temp = nums[0];
            nums[0] = nums[end];
            nums[end] = temp;
            end--;
            saiXuan(nums, 0, end);
        }

    }
    //筛选
    public static void saiXuan(int[] nums, int k, int end){
        int temp = 0;
        if (end == 0) return;
        while(k <= (end-1)/2){
            if(2*k+2 <= end) {
                if(nums[k] >= nums[2*k + 1] && nums[k] >= nums[2*k + 2]) break;
                if (nums[2*k + 1] >= nums[2*k + 2]) {
                    temp = nums[k];
                    nums[k] = nums[2*k + 1];
                    nums[2*k + 1] = temp;
                    k = 2*k + 1;
                }else{
                    temp = nums[k];
                    nums[k] = nums[2*k + 2];
                    nums[2*k + 2] = temp;
                    k = 2*k + 2;
                }
            }else{
                if(nums[k] >= nums[2*k + 1]) break;
                else{
                    temp = nums[k];
                    nums[k] = nums[2*k + 1];
                    nums[2*k + 1] = temp;
                    k = 2*k + 1;
                }
            }
        }
    }
}
