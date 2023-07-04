package list.arraylist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SLLeeTop
 * @description: 三数之和
 * @author: shileilei
 * @date: 2023-07-03 20:20
 **/
public class FindThreeSum_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int k=0;k< nums.length;k++){
            result.addAll(twoSum(nums, k, 0-nums[k]));
        }
        return result;
    }

    private static List<List<Integer>> twoSum(int[] nums ,int i, int target){
        List<List<Integer>> subResult = new ArrayList<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(nums[i], i);
        for (int j=0;j<nums.length;j++){
            if (j==i){
                continue;
            }
            if (indexMap.containsKey(target-nums[j])){
                int cur = indexMap.get(target-nums[j]);
                List<Integer> twoResult  = new ArrayList<>();
                if (cur != i && cur !=j){
                    twoResult.add(nums[i]);
                    twoResult.add(nums[j]);
                    twoResult.add(nums[cur]);
                }
                boolean isInclude = false;
                for (List<Integer> list :subResult){
                    if (list.containsAll(twoResult)) {
                        isInclude = true;
                        break;
                    }
                }
                if (!isInclude){
                    subResult.add(twoResult);
                }
            }
            indexMap.put(nums[j], j);
        }
        return subResult;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }
}
