public class BakeryClient{

    public static void main(String [] args){
	new BakeryClient().run();
    }

    public void run(){
	ShoppingCart cart = new ShoppingCart();
	cart.add(new BagelsOrderItem(0.25, 3));
	cart.add(new BakersDozen(0.35));
	System.out.printf("Total due:  $%.2f", cart.totalDue());
	System.out.println();
    }

}
