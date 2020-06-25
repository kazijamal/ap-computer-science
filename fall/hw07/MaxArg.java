public class MaxArg{

    public static void main(String [] args){
	int max = Integer.MIN_VALUE;
	for (String x : args){
	    if (Integer.parseInt(x) > max){
		max = Integer.parseInt(x);
	    }
	}
	System.out.println("Max arg: " + max);
    }

}
