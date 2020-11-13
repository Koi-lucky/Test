package niuke.jz;

/**
 * TODO
 *
 * @author Chen
 * @date 2020/11/12 22:27
 */
public class Merge_16 {

    public ListNode Merge(ListNode list1,ListNode list2) {
        // 特殊情况判断
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // 定义一个空结点，用于存储指向遍历到的根结点
        ListNode mergedHead = null;
        // 如果list该节点的值 < list2 该节点的值，此时，值较小的做根节点
        if (list1.val < list2.val) {
            // list1的该节点做根节点
            mergedHead = list1;
            mergedHead.next = Merge( list1.next, list2);// 向list1的下一个结点进行递归查找
        } else {
            // list2的该节点做根节点
            mergedHead = list2;
            mergedHead.next = Merge( list1, list2.next);// 向list2的下一个结点进行递归查找
        }
        return mergedHead;
    }
}
