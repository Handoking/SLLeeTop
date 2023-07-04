package linklist;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.modules.junit4.PowerMockRunner;


/**
 * @program: SLLeeTop
 * @description:
 * @author: shileilei
 * @date: 2023-07-03 20:21
 **/
@RunWith(PowerMockRunner.class)
public class ReverseKGroup_25Test {


    @InjectMocks
    private ReverseKGroup_25 reverseKGroup_25;

    @Test
    public void reverseKGroup() {
        Integer[] testArr = {1,2,3,4,5,6};
        ReverseKGroup_25.ListNode testNode = new ReverseKGroup_25.ListNode();
        ReverseKGroup_25.ListNode temp = testNode;
        for (Integer a:testArr){
            temp.next = new ReverseKGroup_25.ListNode(a);
            temp = temp.next;
        }

        ReverseKGroup_25.ListNode result = reverseKGroup_25.reverseKGroup(testNode,4);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}