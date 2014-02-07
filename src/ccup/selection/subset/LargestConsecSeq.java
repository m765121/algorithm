package ccup.selection.subset;

import java.util.HashMap;
import java.util.Map;


/*http://www.careercup.com/question?id=11070934

Given an int array which might contain duplicates, find the largest subset of it which form a sequence. 
Eg. {1,6,10,4,7,5,3,2,8} 
then ans is 1,2,3,4,5,6,7,8

Sorting is an obvious solution. Can this be done in O(n) time*/


public class LargestConsecSeq {

	// 1 - 1
	// 6 - 2
	// 10 - 1
	// 4 - 1
	// 7 - 2
	// 5 - xx dont care since there is upper and lower bound 7 and 4 respectively
	// 3 - 5 // set upper bound 7
	// 2 - xx dont care // set upper bound 7 and lower bound 1
	// 8 - 8 this is an upper bound 7 set lower bound 1

	// o(n) time - o(n distinct) space


	static void printLargestSeq(int input[]) {
		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		
		int fromVal = input[0];
		int toCount = 1;
		
		for(int i : input) {
			if(countMap.get(i) == null) {

				int topCount = countMap.get(i+1) == null ? 0 : countMap.get(i+1);
				int bottomCount = countMap.get(i-1) == null ? 0 : countMap.get(i-1);

				int count = 1 + bottomCount + topCount;
				
				countMap.put(i, count); // for dups or in the event it is an upper or lower bound
				
				if(bottomCount != 0) { // lower bound  
					if(toCount < count) {
						fromVal = i-bottomCount;
						toCount = count;
					}
					
					countMap.put(i-bottomCount, count);
				} 
					
				if(topCount != 0) // upper bound
					countMap.put(i+topCount, count);
			}
		}
		
		System.out.println(fromVal + " to " + (fromVal + toCount - 1));
		
	}


	public static void main(String... args) {
		printLargestSeq(new int[]{1,6,10,4,7,5,3,2,8});

	}
}
