package list.linklist;

/**
 * @program: SLLeeTop
 * @description: 合并两个升序链表
 * @author: shileilei
 * @date: 2023-07-13 00:21
 **/
public class MergeLinkList_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result =  new ListNode(-1);
        ListNode temp =  result;
        while(list1 !=null && list2 != null){
            if (list1.val<= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp =  temp.next;
        }
        temp.next =  list1 == null ? list2:list1;
        return result.next;
    }
}
