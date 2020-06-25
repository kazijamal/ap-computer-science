import java.util.Iterator;

public class FindMaxPos {

    public static int findMaxPos(List<Comparable> list) {
	Comparable max = list.get(0);
	int i = 0;
	int iMax = 0;
	for (Comparable c : list) {
	    if (c.compareTo(max) > 0) {
		max = c;
		iMax = i;
	    }
	    i++;
	}
	return iMax;
    }

    public static int findMaxPosItr(List<Comparable> list) {
	Comparable max = list.get(0);
	int i = 0;
	int iMax = 0;
	for (Iterator<Comparable> itr = list.iterator(); itr.hasNext(); i++) {
	    Comparable c = itr.next();
	    if (c.compareTo(max) > 0) {
		max = c;
		iMax = i;
	    }
	}
	return iMax;
    }

    public static void main(String[] args) {
	List<Comparable> l = new LinkedList<Comparable>();
	l.add("test");
	l.add("dog");
	l.add("max");
	l.add("zebra");
	l.add("apple");
	System.out.println("l: " + l);
	System.out.println("findMaxPos(l): " + findMaxPos(l));
	System.out.println("findMaxPosItr(l): " + findMaxPosItr(l));
    }

}
