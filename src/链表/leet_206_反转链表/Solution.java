package 链表.leet_206_反转链表;

import commons.ListNode;
/**
 * @author: theTian
 * @date: 2020/9/27 20:50
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        System.out.println(showList(l1));
        ListNode head = reverseList(l1);
        System.out.println(showList(head));
    }

    public static ListNode reverseList(ListNode head){
        if (head == null || head.next==null){ // 特判
            return head;
        }
        ListNode pre = null;
        ListNode next = head.next;
        while (next!=null){
            head.next = pre;
            pre = head;
            head = next;
            next = next.next;
        }
        head.next = pre;
        return head;
    }

    public static String showList(ListNode listNode){
        if (listNode==null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ListNode head = listNode;
        while (head!=null){
            sb.append(head.val).append("-->");
            head = head.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
