package practice.again.leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/1 21:35
 */
public class HasCycle_141 {

    public boolean hasCycle(ListNode head) {
        // 快慢指针解决
        // 让快指针一次走两个节点，慢指针一次走一个节点
        // 如果两个指针相遇，则说明有环；否则无环


        // 特殊情况判断
        if (head == null) {
            return false;
        }
        ListNode low = head, fast = head.next;
        while (low != null && fast != null && fast.next != null) {
            if (fast == low) {
                return true;
            }
            fast = fast.next.next;
            low = low.next;
        }
        return false;
    }
}


class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}