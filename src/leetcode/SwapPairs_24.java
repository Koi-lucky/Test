package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SwapPairs_24 {

    List<Integer> list = new ArrayList<>();

    /**
     * 交换相邻两结点的指针指向
     * 思路分析：
     * 1.特殊条件：节点值为空，或者只有一个节点，无法进行交换
     * 2.定义一个结点指针用于操作链表
     * 3.先让头结点指向下下一个节点，再让下一个节点指向头结点（以此慢慢递归）
     * @param head
     * @return
     */
    @Test
    public ListNode swapPairs(ListNode head) {
        // 如果节点为空,或者只有一个节点
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node = head.next;
        // 交换节点的指针指向
        head.next = swapPairs(node.next);
        node.next = head;
        return node;
    }
}
