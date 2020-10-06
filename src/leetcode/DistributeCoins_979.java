package leetcode;

import org.junit.Test;

public class DistributeCoins_979 {

    int ans;// 需要移动的步数

    /**
     *
     */
    @Test
    public void distributeCoins(TreeNode root) {
        ans = 0;// 步数初始化为0
        dfs(root);// 计算该节点的所有子树的过载量，即为所要走的步数
        System.out.println(ans);
    }

    /* 计算【该节点所在子树】上的【过载量】
     1.先计算这个节点与它的子节点之间需要移动金币的数量：Math.abs(dfs(node.left))+Math.abs(dfs(node.right))
     2.计算这个节点的过载量node.val + dfs(node.left) + dfs(node.right) - 1
     3.举例：根节点为3，左结点为0，右结点为0
             过载量：Math.abs(节点自身的值 - 1)
             所需要移动的步数：Math.abs(左子节点过载量)+Math.abs(右子结点过载量)
             根节点的过载量为：root.val + dfs(root.left) + dfs(root.right) - 1  【根节点自身的值 - 1 + 左子节点的过载量 + 右子结点的过载量】
             【结果】dfs(左子结点过载量)=0，dfs(右子节点过载量)=0，dfs(根节点过载量)=3+0+0-1=2，所需的步数为1+1=2

    */
    public int dfs(TreeNode node) {
        // 先判空
        if (node == null) {
            return 0;
        }
        // 计算这个节点与它的子节点之间需要移动金币的数量
        ans += Math.abs(dfs(node.left)) + Math.abs(dfs(node.right));
        // 输出这个节点的过载量
        return node.val + dfs(node.left) + dfs(node.right) - 1;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}