package niuke.jz;

import org.junit.Test;

import java.util.Arrays;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/10 8:53
 */
public class ReConstructBinaryTree_4 {

    int[] pre = {1,2,3,4,5,6,7};//前序遍历序列
    int[] in = {3,2,4,1,6,5,7};//中序遍历序列

    @Test
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) throws Exception {
        // 特殊条件判断
        if (pre == null || in == null || pre.length == 0 || in.length == 0) {
            throw new Exception("输入的参数有误");
        }
        // 1.构造根节点 —— 前序遍历的第一个节点是根结点的值
        int rootValue = pre[0];
        TreeNode root = new TreeNode(rootValue);// 构造根节点
        // 2.在中序遍历中找到根节点的索引值，以此将中序遍历划分为两个子数组
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                // 2.1 构造左子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                // 2.2 构造右子树
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}