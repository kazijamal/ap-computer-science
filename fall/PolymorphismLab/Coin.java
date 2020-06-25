public class Coin implements Flippable{

    @Override
    public String flip(){
        double p = Math.random();
	return Math.random() < 0.5 ? "H" : "T";
    }

}
