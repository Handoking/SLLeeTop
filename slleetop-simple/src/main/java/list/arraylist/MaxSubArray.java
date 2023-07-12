package list.arraylist;

/**
 * @program: SLLeeTop
 * @description: 最大子串和
 * @author: shileilei
 * @date: 2023-07-06 22:10
 * 核心思想：连续序列，前面序列之和+当前值小于当前值，大可不必
 * 连续子序列和的问题，f(x)为序列和，f(i)的结果与f(i-1)相关，max = Math.max(f(i)+f(i-1), f(i))，已结束的元素为基点
 **/
public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int temp = nums[0];
        int max = temp;
        for (int i=1;i<nums.length;i++){
            if (temp+nums[i]>nums[i]){
                max = Math.max(max,temp+nums[i]);
                temp = temp + nums[i];
            }else{
                temp = nums[i];
                max = Math.max(max, temp);
            }
        }
        return max;
    }

    /**
     * f(x) = f(x-1)+nums[x];
     * @param nums
     * @return
     */
    public int maxSubArrayV2(int[] nums){
        int pre = nums[0];
        int max = nums[0];
        for (int i=1;i<nums.length;i++){
            pre = Math.max(pre+nums[i], nums[i]);
            max = Math.max(pre,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,-1,-1,-6,9};
        System.out.println(maxSubArray(nums));
    }
}
