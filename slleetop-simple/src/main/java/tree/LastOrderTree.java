package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SLLeeTop
 * @description: 后续遍历
 * @author: shileilei
 * @date: 2023-07-31 22:25
 **/
public class LastOrderTree {
    public List<Integer> lastOrder(TreeNode treeNode){
        List<Integer> lastOrder = new ArrayList<>();
        lastOrderD(treeNode, lastOrder);
        return lastOrder;
    }

    private void lastOrderD(TreeNode treeNode, List<Integer>lastOrder){
        if (treeNode == null){
            return;
        }
        lastOrderD(treeNode.left, lastOrder);

        lastOrderD(treeNode.right, lastOrder);
        lastOrder.add(treeNode.val);
    }
}
