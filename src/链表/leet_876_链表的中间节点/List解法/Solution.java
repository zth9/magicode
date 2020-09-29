package 链表.leet_876_链表的中间节点.List解法;

import commons.ListNode;

import java.util.ArrayList;

/**
 * @author: theTian
 * @date: 2020/9/29 12:48
 */
public class Solution {
    /**
     * @param head
     * @return 中间节点
     */
    public ListNode middleNode(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (head!=null){
            list.add(head);
            head = head.next;
        }
        return list.get(list.size()/2);
    }
}
