package practice.again.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/6 15:59
 */
public class MergeTwoLists_25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 递归解法 —— 每次取两个链表中较小的那个首节点作为此次的头结点，将每次的头结点进行连接，就会得到一个递增的链表

        // 特殊情况判断
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode mergeHead = null;
        if (l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}
