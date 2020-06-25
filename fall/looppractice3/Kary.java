/* 
   8. Modify Binary to get a program Kary that takes 2 integer command-line
   arguments n and b and converts n to base b. Assume that n is an integer
   in Java's long data type and b is an integer between 2 and 16 (inclusive).
   For bases greater than 10, use the letters A through F to represent the
   11th through 16th digits, respectively.

   $javac Kary.java
   $java Kary n b

*/

public class Kary{

    public static void main(String [] args){
	long n = Long.parseLong(args[0]);
	int b = Integer.parseInt(args[1]);
	int power = 1;
	while (power <= n / b){
	    power *= b;
	}

	while (power > 0){
	    long weight = 0;
	    String letter = "";
	    if (n >= power){
		weight = n / power;
		n -= weight * power;
		switch ((int) weight){
		case 10: letter = "A";
		    break;
		case 11: letter = "B";
		    break;
		case 12: letter = "C";
		    break;
		case 13: letter = "D";
		    break;
		case 14: letter = "E";
		    break;
		case 15: letter = "F";
		    break;
		default: letter = Long.toString(weight);
		}
	    }
	    System.out.print(letter);
	    power /= b;
	}
	System.out.println();
    }

}
