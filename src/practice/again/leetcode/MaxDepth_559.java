package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/25 21:06
 */
public class MaxDepth_559 {

    public int maxDepth(Node root) {
        // 特殊情况判断
        if (root == null) {
            return 0;
        }
        // 单层递归逻辑
        // 遍历孩子节点，找出孩子结点的最小高度+1
        int resDepth = 0;
        for (Node child : root.children) {
            resDepth = Math.max(resDepth, maxDepth(child));
        }
        return resDepth + 1;
    }
}
