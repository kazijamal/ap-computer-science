import java.util.Scanner;


public class Combinations{

    // Assume n >= 0 and 0 <= k <= n.
    // A crude version which easily overflows
    // with modest values of n.
    private int combinations(int n, int k){
	return factorial(n) / factorial(n-k) / factorial(k);

    }


    private int combinationsR(int n, int k){
	if (k == 0 || n == k)
	    return 1;
	return combinationsR(n-1,k-1) + combinationsR(n-1,k);
    }


    
    // Assume n >= 0.
    private int factorial(int n){
	int result = 1;
	for (int i = 1; i <= n; i++) result *= i;
	return result;
    }
    
    // Overflows after n = 31
    private int factorialR(int n){
	if (n == 0)
	    return 1;
	return n * factorial(n-1);
    }


    
    public void run(){
	Scanner sys  = new Scanner(System.in); 
	System.out.print("enter n: ");
	int n = sys.nextInt();
	System.out.print("enter k: ");
	int k = sys.nextInt();
	System.out.println("C(" + n + "," + k + "): " + combinationsR(n,k));
    }


    public static void main(String [] args){
	Combinations c = new Combinations();
        c.run();

    }

}

