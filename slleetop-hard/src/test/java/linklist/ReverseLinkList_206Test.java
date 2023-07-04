package linklist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * @program: SLLeeTop
 * @description:
 * @author: shileilei
 * @date: 2023-07-04 10:42
 **/
@RunWith(PowerMockRunner.class)
public class ReverseLinkList_206Test {

    @InjectMocks
    private ReverseLinkList_206 reverseLinkList_206;

    @Test
    public void reverseList() {
        Integer[] testArr = {1,2,3,4,5,6};
        ListNode testNode = new ListNode();
        ListNode temp = testNode;
        for (Integer a:testArr){
            temp.next =new ListNode(a);
            temp = temp.next;
        }
        ListNode result = reverseLinkList_206.reverseList(testNode);
        ListNode newNode = reverseLinkList_206.reverseList_V2(result);
        reverseLinkList_206.reverseList_V3(newNode);
        while(result != null){
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }
}