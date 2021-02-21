package LinkedList;

public class DoublyLinkedList {
    int nodeCount;
	public Node head;
	public Node tail;
	
	public void addToTail(Node node) {
		
		if(head == null && tail == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		nodeCount++;
	}
	
	public void removeTail() {

		if(tail == null) {
			return;
		}
			
		Node newTail = tail.prev;

		if(newTail != null) {
			tail.prev = null;
			newTail.next = null;
			tail = newTail;
		} else {
			tail = null;
			head = null;
		}
		nodeCount--;
	}
	
	public void addToHead(Node node) {
		
		if(head == null && tail == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head.prev = node;
			head = node;
		}
		nodeCount++;
	}
	
	public void removeHead() {

		if(head == null) {
			return;
		}
			
		Node newHead = head.next;

		if(newHead != null) {
			head.next = null;
			newHead.prev = null;
			head = newHead;
		} else {
			tail = null;
			head = null;
		}
		nodeCount--;
	}
	
	@Override
	public String toString() {
		
		if(head == null && tail == null) return "";
		
		Node current = head;
		StringBuilder sb = new StringBuilder();
		while(current != null) {
			sb.append(current.value+"->");
			current = current.next;
		}
		sb.delete(sb.length()-2, sb.length());
		
		sb.append("\n");
		
		current = tail;
		StringBuilder sb2 = new StringBuilder();
		
		while(current != null) {
			sb2.insert(0, "<-" + current.value);
			current = current.prev;
		}
		sb2.delete(0, 2);
		sb.append(sb2);
		
		return sb.toString();
    }
    
    public static void main(String[] args) {
		
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(4);
		
		DoublyLinkedList li = new DoublyLinkedList();
		li.addToTail(first);
		li.addToHead(second);
		li.removeTail();
		li.removeTail();
		li.removeTail();
		li.addToTail(third);
		li.addToHead(fourth);
		li.removeTail();
		li.removeTail();
		li.addToTail(third);
		li.addToHead(fourth);
		li.removeHead();
		
		System.out.print(li);
	}
}
