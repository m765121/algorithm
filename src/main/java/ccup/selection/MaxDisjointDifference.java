package ccup.selection;
/*
http://www.careercup.com/question?id=19286747

Given an array of integers. Find two disjoint contiguous sub-arrays such that the absolute difference between the sum of two sub-array is maximum. 
* The sub-arrays should not overlap. 

eg- [2 -1 -2 1 -4 2 8] ans - (-1 -2 1 -4) (2 8), diff = 16 
*/
public class MaxDisjointDifference {

	
	
	/* need to find section with min and section with max while being disjoint
	 two arrays lr represents max minimum  rl represents max from right to left
		
	lr[i] = min { input[i], lr[i] + lr[i-1] }	
		
	
	*/
	public static int maxDisjoint(int input[]) {
		int lr[] = new int[input.length];
		int rl[] = new int[input.length];
		
		lr[0] = input[0];
		rl[input.length - 1] = input[input.length - 1];
		
		for(int i = 1; i < input.length; i++) {
			lr[i] = Math.min(input[i], input[i] + lr[i-1]);
		}
		
		for(int i = input.length - 2; i >= 0; i--) {
			rl[i] = Math.max(input[i], input[i] + rl[i+1]); 
		}
		
		
		int maxSum = Integer.MIN_VALUE;
		
		for(int i = 0; i < input.length - 1; i++) {
			maxSum = Math.max(maxSum, Math.max(rl[i+1], Math.max(Math.abs(lr[i]), Math.abs(lr[i]) + rl[i+1])));  // account for empty set {}
		}
		
		
		return maxSum;
	}
	
	
	public static void main(String[] args) {
		
		int input[] = {2, -1, -2, -30, -4, -2, 3000};
		
		System.out.println(maxDisjoint(input));
		
	}

}
