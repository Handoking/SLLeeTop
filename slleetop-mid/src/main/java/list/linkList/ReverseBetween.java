package list.linkList;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: SLLeeTop
 * @description: 反转链表II
 * @author: shileilei
 * @date: 2023-07-24 22:56
 **/
public class ReverseBetween {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        Map<Integer,ListNode> map = new HashMap<>();
        ListNode temp = new ListNode(0,head);
        int i = 0;
        while(temp != null){
            map.put(i,temp);
            i++;
            temp = temp.next;
        }
        ListNode preNode =  map.get(left-1);
        preNode.next = null;
        ListNode afterNode = map.get(right+1);
        for (int k = right;k>=left;k--){
            preNode.next = map.get(k);
            preNode = preNode.next;
        }
        preNode.next = afterNode;
        return map.get(0);
    }

    public static void main(String[] args) {
        Integer[] testArr = {2,3,4,5,6};
        ListNode testNode = new ListNode(1);
        ListNode temp = testNode;
        for (Integer a:testArr){
            temp.next =new ListNode(a);
            temp = temp.next;
        }

        reverseBetween(testNode,1,4);
    }
}
