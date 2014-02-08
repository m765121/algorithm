package ccup.selection;
/*
http://www.careercup.com/question?id=12705676
one unsorted array is given. Find out the index i and j ,j > i for which a[j] - a[i] is maximum.perform in linear time complexity
*/
public class UnsortedArrayMaxIndexAndValue {
	
	
	
	// keep track of min while scanning from left to right
	// also keep track of max but need to make sure j > i so there is an inv flag and we skip max calculation if it is violated
	public static void printMaxDiff(int input[]) {
		
		int minIndex = 0;
		int minVal = input[minIndex];

		int maxIndex = 1;
		int maxVal = input[maxIndex];
		
		int maxDiff = maxVal - minVal;
		
		boolean violatedInv = false;
		
		for(int i = 2; i < input.length; i++) {
			if(maxVal < input[i] || violatedInv) { 
				maxIndex = i;
				maxVal = input[maxIndex];
				maxDiff = Math.max(maxDiff, maxVal - minVal);
				
				violatedInv = false;
			} 
			
			
			int j = i - 1;
			
			if(minVal > input[j]) {
				minIndex = j;
				minVal = input[minIndex];
				
				if(j >= maxIndex) 
					violatedInv = true;
				 else 
					 maxDiff = Math.max(maxDiff, maxVal - minVal);
			}
		}
		
		System.out.println(maxDiff); // gets the max diff; we can easily get the indices
	}
	
	
	public static void main(String... args) {
		printMaxDiff(new int[] {102, 101, 5000, 3000, 1 });
		printMaxDiff(new int[] {102, 101, 5000, 100, 99, 98, 97, 3000, 10000, 10001 });
	}
}
