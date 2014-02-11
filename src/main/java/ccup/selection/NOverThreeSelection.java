package ccup.selection;


/*http://www.careercup.com/question?id=14099679

Design an algorithm that, given a list of n elements in an array, finds all the elements that appear more than n/3 times in the list. The algorithm should run in linear time ( n >=0 ) */

public class NOverThreeSelection {

	
	/*
		{1, 2, |3, 1,| 4, 1} 
		
		length of array = 6
		target occurrence =  > 2
		count of 1 is 3 so it is candidate
		
		maintain a count of current seen element scan left to right..
		
		1 -> count is  1
		2 -> 1 count is now 0; 2 count is 1
		3 -> ... same
		1 -> .. same
		4 -> same... 
		1 -> one is a candidate
		
		a case where this doesn't work...is when the candidate occurs in 1/3...2/3 of array
		{1, 2,| 1, 1,| 4, 5} so we need to check from right to left also...
	 */
	

	// this only finds an element that occurs n / 3 ... can be applied to find all n / 3 elements
	
	private static Integer findNOverThree(int input[]) {
		int candidate = findCandidate(input);
		if(greaterThanNOverThree(input, candidate))
			return candidate;
		
		reverse(input);
		
		candidate = findCandidate(input);
		
		if(greaterThanNOverThree(input, candidate))
			return candidate;
		
		return null;
	}	
	
	public static boolean greaterThanNOverThree(int input[], int candidate) {
		int length = input.length;
		int count = 0;

		int target = length / 3;
		
		for(int i : input) {
			if(i == candidate) 
				count++;
			if(count > target)
				return true;
		}
		
		return false;
	}
	
	
	public static int findCandidate(int input[]) {
		int currentCount = 1;
		int currentVal = input[0];
		
		for(int i = 1; i < input.length; i++) {
			if(input[i] == currentVal)
				currentCount++;
			else {
				currentCount--;
				if(currentCount == 0) {
					currentCount = 1;
					currentVal = input[i];
				}
			}
		}
		
		return currentVal;
	}
	
	
	
	public static void reverse(int[] data) {
	    for (int left = 0, right = data.length - 1; left < right; left++, right--) {
	        // swap the values at the left and right indices
	        int temp = data[left];
	        data[left]  = data[right];
	        data[right] = temp;
	    }
	}
	
	public static void main(String... args) {
		System.out.println(findNOverThree(new int[] {1, 2, 3, 1, 4, 1} ));
		System.out.println(findNOverThree(new int[] {5, 1, 1, 4, 4, 3} ));

		
	}
	
}
