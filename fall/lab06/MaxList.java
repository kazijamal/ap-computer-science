import java.util.Scanner;

public class MaxList{

    private static final int SENTINEL = 0;
    public void run(){
	int max = Integer.MIN_VALUE;
	while(true){
	    Scanner sys = new Scanner(System.in);
	    System.out.print("enter an integer, or 0 as a sentinel: ");
	    int value = sys.nextInt();
	    if (value == SENTINEL) break;
	    if (value > max){
		max = value;
	    }
	}
	System.out.println("max: " + max);
    }

    public static void main(String [] args){
	new MaxList().run();
    }

}
