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
}
