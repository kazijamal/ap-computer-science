import java.util.Scanner;

public class Fence{

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("# posts: ");
	int numposts = sys.nextInt();
	if (numposts < 0){
	    System.out.println("# posts cannot be negative");
	    System.out.print("# posts: ");
	    numposts = sys.nextInt();
	}
	while(true){
	    if (numposts == 0) break;
	    System.out.print("|");
	    numposts --;
	    if (numposts == 0) break;
	    System.out.print("---");
	}
    }

    public static void main (String [] args){
	new Fence().run();
    }

}
