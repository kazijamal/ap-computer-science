public class Leprechaun implements Comparable{

    private int g_i;
    private double x_i;

    public Leprechaun() {
	g_i = 0;
	x_i = 0.0;
    }

    public int getGold() {
	return g_i;
    }

    public double getPos() {
	return x_i;
    }

    public void setGold(int g) {
	g_i = g;
    }

    public void newPos() {
	double r = Math.random() * 2 - 1;
	x_i += r * g_i;
    }

    public int compareTo(Leprechaun x) {
	if (x.getPos() < x_i);

}
