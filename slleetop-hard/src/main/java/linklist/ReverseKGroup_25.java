package linklist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SLLeeTop
 * @description: K个一组反转链表
 * @author: shileilei
 * @date: 2023-07-03 15:20
 *
 * 核心思想：
 * 分每k个节点翻转一次，如果少于k个节点不反转
 * 在一条链上进行节点移动
 **/
public class ReverseKGroup_25 {

    private  Map<ListNode, Integer> listNodeMap  = new HashMap<>();
    private  Map<Integer,ListNode>listNodeMapR = new HashMap<>();
    /**
     * 存放每k段头尾的映射，为了再次连接
     */
    private  Map<ListNode, ListNode> listNodeMapTail = new HashMap<>();
    private  List<ListNode> subListNodes = new ArrayList<>();
    public  ListNode reverseKGroup(ListNode head, int k) {
        ListNode pHead = head;
        int count = 0;
        while(pHead != null){
            count++;
            listNodeMap.put(pHead, count);
            listNodeMapR.put(count,pHead);
            pHead =  pHead.next;
        }

        ListNode result = new ListNode(-1);
        ListNode temp = result;
        cutKListNode(head,k);
        for (ListNode node:subListNodes){
            int addKIndex = listNodeMap.get(node)+k-1;
            if (addKIndex<=count){
                ListNode subListNode = reverseListNode(node, k);
                temp.next = subListNode;
                temp = listNodeMapTail.get(subListNode);
            }else {
                temp.next = node;
            }
        }
        return result.next;
    }


    /**
     * 反转链表
     * @param listNode
     * @param k
     * @return
     */
    private  ListNode reverseListNode(ListNode listNode,Integer k){
        ListNode newNode = new ListNode(-1);
        int currentIndex = listNodeMap.get(listNode);
        ListNode subTail = listNode;
        while(listNode != null && listNodeMap.get(listNode)-currentIndex<k){
            listNodeMapTail.put(listNode, subTail);
            ListNode nextNode = listNode.next;
            listNode.next = newNode.next;
            newNode.next = listNode;
            listNode = nextNode;
        }
        return newNode.next;
    }

    /**
     * 切链表为每k一段
     * @param head
     * @param k
     */
    private void cutKListNode(ListNode head, int k){
        while(head != null){
            subListNodes.add(head);
            int index = listNodeMap.get(head);
            head = listNodeMapR.get(index+k);
        }
    }

    public ListNode reverseKGroup_v2(ListNode head, int k){
        ListNode pHead = new ListNode(-1, head);
        ListNode pre = pHead;
        while(true){
            ListNode last =  pre.next;
            for(int i=0;i<k;i++){
                if (last== null){
                    return pHead.next;
                }
                last = last.next;
            }
            ListNode cur = pre.next;
            for (int j=0;j<k-1;j++){
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = cur;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
