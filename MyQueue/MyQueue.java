import java.util.NoSuchElementException;

public interface MyQueue<E> {

    public int size();
    public boolean isEmpty();
    public boolean add(E val) throws IllegalStateException; // when the queue is at capacity
    public boolean offer(E val); // inserts the element into the queue if space available
    public E peek(); // returns the head or null if empty
    public E poll(); // returns and removes the head or null if empty
    public E remove() throws NoSuchElementException; // returns and removes the head

}
