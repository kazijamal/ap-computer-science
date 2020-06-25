import java.util.Map;
import java.util.TreeMap;

public class JumpingLeprechauns1 {

    private static Map<Integer, Integer> gold;
    private static Map<Integer, Double> horizonPos;

    public static void init(int n) {
        gold = new TreeMap<Integer, Integer>();
        horizonPos = new TreeMap<Integer, Double>();
        for (int i = 1; i <= n; i++) {
            gold.put(i, 1000000);
            horizonPos.put(i, 0.0);
        }
    }

    public static void iterate() {
        for (int i = 1; i <= horizonPos.size(); i++) {
            Double x_i = horizonPos.get(i);
            Integer g_i = gold.get(i);
            float r = (float) Math.random() * 2 - 1;
            x_i += r * g_i;
            horizonPos.put(i, x_i);
            if (gold.get(i-1) != null) {
                int g_left = gold.get(i-1);
                g_i += g_left / 2;
                gold.put(i-1, g_left - (g_left / 2));
            }
            if (gold.get(i+1) != null) {
                int g_right = gold.get(i+1);
                g_i += g_right / 2;
                gold.put(i+1, g_right - (g_right / 2));
            }
            gold.put(i, g_i);
        }
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
                System.out.print("gold: " + gold.get(l) + "\t");
                System.out.print("horizon position: " + horizonPos.get(l) + "\n");
            }
            System.out.println();
        }
    }

}
