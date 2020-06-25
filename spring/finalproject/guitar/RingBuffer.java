public class RingBuffer {

	private double[] array;
	private int first, last;
	private int size;
	private final int MAX_CAPACITY;

	// create an empty ring buffer
	public RingBuffer(int capacity) {
		array = new double[capacity];
		first = last = 0;
		size = 0;
		MAX_CAPACITY = capacity;
	}

	// return number of items currently in the buffer
	public int size() {
		return size;
	}

	// is the buffer empty (size equals zero)?
	public boolean isEmpty() {
		return size() == 0;
	}

	// is the buffer full (size equals capacity)?
	public boolean isFull() {
		return size() == MAX_CAPACITY;
	}

	// add item x to the end
	public void enqueue(double x) {
		if (isFull())
			throw new IllegalStateException("Full RingBuffer");
		array[last++] = x;
		if (last == MAX_CAPACITY)
			last = 0;
		size++;
	}

	// delete and return item from the front
	public double dequeue() {
		if (isEmpty())
			throw new IllegalStateException("Empty RingBuffer");
		double ans = array[first];
		array[first++] = 0.0;
		if (first == MAX_CAPACITY)
			first = 0;
		size--;
		return ans;
	}

	// return (but do not delete) item from the front
	public double peek() {
		return array[first];
	}
	
}