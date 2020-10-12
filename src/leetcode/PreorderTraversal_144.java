package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal_144 {

    List<Integer> list = new ArrayList<>();
    @Test
    public void preorderTraversal(TreeNode root) {
        // 前序遍历一棵树,以列表的形式输出
        if(root == null) {
            System.out.println(list);
        }
        // 向列表中加入根节点
        list.add(root.val);
        // 向左子树递归查询
        preorderTraversal(root.left);
        //向右子树递归查询
        preorderTraversal(root.right);
        System.out.println(list);
    }
}
