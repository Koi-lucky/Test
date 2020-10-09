package leetcode;

import org.junit.Test;

public class HasCycle_141 {

    /**
     * 验证链表中是否有环存在
     * 方法：双指针法
     * 思路：
     * 1.定义两个指针，一个快指针，一个慢指针，快指针初始指向头结点的下一个位置，慢指针初始值指向头节点
     * 2.遍历整条链表
     *      2.1如果快慢指针相遇，则表示链表中没有环
     *      2.2如果没有相遇，则代表链表中有环存在
     * @param head
     */
    @Test
    public void hasCycle(ListNode head) {
        // 先判断给定的头结点是否为空,或者只有一个节点，这些都无法成环
        if (head == null || head.next == null) {
            System.out.println(false);
        }
        // 1.定义两个指针，一个快指针，一个慢指针，快指针初始指向头结点的下一个位置，慢指针初始值指向头节点
        ListNode fast = head.next;
        ListNode slow = head;
        // 2.遍历整条链表
        while (slow != fast) {
            // 2.1如果快慢指针相遇，则表示链表中没有环
            if (fast.next == null || fast.next.next == null) {
                System.out.println(false);
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        // 2.2如果没有相遇，则代表链表中有环存在
        System.out.println(true);
    }
}
