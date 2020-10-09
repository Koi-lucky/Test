package leetcode;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

public class DetectCycle_142 {

    /**
     * 方法：set集合
     * 思路分析：
     * 1.将所有的节点都存储在一个set集合中去
     * 2.遍历整条链表，
     *  如果有环的话，set集合会检测到，并且可以直接输出环头结点的位置，
     *  如果没有环的话，循环就会自动终止
     *
    * @param head
     */
    @Test
    public void detectCycle(ListNode head) {
        // 先判空
        if (head == null || head.next == null) {
            System.out.println(false);
        }
        // 1.将所有的节点都存储在一个set集合中去
        Set<ListNode> set = new LinkedHashSet<>();
        ListNode node = head;// 定义一个辅助指针操作链表

        // 2.遍历整条链表
        // 如果有环的话，set集合会检测到，并且可以直接输出环头结点的位置，
        // 如果没有环的话，循环就会自动终止
        while (node != null) {
            if (set.contains(node)) {
                System.out.println(node);
            }
            set.add(node);
            node = node.next;
        }
        System.out.println("no cycle");
    }
}
