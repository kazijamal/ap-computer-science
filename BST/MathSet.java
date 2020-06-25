import java.util.Iterator;
import java.util.HashSet;

public class MathSet<Key> {

	private HashSet<Key> set; // set is a subset of the universe
	private HashSet<Key> universe; // a set of the potential items in a MathSet

	public MathSet(Key[] universe) {
		set = new HashSet<Key>();
		this.universe = new HashSet<Key>();
		for (Key x : universe)
			this.universe.add(x);
	}

	// O(1)
	// post: key is added to the set if key is both a member of the universe
	// and not already a member of the set. Otherwise, returns false.
	public boolean add(Key key) {
		if (universe.contains(key))
			return set.add(key);
		return false;
	}

	public int size() {
		return set.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void union(MathSet<Key> a) {
		for (Key key : a.set)
			add(key);
	}

	public void intersect(MathSet<Key> a) {
		Iterator<Key> itr = set.iterator();
		while (itr.hasNext()) {
			Key x = itr.next();
			if (!a.contains(x))
				itr.remove();
		}
	}

	// O(1)
	public boolean contains(Key key) {
		return set.contains(key);
	}

	public boolean delete(Key key) {
		return set.remove(key);
	}

	public String toString() {
		return set.toString();
	}

	public static void main(String[] args) {
		MathSet<String> A = new MathSet<String>(args);
		System.out.println("A: " + A);

		for (String x : args) {
			double r = Math.random();
			if (r < 0.5)
				A.add(x);
		}
		System.out.println("A: " + A);

		MathSet<String> B = new MathSet<String>(args);
		System.out.println("B: " + B);

		for (String x : args) {
			double r = Math.random();
			if (r < 0.5)
				B.add(x);
		}
		System.out.println("B: " + B);

		A.union(B);
		System.out.println("A union B: " + A);

		A.intersect(B);
		System.out.println("A intersect B: " + A);
	}

}
