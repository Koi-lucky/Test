package practice.jzOffer;


/**
 * TODO
 *
 * @author Chen
 * @date 2021/6/2 15:08
 */
public class Mirror_18 {

    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        // 递归解法
        // 特殊判断
        if (pRoot == null) {
            return null;
        }
        // 交换一个节点的左右子结点节点
        TreeNode tempNode = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = tempNode;
        // 再递归的遍历树的左子树和右子树
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        return pRoot;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}