public class RaiseToPower{

    public static int raiseToPower(int n, int k){
	int power = 1;
	while (k > 0){
	    power *= n;
	    k--;
	}
	return power;
    }

    public static double raiseToPower(double n, double k){
	double power = 1;
	while (k > 0){
	    power *= n;
	    k --;
	}
	return power;
    }

    public static long raiseToPower(long n, long k){
	long power = 1;
	while (k > 0){
	    power *= n;
	    k --;
	}
	return power;
    }
    
    public static void main(String[] args){
	long n = Long.parseLong(args[0]);
	long k = Long.parseLong(args[1]);
	System.out.println(raiseToPower(n,k));
    }

}
