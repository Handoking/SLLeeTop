package list.arraylist;

import java.util.*;

/**
 * @program: SLLeeTop
 * @description: 三数之和
 * @author: shileilei
 * @date: 2023-07-03 20:20
 * 核心思想：
 * 排序：遍历时关注前后的元素，就能避免重复数据
 * 双指针移动：须保证前指针小于后指针。满足0和的条件，指针移动；数据重复指针移动；大于目标数，后指针移动，小于目标数，前指针移动
 * 还需要关注边界情况 比如空数组/数组数据不够三个/第一个就大于0，那么不可能存在相加等于0的情况，直接返回
 **/
public class FindThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //先排序，可以减少重复
        Arrays.sort(nums);
        if (nums[0]>0){
            return result;
        }
        //使用双指针，因此不需要遍历到最后，否则最后一个指针会超出数组的长度
        for (int k=0;k< nums.length-2;k++){
            //数据重复，直接进行下一个循环
            if (k>0 && nums[k] == nums[k-1]){
                continue;
            }
            twoSumNoRepeat(nums, k, 0-nums[k],result);
        }
        return result;
    }

    private static void twoSumNoRepeat(int[] nums, int k, int target,List<List<Integer>> result){
        int left = k+1;
        int right = nums.length-1;
        while (left<right){
            if (nums[left]+nums[right]==target){
                result.add(Arrays.asList(nums[k],nums[left],nums[right]));
                //添加结果后，继续往后找下一个满足的组合，指针要移动
                left++;
                right--;
                //left要小于right 数据重复指针移动
                while(left<right && nums[left] == nums[left+1]){
                    left++;
                }
                //left要小于right 数据重复指针移动
                while(left<right && nums[right]==nums[right-1]){
                    right++;
                }
            }else if(nums[left]+nums[right]<target){
                left++;
            }else{
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
