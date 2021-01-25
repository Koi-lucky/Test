package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/25 21:01
 */
public class MaxDepth_104 {

    public int maxDepth(TreeNode root) {
        // 特殊情况判断
        if (root == null) {
            return 0;
        }
        // 单层递归的逻辑
        // 先求它的左子树的深度，
        // 再求的右子树的深度，
        // 最后取左右深度最大的数值 再+1 （加1是因为算上当前中间节点）就是目前节点为根节点的树的深度。
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
