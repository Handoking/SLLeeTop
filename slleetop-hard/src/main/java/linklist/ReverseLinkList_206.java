package linklist;

/**
 * @program: SLLeeTop
 * @description: 反转链表
 * @author: shileilei
 * @date: 2023-07-04 10:26
 **/
public class ReverseLinkList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode pHead = new ListNode(-1);
        while(head != null){
            ListNode next = head.next;
            head.next = pHead.next;
            pHead.next = head;
            head = next;
        }
        return pHead.next;
    }

    /**
     * 迭代
     * @param head
     * @return
     */
    public ListNode reverseList_V2(ListNode head){
        ListNode pHead = new ListNode(0, head);
        ListNode pre = null;
        ListNode cur = pHead.next;
        while(cur.next != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 原链上交换
     * @param head
     * @return
     */
    public ListNode reverseList_V3(ListNode head){

        ListNode pHead = new ListNode(-1, head);
        ListNode cur = pHead.next;
        while(cur.next != null){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pHead.next;
            pHead.next = next;
        }
        return pHead.next;
    }

    /**
     * K一组反转链表
     * @param head
     * @param k
     * @return
     */
    public ListNode func_25(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head), prev = dummy;
        while (true) {
            // 检查剩余节点是否有k个，不足则返回
            ListNode last = prev;
            for (int i = 0; i < k; i++) {
                last = last.next;
                if (last == null) {
                    return dummy.next;
                }
            }

            // 翻转k个节点
            ListNode curr = prev.next, next;
            for (int i = 0; i < k - 1; i++) {
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = curr;
        }
    }


}
