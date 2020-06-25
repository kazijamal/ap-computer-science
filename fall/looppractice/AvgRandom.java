public class AvgRandom{

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	int numterm = 0;
	double sum = 0.0;
	for (int i = 1; i <= n; i++){
	    double random = Math.random();
	    numterm++;
	    sum += random;
	    System.out.println("term " + numterm + "\t" + random);
	}
	double mean = sum / numterm;
	System.out.println("mean\t" + mean);
    }

}
