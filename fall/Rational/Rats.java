import java.util.ArrayList;

public class Rats{

    public static void main(String [] args){
	new Rats().run();
    }
    
    public void run(){
	
	ArrayList<Rational> list = new ArrayList<Rational>();
	Rational a = new Rational(1,2);
	Rational b = new Rational(3,4);
	Rational c = new Rational(1,2);
	list.add(a);
	list.add(b);

	System.out.println( list.contains(a));
        System.out.println( list.contains(b));
	System.out.println( list.contains(c));

	list.add(c);
	list.add(new Rational(6,8));
	list.add(new Rational());
	for (Rational r : list)
	    System.out.println(r + " hashes to " + r.hashCode());
    }

}

