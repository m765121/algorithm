package ccup.array;

import java.util.BitSet;

/*
http://www.careercup.com/question?id=11685824

There are two arrays. 

int arr1[5] = { 3, 5, 2, 5, 2} 
int arr2[5] = { 2, 3, 5, 5, 2} 

The arrays will be called similar if they contain same number of elements equally. 

Write the pseudo code to check this ? 

I was not allowed to use sorting and hashtable.

*/
public class TwoArraySimilar {

	public static boolean similar(int in1[], int in2[]) {
		if(in1.length != in2.length)
			return false;
		
		// another opt is to sum the elements and compare first.. if they are not equal then there is no way they are similar
		// can use variant of counting sort, but this is equiv to a lookup table
		// O(n^2) 
		BitSet set = new BitSet(in1.length);
		
		for(int i : in1) {
			for(int j = 0; j < in2.length; j++) {
				if(!set.get(j) && i == in2[j]) {
					set.set(j);
				}
			}
		}
		
		return set.cardinality() == in1.length;
	}
	
	
	public static void main(String... args) {
		int arr1[] = { 3, 5, 2, 5, 2}; 
		int arr2[] = { 2, 3, 5, 5, 2};
		
		System.out.println(similar(arr1, arr2));
		
		int arr3[] = { 3, 5, 2, 5, 2}; 
		int arr4[] = { 1, 4, 5, 5, 2};
		
		System.out.println(similar(arr3, arr4));
		
	}
	
}
