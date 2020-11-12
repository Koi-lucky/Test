package niuke.jz;

import org.junit.Test;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/11 22:35
 */
public class FindKthToTail_14 {

    public ListNode FindKthToTail(ListNode head, int k) {
        // 特殊情况判断
        if (head == null || k <= 0) {
            return null;
        }
        // 快慢指针解法
        // 定义两个指针，快指针先走k-1步，慢指针再开始和快指针一起走，这样的话，等快指针到达链表末尾的时候，慢指针所指向的位置就是链表倒数第k个结点

        // 1.定义一个指针操作链表
        ListNode node = head;
        // 2.定义两个指针
        ListNode fast = node;
        ListNode low = node;
        // 3.快指针先走
        for (int i = 0; i < k - 1; i++) {
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next;
            }
        }
        // 4.慢指针和快指针一起走
        while (fast.next != null) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}
