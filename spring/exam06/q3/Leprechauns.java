import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class JumpingLeprechauns() {

    private static Map<Double, Integer> m;
    private static ArrayList<Leprechaun> l;

    public static void init(int n) {
	Map m = new TreeMap<Double, Integer>();
	l.put(null);
	for (int i = 1; i <= n; i++) {
	    Leprechaun x = new Leprechaun();
	    x.setGold(1000000);
	    x.newPos();
	    l.add(x);
	    m.put(x.getPos(), x.getGold());
	}
	Collections.sort(l);
    }

    public static void iterate() {
	for (int i = 1; i < l.size(); i++) {
	    Leprechaun x = l.get(i);
	    m.remove(x.getPos());
	    x.newPos();
	    l.put(x.getPos(), x.getGold());
	    Collections.sort(l);
	    int n = indexOf(x);
	    Leprechaun left = null;
	    Leprechaun right = null;
	    if (n-1 > 0) {
		left = l.get(n-1);
	    }
	    if (n+1 < l.size()) {
		right = l.get(n+1);
	    }
	    if (left == null && right != null) {
		int rGold = right.getGold();
		x.setGold(x.getGold() + rGold/2);
		right.setGold(rGold - rGold/2);
	    }
	    if (right == null && left != null) {
		int lGold = left.getGold();
		x.setGold(x.getGold() + lGold/2);
		left.setGold(lGold - lGold/2);
	    }
	    else {
		double lDist = Math.abs(left.getPos() - x.getPos());
		double rDist = right.getPos(right.getPos() - x.getPos());
		if (lDist < rDist) {
		    int lGold = left.getGold();
		    x.setGold(x.getGold() + lGold/2);
		    left.setGold(lGold - lGold/2);
		}
		else {
		    int rGold = right.getGold();
		    x.setGold(x.getGold() + rGold/2);
		    right.setGold(rGold - rGold/2);
		}
	    }
	    l.put(x.getPos(), x.getGold());
	}
    }

    public static void main(String[] args) {
	int n = Integer.parseInt(args[0]);
	int i = Integer.parseInt(args[1]);
	init(n);
	for (int j = 0; j < i; j++) {
	    
	}
    }

}
