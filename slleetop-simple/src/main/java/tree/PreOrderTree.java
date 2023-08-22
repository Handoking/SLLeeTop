package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: SLLeeTop
 * @description: 前序遍历
 * @author: shileilei
 * @date: 2023-07-31 22:24
 **/
public class PreOrderTree {
    public List<Integer> preOrder(TreeNode treeNode){
        List<Integer> preOrder = new ArrayList<>();
        preOrderD(treeNode, preOrder);
        return preOrder;
    }

    private void preOrderD(TreeNode treeNode, List<Integer>preOrder){
        if (treeNode == null){
            return;
        }
        preOrder.add(treeNode.val);
        preOrderD(treeNode.left, preOrder);
        preOrderD(treeNode.right, preOrder);
    }
}
