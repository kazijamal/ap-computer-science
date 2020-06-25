/* 
   David Goldshteyn and Kazi Jamal Period 1
   Instructions to run code:
    javac SumOfDoubles.java
    java SumOfDoubles d0 d1 d2...
    there can be as many arguments as desired and the arguments should be doubles
   Output:
    The sum is: *sum of the arguments*
*/


public class SumOfDoubles{

    public static void main(String [] args){
	new SumOfDoubles().run(args);
    }

    public void run(String [] args){
	double [] doubleArgs = new double[args.length];
	for (int i = 0; i < args.length; i++){
	    doubleArgs[i] = Double.parseDouble(args[i]);
	}
	System.out.println("The sum is: " + sumOfDoubles(doubleArgs));
    }

    private double sumOfDoubles(double ... args){
	double sum = 0.0;
	for (double d : args){
	    sum += d;
	}
	return sum;
    }

}
