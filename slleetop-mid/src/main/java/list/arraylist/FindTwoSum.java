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
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            if(keyIndexMap.containsKey(target-nums[i])){
                result[0] = i;
                result[1] = keyIndexMap.get(target-nums[i]);
                return result;
            }
            keyIndexMap.put(nums[i], i);
        }
        return result;
    }
}
