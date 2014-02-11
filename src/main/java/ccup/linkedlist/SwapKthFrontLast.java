package ccup.linkedlist;

import ccup.linkedlist.util.Node;

/*
http://www.careercup.com/question?id=13575664

Given a singly link list and a number 'K', swap the Kth node from the start with the Kth node from the last.
Check all the edge cases. 

Sample Input: 1->2->3->4->5->6->7->8 and K = 3 
Sample Output : 1->2->6->4->5->3->7->8 

1-2-3-4-5

Sample Input: 1->2->3->4->5->6->7->8 and K = 10 
Sample Output: print error "LIST IS OF LESSER SIZE".

*/
public class SwapKthFrontLast {

	
	public static void swap(Node<Integer> head, int k) {
		Node<Integer> front = head;
		
		int count = 1;
		
		while(count < k) {
			if(front.next == null)
				throw new RuntimeException("LIST IS OF");
			
			front = front.next;
			count++;
		}
		
		
		
		Node back = front;
		Node<Integer> trav = head;
		
		while(back.next != null) {
			trav = trav.next;
			back = back.next;
		}
		
		
		int temp = front.val;
		front.val = trav.val;
		trav.val = temp;
		
	}
	
	public static void main(String[] args) {
		Node<Integer> head = new Node<Integer>(1);
		head.next(2).next(3).next(4).next(5).next(6).next(7).next(8);

		swap(head, 3);
		
		
		System.out.println(head);
		
	}

}
