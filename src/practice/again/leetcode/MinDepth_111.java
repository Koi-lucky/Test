package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/25 21:01
 */
public class MinDepth_111 {

    public int minDepth(TreeNode root) {
        // 递归的出口条件
        // 根节点为空
        if (root == null) {
            return 0;
        }
        // 该根节点只有一个子节点（左子结点为空 或者 右子节点为空）
        if (root.left == null && root.right != null) {
            return minDepth(root.right) + 1;
        }
        if (root.left != null && root.right == null) {
            return minDepth(root.left) + 1;
        }
        // 单层递归的逻辑

        // 求出左子树的高度 与 右子树的高度 求出最小值 再加1
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
