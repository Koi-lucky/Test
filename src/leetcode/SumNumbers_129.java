package leetcode;

import org.junit.Test;

public class SumNumbers_129 {

    int sum = 0;
    @Test
    public void sumNumbers(TreeNode root) {
        System.out.println(dfs( root, 0));
    }

    // 递归遍历一棵树—— 深度优先搜索
    public int dfs( TreeNode node, int preSum) {
        // 特殊情况判断
        // 1.结点为空
        if (node == null) {
            return 0;
        }
        sum = preSum * 10 + node.val;
        // 2.该节点的左右节点都为空，也就是说该节点是叶子节点
        if (node.right == null && node.left == null) {
            return sum;
        }
        // 否则的话，返回该节点的左子结点的值+右子节点的值
        return dfs(node.right, sum) + dfs( node.left, sum);
    }
}
