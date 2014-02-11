package ccup.tree.util;

public class Node<T> {
    public Node<T> left, right;
    public T data;

    public Node(T data) {
        this.data = data;
    }
}

