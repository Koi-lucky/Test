package practice.again.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/5 21:02
 */
public class DeleteNode_18 {

    public ListNode deleteNode(ListNode head, int val) {
        // 特殊情况判断
        if (head == null) {
            return head;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode node = head;
        // 找到要删除的节点
        while (node.next != null && node.next.val != val) {
            node = node.next;
        }
        // 判断是不是要删除的节点，如果是则删除
        if (node.next != null) {
            node.next = node.next.next;
        }
        return head;
    }
}
