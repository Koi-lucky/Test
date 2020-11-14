package niuke.jz;

import java.util.*;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/13 23:29
 */
public class PrintFromTopToBottom_22 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        // 特殊情况判断
        if (root == null) {
            return list;
        }
        // 先把根节点添加至队列中
        queue.add(root);
        // 遍历以这个结点为根的树
        while (!queue.isEmpty()) {
            TreeNode node = queue.getFirst();// 取队列的第一个元素
            queue.pollFirst();// 让队列的第一个元素出队列
            list.add(node.val);// 将队列的第一个元素加入到集合中
            // 如果根节点存在左子结点，将左子结点加入队列最末尾
            if (node.left != null) {
                queue.addLast(node.left);
            }
            // 如果根节点存在右子节点，就将右子节点加入队列最末尾
            if (root.right != null) {
                queue.addLast(node.right);
            }
        }
        return list;
    }
}
