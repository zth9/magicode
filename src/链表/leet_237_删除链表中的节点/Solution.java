package 链表.leet_237_删除链表中的节点;

import commons.ListNode;

/**
 * @author: theTian
 * @date: 2020/9/29 11:50
 */
public class Solution {
    /**
     * 删除给定节点
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
