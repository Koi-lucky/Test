package niuke.jz;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/7 16:58
 */
public class PrintListFromTailToHead_3 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        // 特殊情况判断
        if (listNode == null) {
            return list;
        }
        // 定义一个指针用于操作链表
        ListNode node = listNode;
        // 遍历链表
        while (node != null) {
            // 将每个节点的值存入list集合中
            // ArrayList 中有个方法是 add(index,value)，可以指定 index 位置插入 value 值
            // 所以我们在遍历 listNode 的同时将每个遇到的值插入到 list 的 0 位置，最后输出 listNode 即可得到逆序链表
            list.add( 0, node.val);
            node = node.next;
        }
        return list;
    }
}


class ListNode {
       int val;
       ListNode next = null;

       ListNode(int val) {
           this.val = val;
       }
}