package 链表.leet_141_环形链表.双指针;

import commons.ListNode;

/**
 * set可以解决链表有环的问题 但是空间复杂度为O(n)
 * 可以通过双指针移动将空间复杂度降为O(1)
 * @author: theTian
 * @date: 2020/9/28 21:11
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next==null){ // 特判
            return false;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while (slow != fast){ // 如果快慢指针发生碰撞 表示链表有环
            slow = slow.next; // 慢指针移动一个节点
            if (fast==null || (fast = fast.next)==null){ // 快指针第一次移动
                return false;
            }
            fast = fast.next; // 快指针第二次移动
        }
        return true;
    }
}
