package niuke.面经;

import org.junit.Test;

public class ReverseList_78 {

    @Test
    public ListNode reverseList(ListNode head) {
        // 处理特殊情况
        if(head == null || head.next == null) {
            return head;
        }
        // 定义一个指针用于操作节点,让它指向头指针的下一个节点
        ListNode node = reverseList(head.next);
        // 让头指针的下下一个节点指向头指针自己
        head.next.next = head;
        // 让头指针的下一个节点做尾结点，指向null
        head.next = null;
        return node;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}