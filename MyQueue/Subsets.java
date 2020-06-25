import java.util.ArrayList;

// How to run: $java Subsets 3
// Here is code to complete question 2. 
// It uses a queue of ArrayLists.  
// ArrayLists are AP material.

public class Subsets {

    public static void main(String[] args) {
        ArrayList<Integer> set = new ArrayList<Integer>();
        final int N = Integer.parseInt(args[0]);
        // create a list : [ 0, 1, ..., N-1]
        for (int i = 0; i < N; i++)
            set.add(i);
        System.out.println("set: " + set);
        // Creates a queue of ArrayLists
        MyQueue<ArrayList> q = new ArrayQueue<ArrayList>((int) (Math.pow(2, set.size())));
        // Use a queue to generate all the subsets of a set.
        // In order to make a copy of an ArrayList, use
        // the method clone() -> Object.
        // ex. ArrayList a = q.poll(); a refers to an ArrayList
        // ArrayList b = (ArrayList)a.clone(); b refers to a copy of a
        q.add(new ArrayList<Integer>());
        for (int x : set) {
            for (int n = q.size(); n > 0; n--) {
                ArrayList<Integer> sub = q.remove();
                ArrayList<Integer> newsub = (ArrayList) sub.clone();
                newsub.add(x);
                q.add(sub);
                q.add(newsub);
            }
        }
        System.out.println(q); 

    }

}