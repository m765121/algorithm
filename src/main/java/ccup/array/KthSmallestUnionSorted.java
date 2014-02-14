package ccup.array;


/*
http://www.careercup.com/question?id=15192666
Given two sorted arrays A, B of size m and n respectively. 
Find the k-th smallest element in the union of A and B. You can assume that there are no duplicate elements.


a = {1, 3, 6} b = {4, 5, 6} k = 3 -> answer is 3




*/
public class KthSmallestUnionSorted {

	
	
	/*
		variant of MedianTwoSortedArrays.java
	 */	
	public static int findKth(int arr1[], int arr2[], int left, int right, int k) {
		if(left > right) {
			return findKth(arr2, arr1, 0, arr2.length - 1, k);
		} else {
			int i = (left + right) / 2;
			
			int y = k - i - 1;
			int y1 = y - 1;
			
			int l2 = arr2.length - 1;
			
			if(i >= k || (y >= 0 && y <= l2 && arr1[i] > arr2[y])) { // if i is >= k (we use >= instead of 0 since arrays are zero indexed) elements don't bother 
				return findKth(arr1, arr2, left, i-1, k);
			} else if(y1 > l2 || (y1 >= 0 && arr1[i] < arr2[y1])) { // if the length of y2 is greater than the length of l2 we must increase since there is no way for i to be the kth
				return findKth(arr1, arr2, i+1, right, k);
			} else 
				return arr1[i];
		}		
	}
	
	public static void main(String[] args) {
		int arr2[] = { 1 };
		int arr1[] = { 4, 5, 10, 300, 500};
		System.out.println(findKth(arr1, arr2, 0, arr1.length - 1, 5));		
	}

}
