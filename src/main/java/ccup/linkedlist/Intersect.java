package ccup.linkedlist;

import ccup.linkedlist.util.Node;

/*http://www.careercup.com/question?id=7578666

1. How to find whether two link-lists intersect each other or not? 
If yes find intersection point.
*/

public class Intersect {
	
	/*            
	     	      5
    	    	   \
			1 - 2 - 3 - 4 - null
  
   */
	
	public static Node<Integer> findIntersect(Node<Integer> l1, Node<Integer> l2 ) {
		// assuming at the merge point, they dont diverge, 
		// find difference between length then compare each node... O(n)
		
		int l1size = Node.getLength(l1); // assume l1 >= l2
		int l2size = Node.getLength(l2);
		
		int diff = l1size - l2size;
		
		Node l1trav = l1;
		
		while(diff > 0) {
			l1trav = l1trav.next;
			diff--;
		}
		
		Node l2trav = l2;
			
		while(l2trav != null) {
			if(l1trav == l2trav) 
				return l1trav;
			else {
				l1trav = l1trav.next;
				l2trav = l2trav.next;
			}
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		Node<Integer> l1 = new Node<Integer>(1);
		Node intersect = l1.next(2).next(3);
		intersect.next(4);
		
		Node<Integer> l2 = new Node<Integer>(5);
		l2.next = intersect;
		
		System.out.println(findIntersect(l1, l2).val);
	}
}
