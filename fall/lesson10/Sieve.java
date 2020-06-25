import java.util.Scanner;

public class Sieve{

    public static void main(String[] args){
	new Sieve().run();
    }

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("Enter an integer: ");
	int n = sys.nextInt();
	listPrimes(n);
    }

    public void listPrimes(int n){
	int[] intArray = new int[n-1];
	for (int i = 0; i < intArray.length; i++)
	    intArray[i] = i + 2;
	for (int x = 2; x < n; x++){
	    for (int i = 0; i < intArray.length; i++){
		if (intArray[i] != x && intArray[i] != 0 && intArray[i] % x == 0)
		    intArray[i] = 0;
	    }
	}
	for (int i = 0; i < intArray.length; i++)
	    if (intArray[i] != 0)
		System.out.println(intArray[i]);
    }

}
