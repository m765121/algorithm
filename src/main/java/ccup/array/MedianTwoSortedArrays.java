package ccup.array;
/*
http://www.careercup.com/question?id=2461696 
Find median of two sorted arrays.

*/

public class MedianTwoSortedArrays {
	
	/*
 		input - arr1 and arr2
		
		assume arr1[i] is the median
		
		then arr1[i] > arr1[0...i-1] 
		
		then it must be greater than (l1 + l2) / 2 -  i - 1 of the elements in arr2 call this y; y is the greatest element in arr2 where arr1[i] >= arr2[y]
	
		if arr1[i] >= arr2[y] && arr1[i] <= arr[y+1] then it is the median otherwise
		
		if is greater than arr2[y+1] then the median exists somewhere between 0... i-1
		otherwise median is somewhere i+1
		
		[x,x,x,x] [y,y,y,y,y,y]  
		
		          m   
		y,y,y,y,y,y,x,x,x,x upper bound for y is n/2
		
		or 
		        m
		x,x,x,x,y,y,y,y,y,y lower bound for y is n/2 - l1
		
	 */
	
	public static int median(int arr1[], int arr2[], int left, int right) {
		if(left > right) {
			return median(arr2, arr1, 0, arr2.length - 1); // can optimize using bounds stated in comments
		} else {
			int l1 = arr1.length - 1;
			int l2 = arr2.length - 1;
			
			int m = (l1 + l2) / 2;
			int i = (left + right) / 2;
			
			int y = m - i - 1 ;
			int y1 = y + 1;
			
			if(y > l2 || (y >= 0 && arr1[i] < arr2[y])) { 
				return median(arr1, arr2, i+1, right);
			} else if(y1 <= l2 && arr1[i] > arr2[y1]) {
				return median(arr1, arr2, left, i-1);
			} else
				return arr1[i];
		}
	}
	
	public static void main(String... args) {
		int arr2[] = { 1 };
		int arr1[] = { 4, 5, 10, 300, 500};
		
		System.out.println(median(arr1, arr2, 0, arr1.length - 1));

	}

}
