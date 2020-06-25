import java.util.Scanner;

public class FibonacciWord{

    public String fibonacciWord(int n, String a, String b){
	if (n == 0)
	    return a;
	if (n == 1)
	    return b;
	return fibonacciWord(n-1,a,b) + fibonacciWord(n-2,a,b);
    }

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("How many words: ");
	int n = sys.nextInt();
	sys.nextLine();
	System.out.print("First character: ");
	String a = sys.nextLine();
	System.out.print("Second character: ");
	String b = sys.nextLine();
	for (int i = 0; i < n; i++){
	    System.out.println("f(" + i + ") = \"" + fibonacciWord(i,a,b) + "\"");
	}
    }

    public static void main(String [] args){
	new FibonacciWord().run();
    }

}
