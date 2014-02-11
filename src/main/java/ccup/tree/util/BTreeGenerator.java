package ccup.tree.util;

import java.util.Random;

public class BTreeGenerator<T> {
	
	public interface RandomData<T> {
		T next();
	}
	
	private static Random randomBool = new Random();
	
	private final RandomData<T> random;
	
	public BTreeGenerator(RandomData<T> random) {
		this.random = random;
	}
	
	
	private Node<T> genRandomNode() {
		return new Node<T>(random.next());
	}
	
	public Node<T> getRandomTree(int height, int current) {
		if(current == 0) {
			return null;
		} else {			
			Node<T> node = current == height || randomBool.nextBoolean() ? genRandomNode() : null;
			
			if(node != null) {
				node.left = getRandomTree(height, current - 1);
				node.right = getRandomTree(height, current - 1);
			}
			return node;
		}
	}
	
 	
}
