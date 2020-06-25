// Sunan Tajwar and Kazi Jamal Period 1

public class CouponCollector{

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	new CouponCollector().run(n);
    }

    private void run(int n){
	System.out.println(collection(n));
    }

    private int collection(int n){
	boolean[] collected = new boolean[n];
	int numcollections = 0;
	int differentcoupons = 0;
	while (differentcoupons < n){
	    int rand = (int) (Math.random() * n);
	    if (!collected[rand]){
		collected[rand] = true;
		differentcoupons++;
	    }
	    numcollections++;
	}
	return numcollections;
    }
	    
}
