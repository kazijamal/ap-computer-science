public class DigitalRoot{

    public int digitSum(int n){
	if (n < 10)
	    return n;
	return n % 10 + digitSum(n/10);
    }
    
    public int digitalRoot(int n){
	if (digitSum(n) < 10)
	    return digitSum(n);
	return digitalRoot(digitSum(digitSum(n)));
    }

    public void run(int n){
	System.out.println(digitalRoot(n));
    }

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	new DigitalRoot().run(n);
    }

}
