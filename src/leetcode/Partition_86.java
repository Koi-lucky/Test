package leetcode;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/1/3 22:36
 */
public class Partition_86 {

    public ListNode partition(ListNode head, int x) {
        // 分别维护两个链表，一个smart指向的都是小于x的结点，一个large指向的是所有大于等于x的结点，再将small的尾结点的next域指向large的头结点，即为所求的链表
        // 分别在两条链表的头结点之前设置一个哑结点，哑结点的next域分别指向两条链表的头结点
        ListNode small = new ListNode(0);
        ListNode smallHead = small;// small链表的哑结点
        ListNode large = new ListNode(0);
        ListNode largeHead = large;// large链表的哑结点
        while (head != null) {
            // 遍历链表
            // 判断当前指向的结点是否 小于 x,若小于，则让small链表指针指向他
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                // 否则的话，让large链表的指针指向他
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        // 操作的是原链表，必须将large尾结点的next域，让他指向空
        large.next = null;
        // 将两条链表连接起来，也就是将small的next域与large的头结点连接起来
        small.next = largeHead.next;
        return smallHead.next;
    }
}
