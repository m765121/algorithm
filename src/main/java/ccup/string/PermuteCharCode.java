package ccup.string;

import java.util.ArrayList;
import java.util.List;

/*
http://www.careercup.com/question?id=19300678

If a=1, b=2, c=3,....z=26. Given a string, find all possible codes that string can generate. Give a count as well as print the strings. 

For example: 
Input: "1123". You need to general all valid alphabet codes from this string. 

Output List 
aabc //a = 1, a = 1, b = 2, c = 3 
kbc // since k is 11, b = 2, c= 3 
alc // a = 1, l = 12, c = 3 
aaw // a= 1, a =1, w= 23 
kw // k = 11, w = 23
*/
public class PermuteCharCode {
	

	public static void permute(String input) {
		List<String> result = new ArrayList<String>();
		
		_permute(input, "", 0, result);
		
		System.out.println(result + " " + result.size());
	}
	
	
	
	public static void _permute(String input, String formedWord, int inIndex, List<String> acc) {
		if(inIndex >= input.length()) 
			acc.add(formedWord);
		else {
			int val = Integer.parseInt(input.substring(inIndex, inIndex + 1));
			
			char charVal = (char) (val + 96);
			
			_permute(input, formedWord + charVal, inIndex + 1, acc);

			if(inIndex < input.length() - 1) {
				int combinedVal = Integer.parseInt(input.substring(inIndex, inIndex + 2));
				
				if(combinedVal <= 26) {
					charVal = (char) (combinedVal + 96);
					_permute(input, formedWord + charVal, inIndex + 2, acc);
				}
			}
		}
	}
	
	
	
	
	
	public static void main(String... args) {
		permute("1123");
	}

}
