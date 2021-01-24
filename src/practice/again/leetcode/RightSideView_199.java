package practice.again.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/24 22:05
 */
public class RightSideView_199 {

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        // 特殊情况判断
        if (root == null) {
            return list;
        }
        // 用队列来实现树的层序遍历
        Queue<TreeNode> que = new LinkedList<>();
        // 先将根节点加入到队列中
        que.offer(root);
        while (!que.isEmpty()) {

            // 固定队列的长度，此处不能使用queue.size()，因为他是可变的
            int currentSize = que.size();
            for (int i = 0; i < currentSize; i++) {
                // 弹出队列的头部元素，并向队列的尾部压入该节点的左右节点
                TreeNode node = que.poll();
                // 层序遍历的时候，判断是否遍历到单层的最后面的元素
                if (i == currentSize - 1) {
                    list.add(node.val);
                }
                // 如果给节点有左子结点，在队列的尾部进行添加
                if (node.left != null) {
                    que.offer(node.left);
                }
                // 如果给节点有右子结点，在队列的尾部进行添加
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }
        return list;
    }
}
