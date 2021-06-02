/**

 */

package Medium;

public class RemoveDuplicatesFromUnsortedLinkedList {
    public ListNode deleteDuplicatesUnsorted(ListNode head) { 

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = head;
        Map<Integer, Integer> count = new HashMap<>();
        
        while(cur != null) {
            count.put(cur.val, count.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }

        ListNode pre = dummy;
        cur = pre.next;
        while(cur != null) {
            while(cur != null && count.get(cur.val) > 1)
                cur = cur.next;
            pre.next = cur;
            pre = cur;
            if(cur != null)
                cur = cur.next;
        }
        return dummy.next;
    }
}