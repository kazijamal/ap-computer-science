import java.util.HashSet;
import java.util.Set;

public class HashST<Key, Value> {

    private static class Node {

	private Object key;
	private Object value;
	private Node next;

	public Node(Object key, Object value, Node next) {
	    this.key = key;
	    this.value = value;
	    this.next = next;
	}

    }

    // instance variables
    private int m; // # of buckets
    private Node[] buckets;
    private HashSet<Key> keys;

    public HashST(int capacity) {
	m = capacity;
	buckets = new Node[m];
	keys = new HashSet<Key>();
    }

    public int size() {
	return keys.size();
    }

    public int hash(Object key) {
	return Math.abs(key.hashCode()) % m;
    }

    // returns true if key is within the symbol table
    public boolean containsKey(Key key) {
	return keys.contains(key);
    }

    // returns a set of the keys
    public Set<Key> getKeys() {
	return keys;
    }

    // returns the Node that holds the key,value pair
    // null is returned if not found
    private Node getNode(Key key) {
	if (!containsKey(key))
	    return null;
	int i = hash(key);
	Node p = buckets[i];
	while (!p.key.equals(key))
	    p = p.next;
	return p;
    }

    // returns the value associated with the given key
    // null is returned if key not found
    public Value get(Key key) {
	Node x = getNode(key);
	if (x == null)
	    return null;
	return (Value) x.value;
    }

    // puts the new key, value pair into the map and returns
    // the replaced value. If the key,value pair is a new entry
    // null is returned and keys is updated
    public Value put(Key key, Value value) {
	Node x = getNode(key);
	if (x == null) {
	    int i = hash(key);
	    buckets[i] = new Node(key, value, buckets[i]);
	    keys.add(key);
	    return null;
	}
	Value old = (Value) x.value;
	x.value = value;
	return old;
    }

    public Value remove(Key key) {
	if (!keys.contains(key))
	    return null;
	Node p = buckets[hash(key)];
	Node q = null;
	while (!p.key.equals(key)) {
	    q = p;
	    p = p.next;
	}
	if (q == null)
	    buckets[hash(key)] = p.next;
	else
	    q.next = p.next;
	p.next = null;
	Value ans = (Value) p.value;
	keys.remove(key);
	return ans;
    }

    // prints current state of the hash table
    public void printTable() {
	for (int i = 0; i < m; i++) {
	    System.out.print("[" + i + "] : ");
	    for (Node p = buckets[i]; p != null; p = p.next) {
		System.out.print(p.key + " : " + p.value + " ");
	    }
	    System.out.println();
	}
    }

    public String toString() {
	String ans = "{";
	for (Key key : keys) {
	    ans += "[" + key + "=" + get(key) + "],";
	}
	if (size() > 0)
	    ans = ans.substring(0, ans.length() - 1);
	ans += "}";
	return ans;
    }

    public static void main(String[] args) {
	HashST<String, Integer> d = new HashST<String, Integer>(5);
	d.printTable();
	System.out.println(d);
	for (String s : args) {
	    if (!d.containsKey(s))
		d.put(s, 1);
	    else
		d.put(s, d.get(s) + 1);
	}
	System.out.println("Keys: " + d.getKeys());
	System.out.println();
	d.printTable();
	System.out.println(d);
    }

}
