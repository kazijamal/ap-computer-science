public class Lab07{

    public static boolean isPerfect(int n){
	int sum = 0;
	for (int i = 1; i < n; i++){
	    if (n % i == 0)
		sum += i;
	}
	return sum == n;
    }

    public static boolean isPrime(int n){
	if (n == 1) return false;
	for (int i = 2; i < n; i++){
	    if (n % i == 0)
		return false;
	}
	return true;
    }

    public static double sqrt1(double x){
        double g = x/2;
	while (g != x/g)
	    g = (g + x/g) / 2;
	return g;
    }

    public static double sqrt2helper(double x, double g){
	double ng = (g + x/g) / 2;
	if (ng == g || ng == x/g) return ng;
	return sqrt2helper(x, ng);
    }
    
    public static double sqrt2(double x){
	double g = x/2;
	return sqrt2helper(x,g);
    }
    
    public static void main(String[] args){
	System.out.println("Perfect Numbers in the Range 1 to 9999");
        for (int i = 1; i < 9999; i++){
	    if (isPerfect(i))
		System.out.println(i);
	}
	System.out.println("\nPrime Numbers in the Range 1 to 100");
	for (int i = 1; i < 100; i++){
	    if (isPrime(i))
		System.out.println(i);
	}
	double x = Double.parseDouble(args[0]);
	System.out.println("\n" + sqrt2(x));
    }
}
