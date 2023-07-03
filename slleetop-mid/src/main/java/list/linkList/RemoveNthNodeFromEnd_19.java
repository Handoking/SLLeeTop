package list.linkList;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SLLeeTop
 * @description: 删除链表的倒数第 N 个结点
 * @author: shileilei
 * @date: 2023-06-30 16:28
 **/
public class RemoveNthNodeFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> indexMap = new HashMap<>();
        ListNode phead = new ListNode(0, head);
        ListNode temp = phead;
        int index = 0;
        while(temp != null){
            index++;
            indexMap.put(index, temp);
            temp = temp.next;

        }
        indexMap.get(index-n).next = indexMap.get(index-n+2);
        indexMap.get(index-n+1).next = null;

        return phead.next;

    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
}
