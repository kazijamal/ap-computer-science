import java.util.Scanner;

public class Lab04Q2{

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter a distance in meters: ");
	double distm = sys.nextDouble();
	double disti = distm / 0.0254;
	double distf = disti / 12;
	System.out.println(distf + " feet");
	System.out.println(disti + " inches");
    }

    public static void main (String [] args){
	new Lab04Q2().run();

    }

}
