package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: SLLeeTop
 * @description: 二叉树的右视图
 * @author: shileilei
 * @date: 2023-08-01 23:14
 **/
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int currentLevelSize = queue.size();
            for(int i=1;i<=currentLevelSize;i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                if(i== currentLevelSize){
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}
