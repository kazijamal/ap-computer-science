public class NodeDeque<E> {

    // instance variables
    private int size;
    private final DNode<E> HEAD, TAIL;

    // constructor
    public NodeDeque() {
	size = 0;
	HEAD = new DNode<E>(null, null, null);
	TAIL = new DNode<E>(null, HEAD, null);
	HEAD.setNext(TAIL);
    }

    public int size() {
	return size;
    }

    public boolean isEmpty() {
	return size() == 0;
    }

    public E getFirst() throws EmptyDequeException {
	if (isEmpty())
	    throw new EmptyDequeException("Empty Deque");
	return HEAD.getNext().getValue();
    }

    public E getLast() throws EmptyDequeException {
	if (isEmpty())
	    throw new EmptyDequeException("Empty Deque");
	return TAIL.getPrevious().getValue();
    }

    public void addFirst(E value) {
	DNode<E> temp = new DNode<E>(value, HEAD, HEAD.getNext());
	HEAD.getNext().setPrevious(temp);
	HEAD.setNext(temp);
	size++;
    }

    public void addLast(E value) {
	DNode<E> temp = new DNode<E>(value, TAIL.getPrevious(), TAIL);
	TAIL.getPrevious().setNext(temp);
	TAIL.setPrevious(temp);
	size++;
    }

    public E removeFirst() throws EmptyDequeException {
	if (isEmpty())
	    throw new EmptyDequeException("Empty Deque");
	DNode<E> temp = HEAD.getNext();
	HEAD.setNext(temp.getNext());
	temp.getNext().setPrevious(HEAD);
	E ans = temp.getValue();
	temp.setPrevious(null);
	temp.setNext(null);
	size--;
	return ans;
    }

    public E removeLast() throws EmptyDequeException {
	if (isEmpty())
	    throw new EmptyDequeException("Empty Deque");
	DNode<E> temp = TAIL.getPrevious();
	TAIL.setPrevious(temp.getPrevious());
	temp.getPrevious().setNext(TAIL);
	E ans = temp.getValue();
	temp.setPrevious(null);
	temp.setNext(null);
	size--;
	return ans;
    }

    @Override
    public String toString() {
	String ans = "[";
	for (DNode<E> x = HEAD.getNext(); x != TAIL; x = x.getNext()) {
	    ans += x.getValue() + ",";
	}
	if (ans.length() > 1)
	    ans = ans.substring(0, ans.length() - 1);
	ans += "]";
	return ans;
    }

    private static class DNode<E> {

	// instance variables
	private final E VALUE;
	private DNode<E> previous, next;

	// constructor
	public DNode(E val, DNode<E> previous, DNode<E> next) {
	    VALUE = val;
	    this.previous = previous;
	    this.next = next;
	}

	// accessor methods
	public E getValue() {
	    return VALUE;
	}

	public DNode<E> getPrevious() {
	    return previous;
	}

	public DNode<E> getNext() {
	    return next;
	}

	// mutator methods
	public void setPrevious(DNode<E> x) {
	    previous = x;
	}

	public void setNext(DNode<E> x) {
	    next = x;
	}

    }

    public static void main(String[] args) {
	// DNode<Integer> p = new DNode<Integer>(1, null, null);
	// p.setNext(new DNode<Integer>(2, p, null));
	// // left to right
	// for (DNode<Integer> x = p; x != null; x = x.getNext()) {
	// System.out.println(x.getValue());
	// }
	// // right to left
	// for (DNode<Integer> x = p.getNext(); x != null; x = x.getPrevious()) {
	// System.out.println(x.getValue());
	// }
	NodeDeque<Integer> d = new NodeDeque<Integer>();
	System.out.println(d);
	System.out.println("size: " + d.size());
	System.out.println("isEmpty: " + d.isEmpty());
	for (int i = 2; i > 0; i--) {
	    d.addFirst(i);
	    System.out.println(d);
	    System.out.println("size: " + d.size());
	    System.out.println("isEmpty: " + d.isEmpty());
	}
	while (!d.isEmpty()) {
	    System.out.println("first element: " + d.getFirst());
	    d.removeFirst();
	    System.out.println(d);
	    System.out.println("size: " + d.size());
	    System.out.println("isEmpty: " + d.isEmpty());
	}
    }

}
