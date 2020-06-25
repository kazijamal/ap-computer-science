public class Lab03{
    public static void main(String [] args){
	double x = 1.0 / 0.0;
	System.out.println(x); // Infinity
	x = Math.sqrt(-1.0);
	System.out.println(x); // Nan
	x = 1.03 - 0.42;
	System.out.println(x); // 0.6100000000000001
	boolean a = true;
	boolean b = true;
	System.out.println((! (a && b) && (a || b)) || ((a && b) || !(a || b)));
        b = false;
	System.out.println((! (a && b) && (a || b)) || ((a && b) || !(a || b)));
	a = false;
	System.out.println((! (a && b) && (a || b)) || ((a && b) || !(a || b)));
	b = true;
	System.out.println((! (a && b) && (a || b)) || ((a && b) || !(a || b)));
    }

}
