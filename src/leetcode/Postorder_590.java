package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Postorder_590 {

    List<Integer> res = new ArrayList<>();//用于存放遍历后的结果

    //N叉树的后序遍历
    @Test
    public void postorder(Node root) {
        if(root != null) {
            for(Node child : root.children) {
                postorder(child);
            }
            res.add(root.val);
        }
        System.out.println(res);
    }
}

// 定义N叉树.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}