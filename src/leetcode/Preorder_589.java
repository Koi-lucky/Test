package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Preorder_589 {
    List<Integer> res = new ArrayList<>();//用于存放遍历后的结果

    //N叉树的前序遍历
    @Test
    public void preorder(Node root) {
        if(root != null) {
            res.add(root.val);
            for(Node child : root.children) {
                preorder(child);
            }
        }
        System.out.println(res);
    }
}
