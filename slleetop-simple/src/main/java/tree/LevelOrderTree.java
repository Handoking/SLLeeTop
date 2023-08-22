package tree;

import java.util.*;

/**
 * @program: SLLeeTop
 * @description: 层序遍历
 * @author: shileilei
 * @date: 2023-07-31 22:25
 **/
public class LevelOrderTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        if (root == null){
            return levelList;
        }
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i =1; i<= currentLevelSize;i++){
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }

            levelList.add(subList);
        }
        return levelList;
    }
}
