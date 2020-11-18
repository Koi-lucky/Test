package niuke.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/18 20:49
 */
public class IsBalanced_Solution_39 {

    public boolean IsBalanced_Solution(TreeNode root) {
        // 特殊情况
        if (root == null) {
            return true;
        }
        int leftLength = lengthTree(root.left);
        int rightLength = lengthTree(root.right);
        int div = leftLength - rightLength;
        if (div <= 1 && div >= -1 ) {
            return true;
        }
        return false;
    }

    // 求树的深度
    public int lengthTree(TreeNode root) {
        // 特殊情况
        if (root == null) {
            return 0;
        }
        return Math.max(lengthTree(root.left), lengthTree(root.right)) + 1;
    }
}
