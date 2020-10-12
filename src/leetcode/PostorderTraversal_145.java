package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal_145 {

    List<Integer> list = new ArrayList<>();
    @Test
    public void postorderTraversal(TreeNode root) {
        // 后序遍历一棵树,以列表的形式输出
        if(root == null) {
            System.out.println(list);
        }
        // 向左子树递归查询
        postorderTraversal(root.left);
        //向右子树递归查询
        postorderTraversal(root.right);
        // 向列表中加入根节点
        list.add(root.val);
        System.out.println(list);
    }
}
