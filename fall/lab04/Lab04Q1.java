import java.util.Scanner;

public class Lab04Q1{

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter a temperature in degrees Celsius: ");
	double tempc = sys.nextDouble();
	double tempf = (9.0 / 5.0) * tempc + 32;
	System.out.println(tempf + " degrees Fahrenheit");
	
    }

    public static void main (String [] args){
	new Lab04Q1().run();
	
    }

}
