package niuke.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/13 22:50
 */
public class Mirror_18 {

    public void Mirror(TreeNode root) {
        // 递归出口条件
        if (root == null || (root.left == null && root.right == null)) {// 如果根节点为空 或者 根节点为叶子节点
            return;
        }
        // 交换该字子树的左右子结点
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        // 向左子树递归
        if (root.left  != null) {
            Mirror(root.left);
        }
        // 向右子树递归
        if (root.right  != null) {
            Mirror(root.right);
        }
    }
}
