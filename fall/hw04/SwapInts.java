import java.util.Scanner;

public class SwapInts{
    
    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter an integer: ");
	int x = sys.nextInt();
	System.out.print("enter an integer: ");
	int y = sys.nextInt();
	System.out.println("Before swapping:");
	System.out.println("x = " + x);
	System.out.println("y = " + y);
	int x2 = x;
	x = y;
	y = x2;
	System.out.println("After swapping:");
	System.out.println("x = " + x);
	System.out.println("y = " + y);

    }

    public static void main(String [] args){
	new SwapInts().run();

    }

}
