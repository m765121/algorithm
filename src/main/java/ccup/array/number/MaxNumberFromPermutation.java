package ccup.array.number;
/*
http://www.careercup.com/question?id=10676884

You have given a positive number you have to find a number which is bigger than that by using same digits available in the number . 
Example :- 
You have given a number 7585 , your output should be 7855 .
*/
public class MaxNumberFromPermutation {

	public static int maxNumber(int num) {
		
		String numStr = String.valueOf(num);
		
		int digit[] = new int[10];
		
		for(int i = 0; i < numStr.length(); i++) {
			String digitStr = String.valueOf(numStr.charAt(i));
			
			digit[Integer.valueOf(digitStr)] += 1;
		}
		
		StringBuilder builder = new StringBuilder(num);
		
		for(int i = digit.length - 1; i >=0; i--) {
			for(int j = 0; j < digit[i]; j++) {
				builder.append(i);
			}
		}
		

		return Integer.valueOf(builder.toString());
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(maxNumber(7585));
	}

}
