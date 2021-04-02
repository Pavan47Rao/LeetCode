package Midterm;

/**
 * Time complexity = O(n+m) where n is the size of n1 and m is the size of n2
 * Space comlexity = O(1)
 */

public class ConvergingSinglyLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public static int size(ListNode listNode) {
        int count = 0;
        while(listNode != null) {
            count++;
            listNode = listNode.next;
        }
        return count;
    }

    public static boolean areConverging(ListNode n1, ListNode n2){
        int sizeOfN1 = size(n1);
        int sizeOfN2 = size(n2);
        for(int i = 0; i < Math.abs(sizeOfN1 - sizeOfN2); i++) {
            if(sizeOfN1 > sizeOfN2) {
                n1 = n1.next;
            }
            else {
                n2 = n2.next;
            }
        }

        while(n1 != null && n2 != null) {
            if(n1 == n2) {
                return true;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ConvergingSinglyLinkedList.ListNode l1 = new ConvergingSinglyLinkedList.ListNode(1);
        ConvergingSinglyLinkedList.ListNode l2 = new ConvergingSinglyLinkedList.ListNode(2);
        ConvergingSinglyLinkedList.ListNode l3 = new ConvergingSinglyLinkedList.ListNode(3);
        ConvergingSinglyLinkedList.ListNode l4 = new ConvergingSinglyLinkedList.ListNode(4);
        ConvergingSinglyLinkedList.ListNode l5 = new ConvergingSinglyLinkedList.ListNode(5);
        ConvergingSinglyLinkedList.ListNode l6 = new ConvergingSinglyLinkedList.ListNode(6);
        ConvergingSinglyLinkedList.ListNode l7 = new ConvergingSinglyLinkedList.ListNode(7);
        ConvergingSinglyLinkedList.ListNode l8 = new ConvergingSinglyLinkedList.ListNode(8);
        
        l1.next = l2;
        l2.next = l7;
        l7.next = l8;

        l3.next = l4;
        l4.next = l5;
        // l5.next = null; Uncomment for diverging linked list
        l5.next = l6; // Comment for diverging linked list
        l6.next = l7;
        l7.next = l8;

        System.out.println(areConverging(l1, l3)); // converging linked lists
        // System.out.println(areConverging(l1, l3)); //diverging linked lists
    }


}
