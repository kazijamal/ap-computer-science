public class ArrayList<E> implements List<E> {

	// instance variables
	private E[] data; // generic array used for storage
	private int size; // current number of elements

	// constructors
	// Will generate compiler warnings regarding unsafe operations
	// Creates a default ArrayList with a capacity of 16 elements
	public ArrayList() {
		this(1);
	}

	// starting capacity
	public ArrayList(int capacity) {
		data = (E[]) (new Object[capacity]);
		size = 0;
	}

	// returns the number of elements in the list
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	// pre: newCapacity > data.length
	// post: simulates a dynamic array
	private void resize(int newCapacity) {
		E[] temp = (E[]) (new Object[newCapacity]);
		for (int i = 0; i < data.length; i++) {
			temp[i] = data[i];
			data[i] = null;
		}
		System.out.println("Resizing from " + data.length + " to " + data.length * 2);
		data = temp;
	}

	// O(1)
	public boolean add(E value) {
		if (size() == data.length)
			resize(data.length * 2);
		data[size++] = value;
		return true;
	}

	// O(1)
	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size())
			throw new IndexOutOfBoundsException();
		return data[i];

	}

	// O(1)
	public E set(int i, E value) throws IndexOutOfBoundsException {
		E ans = get(i);
		data[i] = value;
		return ans;
	}

	// O(n)
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size())
			throw new IndexOutOfBoundsException();
		E ans = get(i);
		// shift left
		while (i < size() - 1) {
			data[i] = data[i + 1];
			i++;
		}
		data[size() - 1] = null;
		size--;
		return ans;
	}

	// O(n)
	public void add(int i, E value) throws IndexOutOfBoundsException {
		if (size() == data.length)
			resize(2 * data.length);
		if (i < 0 || i > size())
			throw new IndexOutOfBoundsException();
		// shift right
		for (int j = size(); j > i; j--)
			data[j] = data[j - 1];
		data[i] = value;
		size++;
	}

	public String toString() {
		String ans = "[";
		for (int i = 0; i < size(); i++)
			ans += data[i] + ",";
		if (!isEmpty())
			ans = ans.substring(0, ans.length() - 1);
		ans += "]";
		return ans;
	}

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList();
		System.out.println(list);
		String s = "abcdefghijklmnop";
		// O(n)
		for (int i = 0; i < s.length(); i++) {
			list.add(s.substring(i, i + 1));
			System.out.println(list);
		}
		// O(n)
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%2d: %s%n", i, list.get(i));

		}
		// swap the first two elements
		System.out.println("Before swap: " + list);
		list.set(0, list.set(1, list.get(0)));
		System.out.println("Before swap: " + list);

		list.set(0, list.set(1, list.get(0)));
		// remove every other letter
		System.out.println("Before removing: " + list);
		int n = list.size();
		for (int i = 1; i <= n / 2; i++) {
			System.out.println("remove: " + list.remove(i));
			System.out.println("list: " + list);
		}
		s = "bdfhjlnp";
		System.out.println("Before inserting: " + list);
		n = s.length();
		int j = 1;
		for (int i = 0; i < n; i++) {
			list.add(j, s.substring(i, i + 1));
			System.out.println("insert : " + s.substring(i, i + 1));
			System.out.println("list : " + list);
			j += 2;
		}

	}
}