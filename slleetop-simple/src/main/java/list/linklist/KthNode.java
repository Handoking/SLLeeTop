package list.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SLLeeTop
 * @description: 倒数第N个节点
 * @author: shileilei
 * @date: 2023-07-17 23:02
 **/
public class KthNode {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Map<Integer, ListNode> kmap = new HashMap<>();
        int i = 1;
        while(head != null){
            kmap.put(i, head);
            head = head.next;
            i++;
        }
        return kmap.get(i-k);
    }

    Map<Integer, Integer> map = new HashMap<>();
    public int fib(int n) {
        return circal(n);
    }

    private int circal(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }else{
            map.put(n,(circal(n-1)+circal(n-2)%1000000007));
        }
        return map.get(n);
    }
}
