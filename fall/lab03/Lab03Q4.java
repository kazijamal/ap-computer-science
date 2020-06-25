import java.util.Scanner;

public class Lab03Q4{

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter a real number: ");
	double t = sys.nextDouble();
	System.out.println(Math.sin(2*t) + Math.sin(3*t));
    }

    public static void main (String [] args){
	new Lab03Q4().run();

    }

}
