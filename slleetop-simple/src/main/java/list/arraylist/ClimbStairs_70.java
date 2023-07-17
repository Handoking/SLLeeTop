package list.arraylist;

/**
 * @program: SLLeeTop
 * @description: 爬楼梯
 * @author: shileilei
 * @date: 2023-07-17 23:51
 **/
public class ClimbStairs_70 {

    public int climbStairs(int n) {
        int[] result = new int[n+1];
        return loop(n,result);
    }

    private int loop(int n, int[] result){
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        if (result[n]>0){
            return result[n];
        }
        result[n] = loop(n-1, result)+ loop(n-2, result);
        return result[n];
    }
}
