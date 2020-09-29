package 链表.leet_21_合并两个有序链表.暴力;

import commons.ListNode;

/**
 * @author: theTian
 * @date: 2020/9/29 10:05
 */
public class Solution {
    /**
     * @param l1 有序链表l1
     * @param l2 有序链表l2
     * @return 合并两个有序链表后的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1); // 引入哨兵节点
        ListNode pr = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pr.next = l1;
                l1 = l1.next;
            } else {
                pr.next = l2;
                l2 = l2.next;
            }
            pr = pr.next; // 链尾指针移动
        }
        pr.next = l1!=null?l1:l2; // 接上剩余的节点
        return res.next;
    }
}
