package practice.again.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/4/6 15:49
 */
public class GetIntersectionNode_52 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 从链表的末尾进行遍历，遍历到最后一个相等的结点，就是第一个公共节点
        // 1.栈 —— “先进后出”，需要额外的空间复杂度
        // 2.双指针解法 —— 求出两个链表的长度，取两个链表的差值K，一个指针先走K步，然后两个指针再同时走，求得的第一个相等的节点就是第一个公共节点

        // 特殊情况判断
        if (headA == null || headB == null) {
            return null;
        }
        ListNode aNode = headA;
        ListNode bNode = headB;
        int aLen = 0, bLen = 0;
        // 先求两个链表的长度
        while (aNode != null) {
            aLen++;
            aNode = aNode.next;
        }
        while (bNode != null) {
            bLen++;
            bNode = bNode.next;
        }
        int subLen = Math.abs(aLen - bLen);
        ListNode longHead = headA;
        ListNode shortHead = headB;
        // 让快指针先走subLen步,然后两个指针再同时走
        if (aLen < bLen) {
            longHead = headB;
            shortHead = headA;
        }
        for (int i = 0; i < subLen; i++) {
            longHead = longHead.next;
        }
        while (longHead != null && shortHead != null && longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        // 得到了第一个公共节点
        ListNode firstCommonNode = longHead;
        return firstCommonNode;
    }
}
