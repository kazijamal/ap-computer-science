public class BiasedCoin extends Coin{
    
    // instance variable
    private double probH;

    // constructor
    public BiasedCoin(double probH){
	this.probH = probH;
    }

    @Override
    public String flip(){
	double p = Math.random();
	return Math.random() < probH ? "H" : "T";
    }
    
}
