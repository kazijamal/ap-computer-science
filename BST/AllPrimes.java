import java.util.TreeSet;

public class AllPrimes {

    public static TreeSet<Integer> allPrimes(int n) {
	TreeSet<Integer> primes = new TreeSet<Integer>();
	if (n < 2) return primes;
	primes.add(2);
	if (n == 2) return primes;
	for (int i = 3; i <= n; i += 2) { // O(NlogN)
	    boolean isPrime = true;
	    for (Integer x : primes) {
		if (i % x == 0) {
		    isPrime = false;
		    break;
		}
		if (x * x >= i) break;
	    }
	    if (isPrime) primes.add(i); // O(logN)
	}
	return primes;
    }

    public static void main(String[] args){
	int n = Integer.parseInt(args[0]);
	System.out.println(allPrimes(n));
    }

}
