package tree;

/**
 * @program: SLLeeTop
 * @description: 树
 * @author: shileilei
 * @date: 2023-07-17 23:20
 **/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
   }
}
