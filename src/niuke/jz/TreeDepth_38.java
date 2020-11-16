package niuke.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/15 22:49
 */
public class TreeDepth_38 {

    public int TreeDepth(TreeNode root) {
        // 特殊情况判断
        if (root == null) return 0;
        // 递归的计算该节点的左子树和右子树中最大的深度
        return Math.max( TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}
