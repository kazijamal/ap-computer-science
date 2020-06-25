import java.util.Scanner;

public class TwentyQuestions {

    public static int search(int lo, int hi){
        if (hi - lo == 1) return lo;
        int m = lo + (hi - lo) / 2;
        System.out.print("Less than " + m + "? ");
        Scanner sys = new Scanner(System.in);
        boolean b = sys.nextBoolean();
        if (b) return search(lo, m);
        else return search(m, hi);
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        int N = (int) Math.pow(2,n);
        System.out.print("Think of a number: ");
        System.out.println("between 0 and " + (N - 1));
        int v = search(0,N);
        System.out.println("Your number is " + v);
    }

}