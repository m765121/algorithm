package ccup.string;

import java.util.HashMap;
import java.util.Map;


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
		FSM e = new FSM('e');
		FSM r = new FSM('r', 'e', e);
		FSM i = new FSM('i', 'r', r);
		FSM h = new FSM('h', 'i', i);
		e.addState('h', h);
		
		FSM fsm = h;

		for(int j = 0; j < input.length(); j++) {
			char c = input.charAt(j);

			FSM state = fsm.nextState(c);
			
			
			if(state == null) 
				return false;
			else
				fsm = state;
		}
		
		return fsm == e;
	}



	static class FSM {
		final Map<Character, FSM> stateMap = new HashMap<Character,FSM>();
		Character value;
		FSM(Character value) {
			this.value = value;
		}

		FSM(Character value, Character event, FSM toState) {
			this(value);
			addState(event, toState);
		}


		void addState(Character event, FSM toState) {
			stateMap.put(event, toState);
		}

		FSM nextState(char input) {
			if(value != null && input == value)
				return this;
			else
				return stateMap.get(input);
		}
	}


	public static void main(String[] args) {
		System.out.println(validWord("hhiirreeeeeehirre"));
		System.out.println(validWord("hire"));

	}

}
