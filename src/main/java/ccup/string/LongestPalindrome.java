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
		
		int from = 0;
		int to = 0;
		
		for(int subSize = 1; subSize < paltable.length; subSize++) { // subproblem size
			for(int start = 0; start + subSize < paltable.length; start++) {
				int end = start + subSize;
				
				int startSub = start + 1;
				int endSub = end -1;
				
				if(startSub <= endSub) {
					if(paltable[startSub][endSub] && input.charAt(start) == input.charAt(end)) {
						if(to - from + 1 < start + end) {
							from = start;
							to = end;
						}
						
						paltable[start][end] = true;
					}
				}
			}
		}
		
		
		
		return input.substring(from, to + 1);
	}
	
	public static void main(String... args) {
		System.out.println(longestPalindrome("asakdasad"));
	}
	
}
