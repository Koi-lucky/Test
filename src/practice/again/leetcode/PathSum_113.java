package practice.again.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/2/3 10:08
 */
public class PathSum_113 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res.clear();
        path.clear();
        // 特殊情况判断
        if (root == null) {
            return res;
        }

        traversal(root, targetSum - root.val);
        return res;
    }

    // 编写一个函数用于找寻合适的路径
    public void traversal(TreeNode node, int sum) {
        path.add(node.val);
        // 递归的出口条件
        if (node.left == null && node.right == null && sum == 0) {
            res.add(path);
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        // 单层递归逻辑
        // 空结点不进行判断
        if (node.left != null) {// 左递归
            traversal(node.left, sum - node.left.val);// 回溯递归
            path.remove(path.size() - 1);// 回溯
        }
        if (node.right != null) {// 左递归
            traversal(node.right, sum - node.right.val);// 回溯递归
            path.remove(path.size() - 1);// 回溯
        }
    }
}
