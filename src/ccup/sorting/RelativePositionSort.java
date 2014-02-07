package ccup.sorting;

import java.util.Arrays;
/*
http://www.careercup.com/question?id=5201559730257920
Give you an array which has n integers,it has both positive and negative integers.Now you need sort this array in a special way.After that,the negative integers should in the front,and the positive integers should in the back.Also the relative position should not be changed. 
eg. -1 1 3 -2 2 ans: -1 -2 1 3 2. 
o(n)time complexity and o(1) space complexity is perfect.
*/


public class RelativePositionSort {

	// O(nlogn) time - o(1) space
	public static void sort(int arr[], int start, int end) {
		if(start >= end) 
			return;

		int mid = (end - start) / 2 + start;
		sort(arr, start, mid);
		sort(arr, mid + 1, end);

		_sort(arr, start, end, mid);
	}

	private static void _sort(int arr[], int start, int end, int boundary) {
		int positiveIndex = -1;

		for(int i = start; i <= boundary; i++) {
			if(arr[i] >= 0) {
				positiveIndex = i;
				break;
			}
		}

		if(positiveIndex >= 0) {
			int negativeIndex = -1;

			for(int i = boundary + 1; i <= end; i++) {
				if(arr[i] < 0) {
					negativeIndex = i;
				}
			}

			if(negativeIndex >= 0) {
				_reverse(arr, positiveIndex, boundary);
				_reverse(arr, boundary+1, negativeIndex);
				_reverse(arr, positiveIndex, negativeIndex);
			}
		}
	}

	public static void _reverse(int arr[], int start, int end) {
		while(start < end)
		{
			int temp = arr[start];   
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}	
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, -5, -4, -3, -2, -1};
		
		sort(arr, 0, arr.length - 1);
		
		System.out.println(Arrays.toString(arr));
	}

}
