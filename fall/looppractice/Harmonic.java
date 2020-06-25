public class Harmonic{

    public static void main(String [] args){
	double N = Double.parseDouble(args[0]);
	double sum = 0.0;
	for (int i = 1; i <= N; i++){
	    sum += 1.0/i;
	}
	System.out.println("sum:\t" + sum);
	double approx = Math.log(N) + 0.57721;
	System.out.println("approx:\t" + approx);
    }

}
