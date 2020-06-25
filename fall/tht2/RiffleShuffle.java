package riffleshuffle;

/* 
   David Goldshteyn and Kazi Jamal Period 1
   Instructions to run code:
    javac RiffleShuffle.java
    java RiffleShuffle
    (input n as the int value of how many cards are in the deck, when prompted)
   Output:
    *Original, ordered deck*
    *7 consecutive shuffles of aforementioned deck*
*/
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class RiffleShuffle {

    public static void main(String[] args) {

        new RiffleShuffle().run();

    }

    public void run() {

        Scanner sys = new Scanner(System.in);
        System.out.println("Enter the number of cards in the deck: ");
        int n = sys.nextInt();
        int r = coinFlip(n);
        ArrayList<Integer> original = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            original.add(i);
        }
        System.out.println("The unshuffled deck is: ");
        System.out.println(original + "\n");
        System.out.println("The 7 consecutive shuffled decks of " + n + " cards are: ");
        for (int i = 0; i < 7; i++) {
            original = shuffle(n, r, original);
            System.out.println(original);
        }

    }

    private static int coinFlip(int n) {

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (Math.random() < 0.5) {
                ans += 1;
            }

        }

        return ans;

    }

    private static ArrayList<Integer> shuffle(int n, int r, ArrayList<Integer> original) {

        ArrayList<Integer> n1 = new ArrayList<Integer>();
        ArrayList<Integer> n2 = new ArrayList<Integer>();
        for (int i = 0; i < r; i++) {

            n1.add(original.get(i));

        }

        for (int i = r; i < n; i++) {

            n2.add(original.get(i));

        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!n1.isEmpty() || !n2.isEmpty()) {

            double rand = Math.random();
            if (rand < (n1.size() * 1.0 / (n1.size() * 1.0 + n2.size() * 1.0))) {
                result.add(0, n1.get(n1.size() - 1));
                n1.remove(n1.get(n1.size() - 1));
            } else {
                result.add(0, n2.get(n2.size() - 1));
                n2.remove(n2.get(n2.size() - 1));
            }

        }
//System.out.println(n1 + "\n" + n2);
// debug test
        return result;

    }

}
