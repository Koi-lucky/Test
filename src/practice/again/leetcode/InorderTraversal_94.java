package practice.again.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/24 20:17
 */
public class InorderTraversal_94 {

   /*
   // 递归法实现树的中序遍历
     public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }

    public void inorder(TreeNode root, List<Integer> list) {
        // 递归的终止条件
        if (root ==null) {
            return;
        }
        // 单层递归的逻辑

        // 树的中序遍历——左根右
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        // 递归的返回值——void此处无返回值
    }*/

    // 迭代法实现树的中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        // 特殊情况判断
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                // 先找到树的叶子节点
                stack.push(node);
                node = node.left;// 向左查找
            } else {
                // 将该节点加入到集合中，并从栈中弹出该节点
                node = stack.pop();
                res.add(node.val);
                node = node.right;// 向右查找
            }
        }

        return res;
    }

}
