import java.util.Scanner;

public class AllEqual{

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter an integer: ");
	int int1 = sys.nextInt();
	System.out.print("enter an integer: ");
	int int2 = sys.nextInt();
	System.out.print("enter an integer: ");
	int int3 = sys.nextInt();
	if (int1 == int2 && int2 == int3){
	    System.out.println("equal");
	}
	else{
	    System.out.println("not equal");
	}
    }

    public static void main(String [] args){
	new AllEqual().run();
    }

}
    
		
