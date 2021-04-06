package practice.again.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/6 19:44
 */
public class ReverseList_24 {

    public ListNode reverseList(ListNode head) {
        // 1.迭代解法 —— 定义三个指针，用于存储当前节点、当前节点的前驱结点、当前结点的后继结点
        // 2.递归解法

        /*
        // 1.迭代法

        // 特殊情况判断
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preNode = null, node = head;
        while (node != null) {
            ListNode nextNode = node.next;
            node.next = preNode;
            preNode = node;// 更新当前的前驱结点
            node = nextNode;// 更新当前的当前节点
        }
        return preNode;*/


        // 2.递归解法
        if (head == null || head.next == null) {
            return head;
        }
        return listNodeReverse( null, head);// 注意pre前驱结点的初始值为null,cur当前节点的初始值为head
    }

    // 反转链表的程序
    public ListNode listNodeReverse (ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode node = cur.next;
        cur.next = pre;
        return listNodeReverse( cur, node);// 注意更新pre前驱结点、以及当前节点cur
    }
}
