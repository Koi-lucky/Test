package practice.again.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/24 20:00
 */
public class PreorderTraversal_144 {

/*
    // 递归法实现树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        preorder(root, list);
        // 递归返回值
        return list;
    }

    public void preorder( TreeNode root, List<Integer> list) {
        // 递归终止条件
        if (root == null) {
            return ;
        }
        // 单层递归的逻辑

        // 前序遍历——根左右
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }*/


    // 迭代法实现树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        // 特殊情况判断
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 先将根节点压入栈内
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            stack.pop();
            if (node != null) {
                list.add(node.val);
            } else {
                continue;
            }
            // 注意压栈顺序 —— 先右后左，这样弹栈的结果就会为根左右
            stack.push(node.right);
            stack.push(node.left);
        }
        return list;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }