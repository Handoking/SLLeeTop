package tree;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: SLLeeTop
 * @description: 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum
 * @author: shileilei
 * @date: 2023-07-17 23:20
 **/
public class SumTree_112 {

    private static final ExecutorService MULTI_THREAD_POOL_SERVICE = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors(),
            Runtime.getRuntime().availableProcessors()*2,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(100),
            ((r, executor) -> System.out.println("retail-stock-purchase-wash执行task被拒绝")));

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        if (root.left ==null && root.right== null){
            return root.val==targetSum;
        }
        return hasPathSum(root.left,targetSum- root.val) || hasPathSum(root.right, targetSum-root.val);
    }
}
