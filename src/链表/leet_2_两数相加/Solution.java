package 链表.leet_2_两数相加;

import commons.ListNode;

/**
 * @author: theTian
 * @date: 2020/9/27 20:10
 */
public class Solution {
    /**
     * @param l1 一个链表
     * @param l2 另一个链表
     * @return 一个新链表 值为l1与l2的和
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode res = new ListNode(-1);
        ListNode p3 = res;
        int add = 0;
        while (p1 != null || p2 != null) {
            int sum = 0;
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            sum += add;
            if (sum > 9){
                add = 1;
                res.next = new ListNode(sum % 10);
            }else {
                add = 0;
                res.next = new ListNode(sum);
            }
            res = res.next;
        }
        if (add == 1){
            res.next = new ListNode(1);
        }
        return  p3.next;
    }
}
