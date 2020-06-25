import java.util.List;

public class IsEvenClient{

    public static void main(String [] args){
	new IsEvenClient().run();
    }

    public void run(){
	List<Integer> list = new IntegerList();
	for (int i = 0; i < 10; i++)
	    list.add((int)(Math.random() * 10));

	System.out.println("Before: " + list);
	list = filter(new IsEven(), list);
	System.out.println("After : " + list);
    }
    
    // Post: Returns an IntegerList containing all the elements that satisfy
    //       the PredicateFunction. NO SIDE EFFECTS ARE PRODUCED.
    public List<Integer> filter(PredicateFunction f, List<Integer> list){
	List<Integer> ans = new IntegerList();
	for (int n : list)
	    if (f.evaluate(n)) ans.add(n);
	return ans;
    }

}
