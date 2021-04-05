package practice.again.jz;

import java.util.Stack;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/5 20:32
 */
public class ReversePrint_6 {

    public int[] reversePrint(ListNode head) {
        // 用栈实现“后进先出”
        // 将每个链表节点逐个入栈，再依次弹出

        // 特殊情况
        if (head == null) {
            return new int[0];
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        int len = 0;
        while (node != null) {
            stack.push(node);
            node = node.next;
            len++;
        }
        int[] arr = new int[len];
        int index = 0;
        while (!stack.isEmpty()) {
            arr[index++] = stack.pop().val;
        }
        return arr;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}