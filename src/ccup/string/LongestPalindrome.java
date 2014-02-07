package ccup.string;


/*
http://www.careercup.com/question?id=245679
find the longest palindrome in a string?
*/
public class LongestPalindrome {

	
	public static String longestPalindrome(String input) {
		boolean paltable[][] = new boolean[input.length()][input.length()];
		
		for(int i = 0; i < paltable.length; i++) {
			paltable[i][i] = true;
		}
		
		
		for(int subSize = 1; subSize < paltable.length; subSize++) { // subproblem size
			for(int start = 0; start + subSize < paltable.length; start++) {
				int end = start + subSize;
				
				if(paltable[start+1][end-1] && input.charAt(start) == input.charAt(end)) // TODO check bounds
					paltable[start][end] = true;
			}
		}
		return "";
	}
	
	public static void main(String... args) {
////		"asddsajk";
//		// let a[i][j] be true iff i...j is a palindrome then
//		
//		// a[i][i] where i == 0...n is true;
//		
//		a[i][j] is true if 
//		
//		a[i+1][j-1] is true && char(i) == char(j)
	}
	
}
