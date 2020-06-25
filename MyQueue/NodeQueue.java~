import java.util.NoSuchElementException;

public class NodeQueue<E> implements MyQueue<E> {

	private final Node<E> HEAD;
	private Node<E> tail;
	private int size;

	public NodeQueue() {
		HEAD = tail = new Node<E>(null, null);
		size = 0;
	}

	// when at capacity
	public boolean add(E val) throws IllegalStateException {
		tail.setNext(new Node<E>(val, null));
		tail = tail.getNext();
		size++;
		return true;
	}

	// inserts E into queue if space available
	public boolean offer(E val) {
		return add(val);
	}

	// returns the head of the queue or null if empty
	public E peek() {
		if (isEmpty())
			return null;
		return HEAD.getNext().getValue();
	}

	// removes and returns the head of the queue or null
	public E poll() {
		E ans = peek();
		HEAD.setNext(HEAD.getNext().getNext());
		size--;
		if (isEmpty())
			tail = HEAD;
		return ans;
	}

	// removes and returns the head of the queue
	public E remove() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException();
		return poll();
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public String toString() {
		String ans = "[";
		Node<E> temp = HEAD.getNext();
		while (temp != null) {
			ans += temp.getValue() + ",";
			temp = temp.getNext();
		}
		if (ans.length() > 1)
			ans = ans.substring(0, ans.length() - 1);
		ans += "]";
		return ans;
	}

	private static class Node<E> {
		private final E VALUE;
		private Node<E> next;

		// constructor
		public Node(E val, Node<E> next) {
			VALUE = val;
			this.next = next;
		}

		// accessors
		public E getValue() {
			return VALUE;
		}

		public Node<E> getNext() {
			return next;
		}

		// mutators
		public void setNext(Node<E> next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> q = new NodeQueue<Integer>();
		for (int i = 0; i < 10; i++) {
			System.out.println(q + " size: " + q.size());
			q.offer(i);
		}
		System.out.println(q + " size: " + q.size());
		while (!q.isEmpty()) {
			System.out.println(q.poll() + " " + q);
		}
	}

}
