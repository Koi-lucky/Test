package niuke.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/11 22:47
 */
public class ReverseList_15 {

    public ListNode ReverseList(ListNode head) {
        // 链表反转
        // 定义三个空间分别存储当前遍历到的节点、当前节点的前一个节点、当前节点的后一个节点，新链表的表头即为原始链表的末尾节点

        // 特殊情况判断
        if (head == null) {
            return null;
        }
        // 1.定义一个空间用于存储新链表的头结点
        ListNode reversedHead = null;
        // 2.定义一个指针用于操作链表
        ListNode node = head;
        // 3.定义一个空间用于存储当前遍历到的节点的前一个节点
        ListNode preNode = null;
        // 4.遍历链表
        while (node != null) {
            // 4.1 定义一个空间用于存储当前遍历到的节点的下一个结点
            ListNode nextNode = node.next;
            // 4.2 如果当前节点指向空，则表示已经到了原始链表的末尾节点，也就是新链表的头结点
            if (nextNode == null) {
                reversedHead = node;
            }
            // 4.3让当前节点的指针 指向 她的前一个节点
            node.next = preNode;
            // 4.4 存储当前节点，以及当前下一个节点
            preNode = node;
            node = nextNode;
        }
        return reversedHead;
    }
}
