package ccup.array;

import java.util.Arrays;

/*
http://www.careercup.com/question?id=12986664
Push all the zero's of a given array to the end of the array. In place only. Ex 1,2,0,4,0,0,8 becomes 1,2,4,8,0,0,0

*/


public class MoveZeroToEnd {
	
	public static void pushZeros(int input[]) {
		int nextSlot = 0;
		
		for(int i = 0; i < input.length; i++) {
			if(input[i] != 0) {
				input[nextSlot++] = input[i];
			}
		}
		
		// zero out
		for(int i = nextSlot; i < input.length; i++) {
			input[i] = 0;
		}
	}

	public static void main(String[] args) {
		int in[] = {1,2,0,4,0,0,8};
		pushZeros(in);
		System.out.println(Arrays.toString(in));
	}

}
