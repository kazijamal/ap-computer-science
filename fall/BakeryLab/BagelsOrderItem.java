public class BagelsOrderItem implements OrderItem{

    // instance variables
    private double price;
    private int quantity;

    // constructor
    public BagelsOrderItem(double price, int quantity){
	this.price = price;
	this.quantity = quantity;
    }
    

    // accessor methods
    @Override
    public double getPrice(){
	return price;
    }

    @Override
    public int getQuantity(){
	return quantity;
    }
    
    @Override
    public double getCost(){
	return price * quantity;
    }

}
