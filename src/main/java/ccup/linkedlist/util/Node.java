package ccup.linkedlist.util;

public class Node<T> {
	public Node<T> next;
	public T val;
	
	public Node(Node<T> next, T val) {
		super();
		this.next = next;
		this.val = val;
	}
	
	public Node(T val) {
		super();
		this.val = val;
	}



	public Node next(T val) {
		Node newNode = new Node(val);
		next = newNode;
		return newNode;
	}
	
	public static int getLength(Node<?> head) {
		Node<?> traverse = head;
		int count = 0;
		
		while(traverse != null) {
			count++;
			traverse = traverse.next;
		}
		
		return count;
	}

	
	public String toString() {
		String s = val.toString();
		
		Node<?> t = next;
		while(t != null) {
			s += " -> "+ t.val.toString();
			t = t.next;
		}
		
		return s;
	}
}
