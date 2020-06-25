public class FunctionGrowth{

    public void run(){
	for (double N = 16.0; N <= 2048.0; N *= 2){
	    System.out.println("log N: " + Math.log(N) + "\tN: " + N + "\tN log N: " + (N * Math.log(N)) + "\tN^2: " + Math.pow(N,2) + "\tN^3: " + Math.pow(N,3) + "\t2^N: " + Math.pow(2,N));
	}
    }

    public static void main(String [] args){
	new FunctionGrowth().run();
    }

}
