package ccup.array;

// http://www.careercup.com/question?id=14370695
// Implement the plusplus operator when we are getting the input as integer array = { 9,9,9,9 }.
//output will be {1,0,0,0,0}

public class ArrayPlusPlus {
	static int[] sum(int input[]) {
		boolean reqCarry = true;

		for (int val : input) { // optimization check msd first to see if final carry needed
			if (val < 9)
				reqCarry = false;
		}

		int output[] = reqCarry ? new int[input.length + 1] : new int[input.length];

		int prevSum = input[input.length - 1] + 1;

		for (int i = input.length - 2; i >= 0; i--) {
			if (prevSum == 10 && input[i] == 9) {
				output[i] = 0;
				prevSum = 10;
			} else if (prevSum == 10) {
				output[i] = 1 + input[i];
			} else {
				output[i] = input[i];
			}
		}

		if (reqCarry)
			output[0] = 1;

		return output;
	}
}
