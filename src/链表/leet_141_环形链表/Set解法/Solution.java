package 链表.leet_141_环形链表.Set解法;

import commons.ListNode;

import java.util.HashSet;

/**
 * @author: theTian
 * @date: 2020/9/28 21:02
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l = null;
        System.out.println(new Solution().hasCycle(l));
    }

    /**
     * @param head 链表头节点
     * @return 如果有环返回true否则返回false
     */
    public boolean hasCycle(ListNode head) {
        if (head==null){
            return false;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){ // 从头节点开始向后遍历
            if (set.contains(head)){ // set中已包含当前节点 表示有环
                return true;
            }
            set.add(head); // 不碰撞就添加
            head = head.next;
        }
        return false;
    }
}
