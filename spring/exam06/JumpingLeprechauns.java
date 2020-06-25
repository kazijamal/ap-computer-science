
// STEALS FROM ONLY ONE CLOSEST
// USE HIGHERENTRY AND LOWERENTRY METHODS TO GET NEAREST LEPRECHAUNS

import java.util.Map;
import java.util.TreeMap;

public class JumpingLeprechauns {

    public static void init(int n) {
    }

    public static void iterate() {
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int i = Integer.parseInt(args[1]);
        init(n);
        for (int x = 1; x <= i; x++) {
            System.out.println("Iteration " + x);
            iterate();
            for (int l = 1; l <= n; l++) {
                System.out.print("leprechaun " + l + "\t");
                System.out.print("gold: " + gold[l] + "\t");
                System.out.print("horizon position: " + horizonPos[l] + "\n");
            }
            System.out.println();
            System.out.println(map);
        }
    }

}
