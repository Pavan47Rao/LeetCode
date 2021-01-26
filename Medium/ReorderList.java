/**
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */

package Medium;
import java.util.*;

public class ReorderList {

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        
        if(head == null)
            return;
        
        Deque<ListNode> nodeQ = new LinkedList<ListNode>();
        ListNode temp = head;
        while(temp != null) {
            nodeQ.addLast(new ListNode(temp.val, null));
            temp = temp.next;
        }
        
        temp = nodeQ.pollFirst();
        ListNode prev = temp;
        boolean flag = true;
        while(!nodeQ.isEmpty()) {
            prev.next = flag ? nodeQ.pollLast() : nodeQ.pollFirst();
            flag = !flag;
            prev = prev.next;
        }
        head.next = temp.next;
    }
}
