package list.arraylist;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SLLeeTop
 * @description: 查询两数和
 * @author: shileilei
 * @date: 2023-06-29 19:29
 **/
public class FindTwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> keyIndexMap = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            keyIndexMap.put(nums[i],i);
        }

        int[] result = new int[2];
        for(int i: keyIndexMap.keySet()){
            if (keyIndexMap.containsKey(target-i)){
                result[0] =i;
                result[1] = nums[keyIndexMap.get(i)];
            }
        }
        return result;
    }
}
