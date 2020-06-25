public class BakersDozen extends BagelsOrderItem{

    // constructor
    public BakersDozen(double price){
	super(price,13);
    }

    @Override
    public double getCost(){
	return getPrice() * 12;
    }

}
