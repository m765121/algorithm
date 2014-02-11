package ccup.array;

import java.util.Arrays;

/*
http://www.careercup.com/question?id=23039666

Maximum value Continuous Subsequence: 
Given array A[n] find continuous subsequence a[i]..a[j] for which sum of elements in the subsequence is maximum. 

Ex: {-2, 11, -4, 13, -5, -2} --> 11 - 4 +13 = 20 
{1, -3, 4, -2, -1, 6} --> 4 -2 -1 +6 = 7 
*/

public class MaxSumSubarray {

	public static int max(int in[]) {
		int max = in[0];
		int prev = in[0];
		
		for(int i = 1; i < in.length; i++) {
			int withPrev = in[i] + prev;
			prev = Math.max(in[i], withPrev);
			max = Math.max(max, prev);
		}
		
		return max;
		
	}
	
	public static void main(String[] args) {
		int in[] = { -2, 11, -4, 13, -5, -2};
		System.out.println(max(in));
	}
}
