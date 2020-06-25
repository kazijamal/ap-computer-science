public class CoinClient{

    public static void main(String [] args){
	new CoinClient().run();
    }

    public void run(){
	Flippable c = new BiasedCoin(0.2);
	System.out.println(c.flip());
	Coin x = new Coin();
	int xnumH = 0;
	Coin y = new BiasedCoin(0.2);
	int ynumH = 0;
	for (int f = 0; f < 1000; f++){
	    if (x.flip().equals("H")) xnumH++;
	    if (y.flip().equals("H")) ynumH++;
	}
	System.out.println("Probability of heads for 1000 trials of an unbiased coin: " + (xnumH / 1000.0));
	System.out.println("Probability of heads for 1000 trials of a biased coin: " + (ynumH / 1000.0));
    }

}
