public class EuclidsAlgorithm{

    public static int gcd(int x, int y){
	int r = x % y;
	while (r != 0){
	    x = y;
	    y = r;
	    r = x % y;
	}
	return y;
    }

    public static int lcm(int x, int y){
	int lcm = x*y/gcd(x,y);
	return lcm;
    }

    public static int countDigits(int n){
	if (n == 0) return 1;
	int numdigits = 0;
	while (n != 0){
	    n /= 10;
	    numdigits += 1;
	}
	return numdigits;
    }
	
    public static void main(String [] args){
	int x = Integer.parseInt(args[0]);
	int y = Integer.parseInt(args[1]);
	System.out.println(gcd(x,y));
	System.out.println(lcm(x,y));
	System.out.println(countDigits(x));
	System.out.println(countDigits(y));
    }

}
