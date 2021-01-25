package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/25 21:22
 */
public class CountNodes_222 {

    public int countNodes(TreeNode root) {
        // 特殊情况判断
        if (root == null) {
            return 0;
        }
        // 单层递归逻辑
        // 跟求树的深度差不多
        // 计算数的左子树的节点个数 与 计算数的游子节点的个数 再 加1
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
