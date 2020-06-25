import java.util.Stack;
import java.util.NoSuchElementException;

public class StackQueue<E> implements MyQueue<E> {

    private Stack<E> stack, reverse;

    public StackQueue() {
        stack = new Stack<E>();
        reverse = new Stack<E>();
    }

    @Override
    public int size() {
        return stack.size() + reverse.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.empty();
    }

    // O(1)
    @Override
    public boolean add(E val) {
        stack.push(val);
        return true;
    }

    // O(1)
    @Override
    public boolean offer(E val) {
        return add(val);
    }

    @Override
    public E peek() {
	if (isEmpty()) return null;
	if (reverse.isEmpty()) {
	    while (!stack.isEmpty()) {
		reverse.push(stack.pop());
	    }
	}
	return reverse.peek();
    }

    // O(N)
    @Override
    public E poll() {
        if (isEmpty()) return null;
        return remove();
    }

    // O(N)
    @Override
    public E remove() throws NoSuchElementException {
        if (isEmpty())
            throw new NoSuchElementException("Empty Queue");
	E ans = peek();
	return reverse.pop();
    }

    public static void main(String[] args) {
        MyQueue<Integer> q = new StackQueue<Integer>();
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
