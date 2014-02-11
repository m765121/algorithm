package ccup.tree;

/*
http://www.careercup.com/question?id=7617672

Path to deepest 1 in a binary tree. 
We have a binary tree (not a BST) made up of only 0s and 1s. 
we need to find the deepest 1 with a path from root made up only of 1's.
 */


import java.util.Random;

import ccup.tree.util.*;
import ccup.tree.util.BTreeGenerator.RandomData;

public class LongestConsecZero {
	// O(n)
	public static int deepest(Node<Integer> node) {
		if(node == null || node.data == 0) {
			return 0;
		} else {
			return Math.max(deepest(node.left), deepest(node.right)) + 1;
		}
	}
	
	
	public static void main(String... args) {
		BTreeGenerator<Integer> gen = new BTreeGenerator<Integer>(new RandomZeroAndOne());
		
		Node<Integer> root = gen.getRandomTree(6, 6);
		
		BTreePrinter.printNode(root);
		
		System.out.println(deepest(root));
	}
	
	
	private static class RandomZeroAndOne implements RandomData<Integer> {
		private static Random randomBool = new Random();
		
		@Override
		public Integer next() {
			return randomBool.nextBoolean() ? 1 : 0;
		}
		
	}
	
	
	
}
