package leetcode;

import org.junit.Test;

public class MinDiffInBST_783 {

    int pre;
    int ans;

    /**
     * 思路分析：
     * 1.中序遍历一棵树，会得到一个升序的数组
     * 2.求数组中相邻的两个数的差的最小值，即为所求的值
     * 3.在遍历数组的同时进行两数求差，设置一个变量pre用于存储前一个节点的值 【这样就不需要单独开辟一个数组进行求最小差】
     * @param root
     */
    @Test
    public void minDiffInBST(TreeNode root) {
        // 初始化两个全局变量
        ans = Integer.MAX_VALUE;
        pre = -1;
        // 中序遍历
        dfs(root);
        System.out.println(ans);

    }

    // 中序遍历一棵树
    public void dfs(TreeNode root) {
        // 判空
        if (root == null) {
            return;
        }
        // 向左子树递归查询
        dfs(root.left);
        // 2.求数组中相邻的两个数的差的最小值，即为所求的值
        if (pre == -1) {
            // 第一个结点
            pre = root.val;
        } else {
            // 不是第一个节点，就让他和前一个值进行差运算,在和前一个差值进行比较，输出最小的差值
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        // 向右子树递归查询
        dfs(root.right);
    }
}
