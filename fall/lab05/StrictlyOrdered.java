import java.util.Scanner;

public class StrictlyOrdered{

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter a real number: ");
	double x = sys.nextDouble();
	System.out.print("enter a real number: ");
	double y = sys.nextDouble();
	System.out.print("enter a real number: ");
	double z = sys.nextDouble();
	if ((x > y && y > z) || (z > y && y > x)){
	    System.out.println("true");
	}
	else{
	    System.out.println("false");
	}
	    
    }

    public static void main(String [] args){
	new StrictlyOrdered().run();
    }

}
