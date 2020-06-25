public class DigitSum{

    public int digitSum(int n){
	if (n < 10)
	    return n;
	return n % 10 + digitSum(n/10);
    }

    public void run(int n){
	System.out.println(digitSum(n));
    }

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	new DigitSum().run(n);
    }

}
