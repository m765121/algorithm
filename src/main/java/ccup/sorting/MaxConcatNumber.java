package ccup.sorting;

import java.util.Arrays;
import java.util.Comparator;

/*
http://www.careercup.com/question?id=7781671
Given an integer array, sort the integer array such that the concatenated integer of the result array is max. e.g. [4, 94, 9, 14, 1]
will be sorted to [9,94,4,14,1] where the result integer is 9944141

*/
public class MaxConcatNumber {
	
	private static class AlmostLexicalOrder implements Comparator<Integer> {

		@Override
		public int compare(Integer a, Integer b) {
			String aStr = a.toString();
			String bStr = b.toString();

			return expand(bStr, aStr).compareTo(expand(aStr, bStr));
		}
	}
	
	public static String expand(String in, String expandTo) {
		if(in.length() >= expandTo.length())
			return in;
		else {
			String lastDigit = in.substring(in.length() - 1);
			
			StringBuilder builder = new StringBuilder(in);
			while(builder.length() < expandTo.length()) {
				builder.append(lastDigit);
			}
			
			return builder.toString();
		}
	}
	
	
	public static void main(String... args) {
		Integer arr[] = {9,94, 99, 999};
		Arrays.sort(arr, new AlmostLexicalOrder());
		System.out.println(Arrays.toString(arr));
	}
}
