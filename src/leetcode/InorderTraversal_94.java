package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal_94 {

    List<Integer> list = new ArrayList<>();
    @Test
    public void inorderTraversal(TreeNode root) {
        // 中序遍历一棵树,以列表的形式输出
        if(root == null) {
            System.out.println(list);
        }
        // 向左子树递归查询
        inorderTraversal(root.left);
        // 向列表中加入根节点
        list.add(root.val);
        //向右子树递归查询
        inorderTraversal(root.right);
        System.out.println(list);
    }
}
