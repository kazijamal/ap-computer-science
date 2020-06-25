import java.util.Scanner;

public class MedianOf5{

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter an integer: ");
	int i1 = sys.nextInt();
	System.out.print("enter a different integer: ");
	int i2 = sys.nextInt();
	System.out.print("enter a different integer: ");
	int i3 = sys.nextInt();
        System.out.print("enter a different integer: ");
	int i4 = sys.nextInt();
	System.out.print("enter a different integer: ");
	int i5 = sys.nextInt();
	int sd1 = Math.abs(i2 - i1) +  Math.abs(i3 - i1) + Math.abs(i4 - i1) + Math.abs(i5 - i1);
	int sd2 = Math.abs(i1 - i2) +  Math.abs(i3 - i2) + Math.abs(i4 - i2) + Math.abs(i5 - i2);
	int sd3 = Math.abs(i1 - i3) +  Math.abs(i2 - i3) + Math.abs(i4 - i3) + Math.abs(i5 - i3);
	int sd4 = Math.abs(i1 - i4) +  Math.abs(i2 - i4) + Math.abs(i3 - i4) + Math.abs(i5 - i4);
	int sd5 = Math.abs(i1 - i5) +  Math.abs(i2 - i5) + Math.abs(i3 - i5) + Math.abs(i3 - i5);
	int sd = sd1;
	int med = i1;
	if (sd2 < sd){
	    sd = sd2;
	    med = i2;
	}
	if (sd3 < sd){
	    sd = sd3;
	    med = i3;
	}
	if (sd4 < sd){
	    sd = sd4;
	    med = i4;
	}
	if (sd5 < sd){
	    sd = sd5;
	    med = i5;
	}
	System.out.println("the median is: " + med);
    }

    public static void main(String [] args){
	new MedianOf5().run();
    }

}
	    
	    
	
