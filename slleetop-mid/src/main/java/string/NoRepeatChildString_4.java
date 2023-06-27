package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SLLeeTop
 * @description: 无重复最长子串
 * @author: shileilei
 * @date: 2023-06-27 19:42
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
                if (i-start>maxLength){
                    maxStartIndex= start;
                    maxEndIndex = i-1;
                }
                start=characterIndexMap.get(s.charAt(i))+1;
                continue;
            }
            maxEndIndex = i;
            characterIndexMap.put(s.charAt(i), i);
        }
        maxLength = maxEndIndex-maxStartIndex+1;
        System.out.println("maxLength:"+maxLength);
        System.out.println("maxStartIndex:"+maxStartIndex+",maxEndIndex:"+maxEndIndex);
        System.out.println("maxString:"+s.substring(maxStartIndex,maxEndIndex+1));
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcd";
        lengthOfLongestSubstring(s);
    }
}
