/* 
   David Goldshteyn and Kazi Jamal Period 1
   Instructions to run code:
    javac CouponCollecter.java
    java CouponCollecter
    (when prompted, enter n as the number of unique values to be collected)
   Output:
    *Expected number of coupons necessary to collect n values (nH(n))*
    *How many coupons were actually required (experimentally)*
    *Approximate percent deviation from expected number of coupons*
*/
package couponcollecter;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

class CouponCollecter {

    public static void main(String[] args) {

        new CouponCollecter().run();

    }

    public void run() {

        Scanner sys = new Scanner(System.in);
        System.out.println("Enter a number of unique values to be collected: ");
        int n = sys.nextInt();
        int har = (int) (harmonic(n) * n);
        System.out.println("The expected number of coupons necessary to collect "
                + n + " unique values is: " + har);
        int result = coupons(n);
        System.out.println("It took " + result + " coupons to collect " + n
                + " unique values");
        System.out.println("The percent deviation from expected is approximately: "
                + ((int) Math.abs((result - har * 1.0) / har * 100.0)) + "%");
    }

    private static double harmonic(int n) {

        double har = 0;
        for (double i = 1.0; i <= n; i++) {
            har += 1.0 / i;
        }
        return har;
    }

    private static int coupons(int n) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        int counter = 0;
        while (list.size() < n) {
            int rand = random.nextInt(n);
            if (!contains(list, rand)) {
                list.add(rand);
            }
            counter += 1;
        }
        return counter;
    }

    private static boolean contains(ArrayList<Integer> list, int rand) {
        boolean check = false;
        for (int x : list) {
            if (x == rand) {
                check = true;
            }
        }
        return check;
    }

}
