package practice.jzOffer;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/5/31 22:03
 */
public class FindKthToTail_14 {

    public static ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        // 快慢指针解决

        // 特殊情况1
        if (pHead == null || k <= 0) {
            return null;
        }
        ListNode fast = pHead, low = pHead;
        int m = k;
        // 快慢指针先处于同一位置处
        // 快指针先走k-1步，然后快慢指针一起走，知道快指针到达链表的末尾位置
        // 如果快指针已经到达链表的末尾位置，但是还没够k步，此为特殊情况2
        for (int i = 0; i < k - 1; i++) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null && low.next != null) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}


class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
   }
 }