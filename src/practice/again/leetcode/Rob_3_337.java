package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/20 17:55
 */
public class Rob_3_337 {

    public static int rob(TreeNode root) {
        // 动态规划算法 —— 树形dp
        // 【思路】 —— 考虑当前节点“偷”还是“不偷” —— 如果偷，那当前节点的孩子节点就不能动 —— 如果不偷，就考虑偷左右孩子节点
        // 动态规划其实就是使用状态转移的容器来记录状态的变化
        // 1.使用一个长度为2的dp数组，dp[0] 记录“不偷”该结点时的最大金额数， dp[1]记录“偷”该节点时的最大金额数
        // 2.确定递归终止的条件（递归遍历树），这也相当于dp数组的初始化 —— 如果遇到空结点，“偷”与“不偷”都是0
        // 3.【后序遍历整棵树】 —— 递归左节点 —— 再递归右结点 —— 最后输出根节点的值


        // 特殊情况判断
        int[] result = robTree(root);
        return Math.max(result[0], result[1]);

    }

    // 偷树形dp的代码 ———— 后序递归遍历树
    // dp数组：下标0：不偷  下标1：偷
    public static int[] robTree(TreeNode node) {
        // 特殊情况判断
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] left = robTree(node.left);// 左子结点对应的dp数组
        int[] right = robTree(node.right);// 右子节点所对应的dp数组
        // 偷
        int val1 = node.val + left[0] + right[0];
        // 不偷
        int val2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);// 在两个里面分别要偷最大的
        return new int[]{val2, val1};
    }
}
