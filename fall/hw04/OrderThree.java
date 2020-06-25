import java.util.Scanner;

public class OrderThree{

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter an integer: ");
	int i1 = sys.nextInt();
	System.out.print("enter an integer: ");
	int i2 = sys.nextInt();
	System.out.print("enter an integer: ");
	int i3 = sys.nextInt();
        int min = Math.min(Math.min(i1, i2), i3);
	int max = Math.max(Math.max(i1, i2), i3);
	int mid = 0;
	if ((i1 != min) && (i1 != max)) {
	    mid = i1;
	}
	else if ((i2 != min) && (i2 != max)) {
	    mid = i2;
	}
	else {
	    mid = i3;
	}
       	System.out.println(min + ", " + mid + ", " + max);

    }

    public static void main(String [] args){
	new OrderThree().run();

    }

}
