package practice.again.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/6 19:27
 */
public class GetKthFromEnd_22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 双指针解法 —— 一个指针先走 k-1步，两个指针再同时走，等走到链表的终点，第二个指针所指的位置就是倒数第k个结点

        // 特殊情况判断 —— 空链表、k==0、k>链表长度
        if (head == null || k == 0) {
            return null;
        }
        ListNode first = head, two = head;

        // 第一个指针先走k-1步
        for (int i = 0; i < k; i++) {
            first = first.next;
        }
        // 两个指针再同时走
        while (first != null) {
            first = first.next;
            two = two.next;
        }
        return two;
    }
}
