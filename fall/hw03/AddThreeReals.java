/*
  Prompt the user for 3 integers,
  store each integer in a variable,
  then compute and display the sum.
*/

// package declaration
package fall.hw03;

// import tools from a java library
import java.util.Scanner;


// A class definition
public class AddThreeReals{

    // a non static method
    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter a real number: ");
	double n1 = sys.nextDouble();
	System.out.print("enter a real number: ");
	double n2 = sys.nextDouble();
	System.out.print("enter a real number: ");
	double n3 = sys.nextDouble();
	double sum = n1 + n2 + n3;
	System.out.println("The sum is " + sum);
	
    }

    // The main method. (boilerplate)
    // A boilerplate is a common pattern.
    public static void main (String [] args){
	new AddThreeReals().run();
	
    }

}
