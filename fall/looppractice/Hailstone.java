public class Hailstone{

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	int numterms = 1;
	System.out.println(n);
	while (n != 1){
	    if (n % 2 == 0){
		n /= 2;
	    }
	    else{
		n=3*n+1;
	    }
	    numterms++;
	    System.out.println(n);
	}
	System.out.println("# terms: " + numterms);
    }

}
	
