package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SLLeeTop
 * @description: 中序遍历
 * @author: shileilei
 * @date: 2023-07-31 22:24
 **/
public class MidOrderTree {
    public List<Integer> midOrder(TreeNode treeNode){
        List<Integer> midOrder = new ArrayList<>();
        midOrderD(treeNode, midOrder);
        return midOrder;
    }

    private void midOrderD(TreeNode treeNode, List<Integer>midOrder){
        if (treeNode == null){
            return;
        }
        midOrderD(treeNode.left, midOrder);
        midOrder.add(treeNode.val);
        midOrderD(treeNode.right, midOrder);
    }
}
