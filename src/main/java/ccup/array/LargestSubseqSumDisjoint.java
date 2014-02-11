package ccup.array;
/*
http://www.careercup.com/question?id=23594662

Given a sequence of numbers A(1) ..A(n), find the continuous subsequenceA(i)..A(j) 
for which the sum of elements is maximum. 

condition: we should not select two contiguous numbers
*/
public class LargestSubseqSumDisjoint {
	
	/*

	10, 11, 13, 15, 20, 300

	This is similar to maximum contiguous subarray but we need to account
	for different scenarios 
	
	let a[i] represent the max sum including that element from 0..i
	then a[i] = max { a[i], a[i-2] + a[i] , a[i-3] + a[i] } the two latter cases ensures that the entire array i-1 is covered  
	 */
	
	public static int max(int in[]) {

		int maxArr[] = new int[in.length];
		int max = in[0];
		maxArr[0] = max;

		for(int i = 1; i < in.length; i++) {
			maxArr[i] = in[i];
			
			if((i-2) >= 0) {
				maxArr[i] = Math.max(maxArr[i], in[i] + maxArr[i-2]);
				
				if((i-3) >= 0) {
					maxArr[i] = Math.max(maxArr[i], in[i] + maxArr[i-3]);
				}
			}
			
			max = Math.max(max, maxArr[i]);
		}
		
		return max;
	}
	
	
	
	
	public static void main(String... args) {
		int in[] = {10, 11, 13, 15, 20, 300};
		System.out.println(max(in));
		int in2[] = { -1, -3, 1, 3, -3, 5, 10 };
		System.out.println(max(in2));
	}
	

}
