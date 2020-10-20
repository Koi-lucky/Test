package leetcode;

import org.junit.Test;

public class AddTwoNumbers_2 {

   ListNode l1 = new ListNode(243);
   ListNode l2 = new ListNode(564);


    /**
     * 思路分析：
     * 1.定义一个空的链表，并且需要定义一个空指针用于操作链表（在链表的末尾添加节点）
     * 2.定义一个临时的变量用于存储“竖向加和”的和值
     * 3.循环遍历两条已知的链表
     *      3.1 每次的和值中要加“进位”值
     *      3.2 如果是链表的第一个节点，就直接进行添加；否则的话，用指针在链表的末尾进行添加
     *      3.3 指针后移
     * 4.判断最高位是否有进位，有进位则扩充链表（即添加一个结点，节点的值为 sum/10）
     *
     */
    @Test
    public void addTwoNumbers() {
        //1.定义一个空的链表，并且需要定义一个空指针用于操作链表（在链表的末尾添加节点）
        ListNode l3 = null;
        ListNode temp = null;
        //2.定义一个临时的变量用于存储“竖向加和”的和值
        int p = 0;
        //3.循环遍历两条已知的链表
        while (l1 == null || l2 == null) {
            int i = l1 == null ? 0 : l1.val;
            int j = l2 == null ? 0 : l2.val;
            //3.1 每次的和值中要加“进位”值
            p = i + j + p / 10;
            //3.2 如果是链表的第一个节点，就直接进行添加；
            if (l3 == null) {
                l3 = new ListNode(p % 10);
                temp = l3;
            } else {
                //否则的话，用指针在链表的末尾进行添加
                temp.next = new ListNode(p % 10);
                temp = temp.next;
            }
            //3.3 指针后移
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        //4.判断最高位是否有进位，有进位则扩充链表（即添加一个结点，节点的值为 sum/10）
        if (p / 10 > 0) {
            temp.next = new ListNode(p / 10);
        }
        System.out.println(l3);
    }
}

//定义节点
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}