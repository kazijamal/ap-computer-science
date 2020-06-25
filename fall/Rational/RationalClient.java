public class RationalClient{

    public static void main(String [] args){
	new RationalClient().run();
    }

    public void run(){
	Rational r1 = new Rational();
	Rational r2 = new Rational(2);
	Rational r3 = new Rational(2,3);
	Rational r4 = new Rational(4,6);
	Rational r5 = new Rational(3,5);

	System.out.println("r1 : " + r1);
	System.out.println("r2 : " + r2);
	System.out.println("r3 : " + r3);
	System.out.println("r4 : " + r4);
	System.out.println();

	System.out.println(r1 + " + " + r2 + " = " + r1.plus(r2));
	System.out.println(r2 + " + " + r3 + " = " + r2.plus(r3));
	System.out.println(r3 + " + " + r4 + " = " + r3.plus(r4));
	System.out.println(r4 + " + " + r5 + " = " + r4.plus(r5));
	System.out.println();

	System.out.println(r1 + " - " + r2 + " = " + r1.minus(r2));
	System.out.println(r2 + " - " + r3 + " = " + r2.minus(r3));
	System.out.println(r3 + " - " + r4 + " = " + r3.minus(r4));
	System.out.println(r4 + " - " + r5 + " = " + r4.minus(r5));
	System.out.println();
	
	System.out.println(r1 + " * " + r2 + " = " + r1.times(r2));
	System.out.println(r2 + " * " + r3 + " = " + r2.times(r3));
	System.out.println(r3 + " * " + r4 + " = " + r3.times(r4));
	System.out.println(r4 + " * " + r5 + " = " + r4.times(r5));
	System.out.println();
	
	System.out.println(r1 + " / " + r2 + " = " + r1.dividesBy(r2));
	System.out.println(r2 + " / " + r3 + " = " + r2.dividesBy(r3));
	System.out.println(r3 + " / " + r4 + " = " + r3.dividesBy(r4));
	System.out.println(r4 + " / " + r5 + " = " + r4.dividesBy(r5));
	System.out.println();
    }

}
