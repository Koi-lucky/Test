package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/24 22:36
 */
public class InvertTree_226 {

    public TreeNode invertTree(TreeNode root) {
        // 用递归前序遍历实现树的反转
        // 特殊情况判断
        if (root == null) {
            return null;
        }
        // 单层递归逻辑

        // 将该节点的左右节点进行交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 向左子树递归
        invertTree(root.left);
        // 向右子树递归
        invertTree(root.right);

        // 递归的返回值
        return root;
    }
}
