package string;

/**
 * @program: SLLeeTop
 * @description: 字符串相加
 * @author: shileilei
 * 核心思想：
 * 1.逐位相加，并记录进位
 * 2.数值字符串-'0'即为int
 * @date: 2023-07-13 23:55
 **/
public class StringSum {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        StringBuilder ans =  new StringBuilder();
        int add = 0;
        while(i>=0 || j>=0 || add != 0){
            int n1 = i<0?0:num1.charAt(i)-'0';
            int n2 = j<0?0:num2.charAt(j)-'0';
            int sum = n1+n2+add;
            add = sum/10;
            ans.append(sum%10);
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }
}
