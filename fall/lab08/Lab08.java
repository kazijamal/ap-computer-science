/* javac Lab08.java
   java Lab08 x n k
   (x is for Q2 computation of e^x, n and k are for Q3 computation of permutation)
*/


public class Lab08{

    public static double picalc(){
	double oldsixthpi = Double.MIN_VALUE;
	double newsixthpi = 0.5;
	for (double i = 1.0; newsixthpi != oldsixthpi; i++){
	    oldsixthpi = newsixthpi;
	    double t1 = 1.0;
	    for (double num = 1.0, den = 2.0, n = 1.0; n <= i; n++){
		t1 *= num/den;
		num += 2;
		den += 2;
	    }
	    newsixthpi += t1 * (1/(2*i+1)) * (Math.pow(0.5, 2*i + 1));
	}
	double pi = newsixthpi * 6;
	return pi;
    }
	      
    private static double factorial(int x){
	double ans = 1;
	for (int i=1; i <= x; i++){
	    ans *= i;
	}
	return ans;
    }

    public static double etox(int x){
	double etox = 0;
	int i = 0;
		while (true) {
		    if (etox == (etox + (Math.pow(x, i)/ factorial(i)))){
			return etox;
		    }
		    etox += Math.pow(x, i)/factorial(i);
		    i++;
		}
    }
    
    public static int permutations(int n, int k){
	int ans = 1;
        for (int i = n; i > n - k; i--){
	    ans *= i;
	}
	return ans;
    }

    public static void main(String[] args){
	System.out.println("actual value of pi: " + Math.PI);
	System.out.println("calculated value of pi: " + picalc());
	int x = Integer.parseInt(args[0]);
	System.out.println("\nactual value of e^x: " + Math.exp(x));
	System.out.println("calculated value of e^x: " + etox(x));
	int n = Integer.parseInt(args[1]);
	int k = Integer.parseInt(args[2]);
	System.out.println("\npermutations: " + permutations(n,k));
    }

}
