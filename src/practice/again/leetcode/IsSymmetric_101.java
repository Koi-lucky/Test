package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/25 20:45
 */
public class IsSymmetric_101 {

    public boolean isSymmetric(TreeNode root) {
        // 特殊情况判断
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    // 编写一个函数，判断一棵树它的左右子树是否对称
    public boolean compare(TreeNode left, TreeNode right) {
        // 递归的出口条件
        // 首先排除空结点的情况
        if (left == null && right == null) {
            return true;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right != null) {
            return false;
        } else if (left.val != right.val) {
            // 再排除节点值不相等的情况
            // 【此时，就只剩节点不为空且值相等的情况】
            return false;
        }// 【此时，就只剩节点不为空且值相等的情况】

        // 单层递归的逻辑

        // 判断树的外侧是否相等（左子树的左子结点 与 右子树的右子节点）
        boolean boolOutside = compare(left.left, right.right);
        // 判断树的内侧是否相等（左子树的右子节点 与 右子树的左子结点）
        boolean boolInside = compare(left.right, right.left);
        // 递归的返回值 —— 判断树的内侧和外侧是否都相等
        return boolOutside && boolInside;
    }
}
