package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: SLLeeTop
 * @description: 有效括号
 * @author: shileilei
 * @date: 2023-07-13 22:46
 **/
public class ValidKuoHao {

    public boolean isValid(String s) {
        int length = s.length()/2;
        for(int i=0;i<length;i++){
            s = s.replace("()","").replace("[]","").replace("{}","");
        }
        return s.length()==0;
    }


    public boolean isValidV2(String s) {
        Map<Character,Character> dict = new HashMap<>();
        dict.put(')', '(');
        dict.put(']','[');
        dict.put('}','{');
        Stack<Character> stack = new Stack<>();
        for (Character c: s.toCharArray()){
            if (!dict.containsKey(c)){
               stack.push(c);
            }else if (stack.empty() || !stack.pop().equals((dict.get(c)))){
                return false;
            }
        }
        return stack.empty();
    }
}
