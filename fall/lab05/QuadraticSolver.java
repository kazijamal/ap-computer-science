import java.util.Scanner;

public class QuadraticSolver{

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter the coefficient of a polynomial, a: ");
	double a = sys.nextDouble();
	System.out.print("enter the coefficient of a polynomial, b: ");
	double b = sys.nextDouble();
	System.out.print("enter the coefficient of a polynomial, c: ");
	double c = sys.nextDouble();
	if (a == 0){
	    double r1 = (0 - c) / b;
	    System.out.println("the root is: " + r1);
	}
	else if ((b * b - 4 * a * c) < 0){
	    System.out.println("the discriminant is negative, therefore the polynomial has no real roots");
	}
	else{
	    double r1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
	    double r2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
	    System.out.println("the roots are: " + r1 + " and " + r2);
	}
    }

    public static void main(String [] args){
	new QuadraticSolver().run();
    }

}
