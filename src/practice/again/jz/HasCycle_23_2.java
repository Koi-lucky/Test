package practice.again.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/6 17:28
 */
public class HasCycle_23_2 {

    public ListNode detectCycle(ListNode head) {
        // 1.判断链表是否有环，若有环，则进行下一步；r若无环，则直接退出
        // 2.判断环中的节点数count，根据环中的节点数进行【双指针解法——找寻环的入口】
        // 3.已知环中的节点数，【双指针法】 —— 一个指针先走count步，然后两个指针在同时向前，走到第一个相同的结点，就是环的入口

        // 特殊情况判断
        if (head == null || head.next == null) {
            return null;
        }
        /*
        // 以下代码会超时！！！！

        if (!hasCycle(head)) {
            return null;
        }
        // 判断环中的节点数
        int count = countNode(head);
        // 找寻环的入口
        ListNode fast = head, low = head;
        for (int i = 0; i < count; i++) fast = fast.next;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return fast;
        */

        ListNode fast = head, low = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (fast == low) {
                // 如果low==fast，说明存在环
                // 此时要找到环的入口
                // 重新定义一个指针从链表的头部开始遍历 —— 直到他和low指针相遇，则表示环的入口节点找到了
                ListNode node = head;
                while (node != low) {
                    node = node.next;
                    low = low.next;
                }
                return node;
            }
        }
        return null;

    }

    /*
    // 以下代码会超时！！！


    // 编写一个函数，用于判断链表是否有环
    public boolean hasCycle(ListNode head) {
        // 快慢指针 —— 快指针一次走两步，慢指针一次走一步，如果两指针相遇，则说明链表有环，否则无环

        // 特殊情况判断
        if (head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode low = head;
        while (fast != null && fast.next != null && low != null) {
            if (fast == low) return true;
            fast = fast.next.next;
            low = low.next;
        }
        return false;
    }

    // 统计环的节点个数
    public int countNode(ListNode head) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }
    */
}
