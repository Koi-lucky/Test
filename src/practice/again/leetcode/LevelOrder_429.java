package practice.again.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/24 22:23
 */
public class LevelOrder_429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        // 特殊情况判断
        if (root == null) {
            return res;
        }
        // 用队列来实现树的层序遍历
        Queue<Node> que = new LinkedList<>();
        // 先将根节点加入到队列中
        que.offer(root);
        while (!que.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 固定队列的长度，此处不能使用queue.size()，因为他是可变的
            int currentSize = que.size();
            for (int i = 0; i < currentSize; i++) {
                // 弹出队列的头部元素，并向队列的尾部压入该节点的孩子节点
                Node node = que.poll();
                list.add(node.val);
                que.addAll(node.children);
            }
            // 将该层的结点加入到结果集合中
            res.add(list);
        }
        return res;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}