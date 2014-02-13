package ccup.string;

import ccup.linkedlist.util.Node;


/*

http://www.careercup.com/question?id=4774716350922752

In a language, there are only 4 characters ‘h’, ‘i’,’r’, ‘e’. and we have to write a function which takes a 
string as input and returns whether the given input string is a “valid word” or not. 

Definition of valid word : 
1. A given word is a valid word if it is of the form h^n i^n r^n e^n where n >=1. (eg: hhiirree) 
2. Valid words has concatenation property i.e. if w1 and w2 are valid words w1w2 is also a valid word.

*/



















public class ValidWord {
	public static boolean validWord(String input) {
		
		
		return true;
	}
	
	
	static class FSM {
		
		private Node<Character> headOfFsm;
		
		FSM(Node<Character> headOfFsm) {
			headOfFsm = headOf
		}
		
		
		FSM next(char in) {
			if(in == val)
				return this;
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
