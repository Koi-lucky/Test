package practice.again.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/6 16:50
 */
public class HasCycle_23_1 {

    public boolean hasCycle(ListNode head) {
        // 快慢指针 —— 快指针一次走两步，慢指针一次走一步，如果两指针相遇，则说明链表有环，否则无环

        // 特殊情况判断
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode low = head;
        while (fast != null && fast.next != null && low != null) {
            if (fast == low) {
                return true;
            }
            fast = fast.next.next;
            low = low.next;
        }
        return false;
    }
}
