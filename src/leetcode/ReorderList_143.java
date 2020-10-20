package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReorderList_143 {

    @Test
    public void reorderList(ListNode head) {
        // 特殊情况判断
        if (head == null) {
            return;
        }
        // 将链表存入到线性表中
        List<ListNode> list = new ArrayList<>();
        // 定义一个指针操作链表
        ListNode node = head;
        // 将链表中的结点逐个存入线性表中
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        // 定义双指针，双指针指向的结点进行交换
        int left = 0, right = list.size() - 1;
        while (left < right) {
            // 交换两个指针指向的节点的值
            // 让左指针的next域指向右指针所指向的节点
            list.get(left).next = list.get(right);
            // 左指针右移
            left++;
            if (left == right) {
                break;
            }
            // 让右指针的next域指向左指针所指向的节点
            list.get(right).next = list.get(left);
            // 右指针左移
            right--;
        }
        // 让最后一个节点的next域指向null
        list.get(left).next = null;
    }
}
