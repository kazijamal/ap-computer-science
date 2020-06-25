import java.util.Scanner;

public class Lab09{

    public class Cannonball{

	public int cannonball(int h){
	    if (h == 1)
		return 1;
	    return (int) Math.pow(h,2) + cannonball(h-1);
	}

	public void run(){
	    Scanner sys = new Scanner(System.in);
	    System.out.print("enter height: ");
	    int h = sys.nextInt();
	    System.out.println(cannonball(h));
	}

    }

    public static void main(String [] args){
	new Cannonball().run();
    }

}
