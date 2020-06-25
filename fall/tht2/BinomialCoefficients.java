package binomialcoefficients;

/* 
   David Goldshteyn and Kazi Jamal Period 1
   Instructions to run code:
    javac BinomialCoefficients.java
    java BinomialCoefficients n
    the argument n is the number of the binomial distribution rows printed
   Output:
    1.0
    0.5  0.5
    0.25  0.5  0.25
    ...<continued for n complete rows>
*/

public class BinomialCoefficients{

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	new BinomialCoefficients().run(n);
    }

    public void run(int n){
	print(ragged(n));
    }

    public double[][] ragged(int n){
	double[][] a = new double[n+1][];
	a[0] = new double[1];
	a[1] = new double[3];
	a[1][1] = 1;
	for (int i = 2; i <= n; i++){
	    a[i] = new double[i+2];
	    for (int j = 1; j < a[i].length -1; j++)
		a[i][j] = (a[i-1][j] + a[i-1][j-1]) / 2.0;
	}
	return a;
    }

    public void print(double[][] a){
	for (int i = 1; i < a.length; i++) { 
	    for (int j = 1; j < a[i].length-1; j++){
		System.out.print(a[i][j] + "  ");
	    }
	    System.out.println();
	}
    }

}
	
		
