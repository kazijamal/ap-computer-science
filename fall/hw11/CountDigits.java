public class CountDigits{

    // Assume n can be negative, zero or positive.
    public static int countDigits(int n){
	if (n == 0) return 1;
	int numdigits = 0;
	while (n != 0){
	    n /= 10;
	    numdigits +=1;
	}
	return numdigits;
    }

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	System.out.println(n + " has " + countDigits(n) + " digit(s)");
    }

}
