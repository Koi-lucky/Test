package practice.again.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/24 20:04
 */
public class PostorderTraversal_145 {

/*    // 递归实现树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }*/

    // 迭代法实现树的后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        // 将前序遍历的代码进行改写
        // 前序遍历是左右根 —— 调换左右节点压栈顺序，此时变成 根右左 —— 再将集合进行反转，此时就是 左右根
        List<Integer> list = new ArrayList<>();
        // 特殊情况判断
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            stack.pop();
            if (node != null) {
                list.add(node.val);
            } else {
                continue;
            }
            // 注意压栈顺序 —— 先左后右，这样弹栈的结果就会为根右左
            stack.push(node.left);
            stack.push(node.right);
        }
        // 此时出来的结果是 根右左
        // 再将集合进行反转，结果才能是左右根
        Collections.reverse(list);
        return list;
    }
}
