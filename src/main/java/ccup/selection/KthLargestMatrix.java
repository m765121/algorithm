package ccup.selection;

/* 
http://www.careercup.com/question?id=6335704

Given a N*N Matrix. 
All rows are sorted, and all columns are sorted. 
Find the Kth Largest element of the matrix.

*/


public class KthLargestMatrix {

	
	// kth largest must lie somewhere between [0...k-1][0...k-1] 
	// k^2 log k space O(k)
	public static int findKthLargest(int k, int input[][]) {
		// idea use max heap of size k
		// add all elements in the k^2 section of the matrix; each time removing the max
		// at the end the top of the heap should contain the kth largest element
		return -1;
	}
	
	public static void main(String... args) {
		int mat[][] = {  
				{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
		};
	}
	
}
