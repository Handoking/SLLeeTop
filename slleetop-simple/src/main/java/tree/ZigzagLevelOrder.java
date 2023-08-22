package tree;

import java.util.*;

/**
 * @program: SLLeeTop
 * @description: 锯齿交错遍历
 * @author: shileilei
 * @date: 2023-08-01 00:08
 **/
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result =  new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int currentLevelSize = queue.size();
            for(int i=1;i<=currentLevelSize;i++){
                TreeNode node = queue.poll();
                subList.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            if(result.size()%2==1){
                Collections.reverse(subList);
            }
            result.add(subList);
        }
        return result;
    }


}
