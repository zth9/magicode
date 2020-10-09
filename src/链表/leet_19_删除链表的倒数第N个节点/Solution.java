package 链表.leet_19_删除链表的倒数第N个节点;

import commons.ListNode;

/**
 * @author: theTian
 * @date: 2020/10/9 19:04
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
            if (fast == null) return head.next;
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
