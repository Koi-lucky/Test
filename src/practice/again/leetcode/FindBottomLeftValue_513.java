package practice.again.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/26 21:37
 */
public class FindBottomLeftValue_513 {

    public int findBottomLeftValue(TreeNode root) {
        // 层序遍历实现最后一层的数据记录
        Queue<TreeNode> queue = new LinkedList<>();
        // 先将根节点存入队列中
        if (root != null) {
            queue.offer(root);
        }
        int res = 0;
        while (!queue.isEmpty()) {
            // 记录当前的队列大小
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                // 记录最后一行的第一个元素
                if (i == 0) {
                    res = node.val;
                }
                // 若左子结点  或者 右子节点 存在，分别将其压入队列的尾部
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
