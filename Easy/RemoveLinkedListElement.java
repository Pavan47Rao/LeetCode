package Easy;

/**
 * 
 * Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */

public class RemoveLinkedListElement {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode duplicateHead = new ListNode(0);
        duplicateHead.next = head;
        ListNode cur = head, prev = duplicateHead;
        while(cur != null) {
            if(cur.val == val)
                prev.next = cur.next;
            else
                prev = cur;
            cur = cur.next;
        }
        return duplicateHead.next;
    }
}
