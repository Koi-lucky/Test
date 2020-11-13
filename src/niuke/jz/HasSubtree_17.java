package niuke.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/12 22:39
 */
public class HasSubtree_17 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        // 特殊情况判断
        if (root1 == null || root2 == null) {
            return false;
        }
        // 先在tree1中找到tree2的根节点
        // 如果该根节点的树结构不相同，则向根节点的左右子树进行递归查找
        return doesTree1HaveTree2( root1, root2) || HasSubtree( root1.left, root2) || HasSubtree( root1.right, root2);
    }

    // 判断树的结构是否相同
    public boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        // 递归的出口
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        // 如果两个数的根节点不同，则两棵树的结构肯定不同
        if (root1.val != root2.val) {
            return false;
        }
        // 递归调用
        return HasSubtree( root1.left, root2.left) && HasSubtree( root1.right, root2.right);
    }
}