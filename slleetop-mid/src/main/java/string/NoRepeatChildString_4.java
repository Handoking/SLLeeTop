package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SLLeeTop
 * @description: 无重复最长子串
 * @author: shileilei
 * @date: 2023-06-27 19:42
 * 题解核心：滑动窗口
 * 既能获取字符又能获取index，并且有映射关系，存取都是O(1),所以选择HashMap来存储
 * 搞清楚什么时候start指针后移，以及多次重复的字符怎么办，就解了
 * 1. 当出现重复字符时，start指针移动到重复字符的下一个，相当于除去了重复的数据
 * 2. 每次移动后，扫过区域数据作废，重复的字符需要被put覆盖为窗口内的字符index
 **/
public class NoRepeatChildString_4 {

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int maxStartIndex =0;
        int maxEndIndex =0;
        int start=0;
        Map<Character, Integer> characterIndexMap =  new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (characterIndexMap.containsKey(s.charAt(i))){
                if (characterIndexMap.get(s.charAt(i))+1>start){
                    start=characterIndexMap.get(s.charAt(i))+1;
                }
            }
            if (i+1-start>maxLength){
                maxLength = i-start+1;
                maxStartIndex = start;
                maxEndIndex = i;
            }
            characterIndexMap.put(s.charAt(i), i);

        }

        System.out.println("maxLength:"+maxLength);
        System.out.println("maxStartIndex:"+maxStartIndex+",maxEndIndex:"+maxEndIndex);
        System.out.println("maxString:"+s.substring(maxStartIndex,maxEndIndex+1));
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaa";
        lengthOfLongestSubstring(s);
    }
}
