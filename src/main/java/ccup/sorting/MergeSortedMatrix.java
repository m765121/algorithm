/*
http://www.careercup.com/question?id=5678547255427072

Given a sorted 2D N x N array (where array[i][j] < array[i][j+1] and array[i][j] < array[i+1][j]), can you write a function that converts this to a sorted 1D array? 


2 39 65 101 125 
12 42 74 110 142 
26 59 88 122 154 
40 72 95 133 161 
46 81 107 145 173 

After 
2 12 26 39 40 42 46 59 65 72 74 81 88 95 101 107 110 122 125 133 142 145 154 161 173
 */



package ccup.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeSortedMatrix {


	// have a heap of size n 
	// n^2 log n
	public static int[] sort(int input[][]) {
		Queue<Element> heap = new PriorityQueue<Element>(input[0].length, new Element.Comp());

		int sorted[] = new int[input.length * input[0].length];

		for(int i = 0; i < input[0].length; i++) {
			heap.add(new Element(input[0][i], 0, i));
		}

		for(int i = 0; i < sorted.length; i++) {
			Element min = heap.remove();

			int nextRow = min.row + 1;

			if(nextRow < input.length) {
				heap.add(new Element(input[nextRow][min.col], nextRow, min.col));
			}

			sorted[i] = min.value;
		}

		return sorted;
	}

	private static class Element {
		Integer value;
		int row;
		int col;
		public Element(int value, int row, int col) {
			this.value = value;
			this.row = row;
			this.col = col;
		}

		static class Comp implements Comparator<Element> {
			@Override
			public int compare(Element arg0, Element arg1) {
				return arg0.value.compareTo(arg1.value);
			}
		}
	}

	public static void main(String... args) {
		int input[][] = {
				{2, 39, 65, 101, 125 }, 
				{12, 42, 74, 110, 142 },
				{26, 59, 88, 122, 154 },
				{40, 72, 95, 133, 161 },
				{46, 81, 107, 145, 173 }
		};
		
		System.out.println(Arrays.toString(sort(input)));
	}


}
