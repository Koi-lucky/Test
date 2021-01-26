package practice.again.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/25 21:53
 */
public class BinaryTreePaths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        List<String> resPath = new ArrayList<>();
        // 特殊情况判断
        if (root == null) {
            return resPath;
        }
        traversal(root, path, resPath);
        return resPath;
    }

    // 编写一个函数：对树进行前序遍历，并且记录每条路经
    // 回溯+递归
    public void traversal(TreeNode cur, List<Integer> path, List<String> res ) {

        path.add(cur.val);

        // 递归的出口条件
        // 因为是要树的路径，所以此处不需要判断当前节点cur是否为空，而是要判断当前结点是否为叶子节点
        // 当前节点为叶子节点 —— 将路径变成字符串形式，并添加到结果集合中
        if (cur.left == null && cur.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                if (i == path.size() - 1) {
                    sb.append(path.get(i));
                    break;
                }
                sb.append(path.get(i) + "->");
            }
            res.add(sb.toString());
            return;
        }
        // 单层递归的逻辑
        // 如果该结点的左右子结点不为空，各自进行递归，并最后进行回溯
        if (cur.left != null) {
            traversal(cur.left, path, res);
            path.remove(path.size() - 1);// 回溯
        }
        if (cur.right != null) {
            traversal(cur.right, path, res);
            path.remove(path.size() - 1);// 回溯
        }
    }
}
