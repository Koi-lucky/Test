package practice.leetCode;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/20 21:17
 */
public class HasCycle_141 {

    public boolean hasCycle(ListNode head) {
        // 特殊情况判断
        if (head == null) {
            return false;
        }
        // 双指针解法 —— 快慢指针，让快指针先走一步，紧接着慢指针再跟随快指针一起走(快指针走两步，慢指针走一步)，如果快慢指针能相遇则说明有环
        ListNode fast = head.next;
        ListNode low = head;
        while (fast != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                return true;
            }
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