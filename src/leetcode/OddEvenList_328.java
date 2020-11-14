package leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/13 22:07
 */
public class OddEvenList_328 {

    public ListNode oddEvenList(ListNode head) {
        // 特殊情况判断
        if (head == null) {
            return null;
        }
        // 1.定义快慢指针，用于指向奇数或者偶数节点，
        ListNode node = head.next;// 操作链表
        ListNode fast = head;// 指向奇数结点
        ListNode low = node;// 指向偶数节点
        // 2.遍历链表
        // 3.通过两个指针的指向，将链表分为两部分，一部分为奇数链表，一部分为偶数链表
        while (low != null && low.next != null) {
            // 奇数结点的下一个结点 是 偶数节点的下一个节点
            fast.next = low.next;
            fast = fast.next;
            // 偶数节点的下一个节点 是 奇数结点的下一个节点
            low.next = fast.next;
            low = low.next;
        }
        // 4.将奇数链表与偶数链表连接起来
        fast.next = node;
        return head;
    }
}
