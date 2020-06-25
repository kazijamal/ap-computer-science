public class GCD{

    public int gcd(int x, int y){
	if (y == 0)
	    return x;
	return gcd(y, x % y);
    }

    public void run(int x, int y){
	System.out.println(gcd(x,y));
    }

    public static void main(String [] args){
	int x = Integer.parseInt(args[0]);
	int y = Integer.parseInt(args[1]);
	new GCD().run(x,y);
    }

}
