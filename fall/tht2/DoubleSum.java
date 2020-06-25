package doublesum;

/* 
   David Goldshteyn and Kazi Jamal Period 1
   Instructions to run code:
    javac DoubleSum.java
    java DoublerSum n1 n2 n3 ... n
    (where n1, n2, n3, etc. are command-line double arguments)
   Output:
    Sum of double command line arguments
*/
public class DoubleSum {

    public static void main(String[] args) {
        
        double sum = 0;
        for (int i = 0; i < args.length; i++)
            sum += Double.parseDouble(args [i]);
        
    System.out.println("The sum is: " + sum);
    
    }
}

// This program prints the sum of any number of double command line arguments.
// Run the program with any number of double arguments, and only double or int arguments.