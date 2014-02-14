package ccup.string;

import java.util.Arrays;

/*
http://www.careercup.com/question?id=5684278553739264

Given s string, Find max size of a sub-string, in which no duplicate chars present.

*/
public class MaxSubStringNoDuplicate {

	
	
	/*    1
		abbbba => max is ab
		012345
		
		01234
		aebeab => eab or abe
		
		01234
		abaab
	
	*/
	public static int getMaxSubString(String s) {
		int start = 0;
		int end = 0;
		
		int max = 0;
		
		int lookup[] = new int[128];
		Arrays.fill(lookup, -1);
		
		for(int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			
			int index = lookup[c];
			
			if(index != -1 && index >= start) { // only update start if it is greater than previous start since we can have a case like abaab
				start = index + 1;
			}
			
			lookup[c] = i;
			end = i;
			
			max = Math.max(max, end - start + 1);
		}
		
		return max;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getMaxSubString("abaab"));
		System.out.println(getMaxSubString("aebeab"));
		System.out.println(getMaxSubString("abbbba"));

	}

}
