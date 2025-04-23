package 链表.offer_22_链表中倒数第k个节点.循环链表;

import commons.ListNode;

/**
 * @author: theTian
 * @date: 2020/9/29 12:18
 */
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head==null || head.next==null){
            return head;
        }
        ListNode cycleList = new ListNode(-1);
        ListNode cur = cycleList;
        while (k>1){
            cur.next = new ListNode(-1);
            cur = cur.next;
            k--;
        }
        cur.next = cycleList; // 构建成循环链表
        while (true){
            cur.val = head.val;
            if (head.next == null){ // 遍历到最后一个节点
                ListNode tmp = cur;
                cur = cur.next; // cur指向倒数第k个节点
                tmp.next = null; // 消除环
                break;
            }
            cur = cur.next;
            head = head.next;
        }
        return cur;
    }
}
