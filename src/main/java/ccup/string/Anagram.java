package ccup.string;

import java.util.HashMap;
import java.util.Map;

/*

http://www.careercup.com/question?id=1640

Giving Two Strings, Find out whether they are Anagrams or not?
		
		
		*/
public class Anagram {
	
	public static boolean isAnagram(String s1, String s2) {
		s1 = s1.toLowerCase().trim();
		s2 = s2.toLowerCase().trim();
		
		if(s1.length() != s2.length())
			return false;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		int matchCount = s1.length();
		
		for(int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			
			if(map.containsKey(c)) {
				int cCount = map.get(c);
				map.put(c, cCount+ 1);
			} else
				map.put(c, 1);
		}
		
		for(int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			Integer count = map.get(c);
			
			if(count == null || count == 0) {
				return false;
			} else {
				matchCount--;
				map.put(c, count - 1);
			}
			
		}
		
		
		return matchCount == 0;
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("Debit card", "Bad credit"));
	}

}
