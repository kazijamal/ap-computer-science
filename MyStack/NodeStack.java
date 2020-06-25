import java.util.EmptyStackException;

public class NodeStack<E> implements MyStack<E> {

	// instance variables
	private Node<E> top;
	private int size;

	// constructor
	public NodeStack() {
		top = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public void push(E value) {
		top = new Node<E>(value, top);
		size++;
	}

	@Override
	public E peek() throws EmptyStackException {
		if (empty())
			throw new EmptyStackException();
		return top.getValue();
	}

	@Override
	public E pop() throws EmptyStackException {
		E ans = peek();
		top = top.getNext();
		size--;
		return ans;
	}

	@Override
	public String toString() {
		String ans = "[";
        for (Node<E> x = top; x != null; x = x.getNext()) {
            ans += x + ",";
        }
        if (ans.length() > 1)
            ans = ans.substring(0, ans.length() - 1);
        ans += "]";
        return ans;
	}

	private static class Node<E> {

		// instance variables
		private final E VALUE;
		private final Node<E> NEXT;

		// constructor
		public Node(E value, Node<E> next) {
			this.VALUE = value;
			this.NEXT = next;
		}

		// getter methods
		public E getValue() {
			return VALUE;
		}

		public Node getNext() {
			return NEXT;
		}

		@Override
		public String toString() {
			return VALUE.toString();
		}

	}

	public static void main(String[] args) {
		MyStack<Integer> s = new NodeStack<Integer>();
		for (int i = 0; i < 10; i++) {
			s.push(i);
			System.out.println(s);
		}
		System.out.println("Popping.... ");
		while (!s.empty()) {
			System.out.println(s.pop());
		}
		System.out.println(s);
	}

}
