package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/26 21:07
 */
public class SumOfLeftLeaves_404 {

    public int sumOfLeftLeaves(TreeNode root) {
        // 递归出口条件
        if (root == null) {
            return 0;
        }

        // 单层递归的逻辑

        // 对左右子树分别进行递归判断
        // 找左叶子节点 —— 该节点的左节点不为空 && 该左节点没有孩子节点
        int leftVal = sumOfLeftLeaves(root.left);
        int rightVal = sumOfLeftLeaves(root.right);
        int resSum = 0;
        // 该节点是左叶子节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            resSum = root.left.val;
        }
        return  leftVal + rightVal + resSum;
    }
}
