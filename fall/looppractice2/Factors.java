public class Factors{

    public static void main(String [] args){
	long n = Long.parseLong(args[0]);
	long divisor = 2;
	while (divisor <= n){
	    if (n % divisor == 0){
		System.out.print(divisor + " ");
		n /= divisor;
	    }
	    else divisor++;
	}
        if (n > 1){
	    System.out.print(n);
	}
	System.out.println();
    }

}
