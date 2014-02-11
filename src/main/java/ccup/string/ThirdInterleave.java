package ccup.string;
/*
http://www.careercup.com/question?id=14539805
Three strings say A,B,C are given to you. Check weather 3rd string is interleaved from string A and B. 
Ex: A="abcd" B="xyz" C="axybczd". answer is yes. o(n)
 */
public class ThirdInterleave {

	// ambiguous case if performing simple scanning of strings 
	// ab abe abeab -> 
	// 1) pick all of first string ab, pick e of second string -> false
	// 2) this will return the correct result - pick second string abe -> pick all of first string

	public static boolean bruteInterleave(String a, String b, String c) { // complexity is 2^n
		if(c.isEmpty() && a.isEmpty() &&  b.isEmpty())
			return true;
		else if(a.isEmpty() && b.isEmpty())
			return false;
		else {
			String cChar = c.substring(0,1);
			String cSub = c.substring(1);
			return (!a.isEmpty() && a.substring(0,1).equals(cChar) && bruteInterleave(a.substring(1), b, cSub)) 
					|| (!b.isEmpty() && b.substring(0,1).equals(cChar) && bruteInterleave(a, b.substring(1), cSub));
		}
	}

	public static boolean interleaveDp(String a , String b, String c) {
		//		o(n^2)
		//		let valid[i][j] be true if there exists an interleaving for a(0....i), b(0...j) in the c string  (0....i+j)
		//		then valid[i][j] = true if (valid[i-1][j] && c.charAt(i+j) == a.charAt(i)) ||  (valid[i][j-1] && c.charAt(i+j) == b.charAt(j))
		//		base case is a[0][0] is true for the empty string c

		int totalLength = a.length() + b.length();

		if(c.length() != totalLength)
			return false;
		else {
			boolean valid[][] = new boolean[a.length() + 1][b.length() + 1];

			valid[0][0] = true;

			for(int i = 0; i < valid.length; i++) {
				for(int j = 0; j < valid[0].length; j++) {
					if(i == 0 && j == 0) continue;

					char cChar = c.charAt(i+j-1);

					valid[i][j] = (i > 0 && valid[i-1][j] && a.charAt(i-1) == cChar) ||
							(j > 0 && valid[i][j-1] && b.charAt(j-1) == cChar);

				}
			}
			return valid[a.length()][b.length()];
		}
	}


	public static void main(String... args) {
		System.out.println(bruteInterleave("abcd", "xyz", "axybczd"));
		System.out.println(bruteInterleave("ab", "abe", "abeab"));

		System.out.println(interleaveDp("abcd", "xyz", "axybczd"));
		System.out.println(interleaveDp("ab", "abe", "abeab"));
	}

}
