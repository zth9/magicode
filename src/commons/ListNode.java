package commons;

/**
 * 链表节点
 * @author: theTian
 * @date: 2020/9/27 20:12
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x){
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
