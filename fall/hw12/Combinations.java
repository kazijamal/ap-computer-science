import java.util.Scanner;

public class Combinations{

    public static void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter number of distinct elements: ");
	int n = sys.nextInt();
	System.out.print("enter number of elements in subsets: ");
	int k = sys.nextInt();
	System.out.println("there are " + combinations(n,k) + " combinations to choose a subset with " + k + " elements of the set containing " + n + " distinct elements");
    }

    private static int factorial(int n){
	int ans = 1;
	for (int i = n; i > 0; i--){
	    ans *= i;
	}
	return ans;
    }

    private static int combinations(int n, int k){
	int ans = factorial(n) / (factorial(n-k) * factorial(k));
	return ans;
    }

    public static void main(String [] args){
	Combinations C = new Combinations();
	C.run();
    }

}
