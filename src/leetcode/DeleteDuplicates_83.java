package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO
 *
 * @author Chen
 * @date 2021/3/26 23:09
 */
public class DeleteDuplicates_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        //建立哈希表
        Set<Integer> set = new HashSet<>();
        ListNode temp = new ListNode(0);
        ListNode pre = temp;
        temp.next = head;
        while(true) {
            if(pre.next == null) {
                break;
            }
            if(!set.contains(pre.next.val)) {
                set.add(pre.next.val);
                pre = pre.next;
            } else {
                pre.next = pre.next.next;
            }
        }
        return temp.next;
    }
}
