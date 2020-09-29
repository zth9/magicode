package 链表.offer_22_链表中倒数第k个节点.双指针;

import commons.ListNode;

/**
 * @author: theTian
 * @date: 2020/9/29 12:40
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode q = head;
        while (k>0){ // q先往前移动k步
            q = q.next;
            k--;
        }
        while (q!=null){
            head = head.next;
            q = q.next;
        }
        return head;
    }
}
