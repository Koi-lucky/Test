package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/3 9:47
 */
public class HasPathSum_112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // 特殊情况判断
        if (root == null) {
            return false;
        }
        // 用减法来实现找寻合适路径
        return traversal(root,targetSum - root.val);
    }

    // 编写一个函数用于判断是否找到了合适的路径
    public boolean traversal(TreeNode node, int sum) {
        // 递归的出口条件
        // 如果是根节点，并且该节点的值被剪掉之后，目标值sum==0
        // 或者 如果是根节点，被剪掉之后sum ！= 0
        if (node.left == null && node.right == null && sum == 0) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return false;
        }

        // 单层递归逻辑
        // 找寻合理的路径，所以空结点不进行判断
        if (node.left != null) {// 左递归
            // 如果找到了就返回true
            if (traversal(node.left, sum - node.left.val)) {// 此处带回溯
                return true;
            }
        }
        if (node.right != null) {// 右递归
            // 如果找到了就返回true
            if (traversal(node.right, sum - node.right.val)) {// 此处带回溯
                return true;
            }
        }
        return false;
    }
}
