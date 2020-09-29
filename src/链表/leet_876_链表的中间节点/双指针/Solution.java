package 链表.leet_876_链表的中间节点.双指针;

import commons.ListNode;

/**
 * @author: theTian
 * @date: 2020/9/29 13:25
 */
public class Solution {
    /**
     * @param head
     * @return 链表的中间节点
     */
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            return slow;
        } else {
            return slow.next;
        }
    }
}
