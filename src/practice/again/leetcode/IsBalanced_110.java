package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/25 21:27
 */
public class IsBalanced_110 {

    public boolean isBalanced(TreeNode root) {
        // 特殊情况判断
        if (root == null) {
            return true;
        }
        return getDepth(root) == -1 ? false : true;
    }

    // 编写一个函数：返回以该节点为根节点的二叉树的高度，如果不是二叉搜索树了就返回-1
    public int getDepth(TreeNode root) {
        // 递归出口条件
        if (root == null) {
            return 0;
        }

        // 单层递归逻辑

        // 分别计算以该节点为根结点的左右子树的高度
        int leftDepth = getDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        // 然后再判断是不是二叉搜索树，
        // 不是则返回-1，是的话就返回树的最大高度
        int result;
        if (Math.abs(leftDepth - rightDepth) > 1) {
            result = -1;
        } else {
            result = Math.max(leftDepth, rightDepth) + 1;
        }
        return result;
    }
}
