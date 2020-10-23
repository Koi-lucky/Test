package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome_234 {

    /**
     * 思路分析：线性表 + 双指针
     * 1.将链表存储在一个线性表中
     * 2.利用线性表的索引进行操作 —— 也就是判断是否是回文
     * 3.双指针，从两边向中间进行遍历，首尾指针所指向的结点进行比较
     */
    @Test
    public void isPalindrome(ListNode head) {
        // 特殊情况判断
        if (head == null || head.next == null) {
            System.out.println(true);
        }
        // 1.将链表存储在一个线性表中
        List<Integer> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        // 2.利用线性表的索引进行操作 —— 也就是判断是否是回文
        // 3.双指针，从两边向中间进行遍历，首尾指针所指向的结点进行比较
        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if ( ! list.get(i).equals(list.get(j))) {
                System.out.println(false);
            }
        }
        System.out.println(true);
    }
}
