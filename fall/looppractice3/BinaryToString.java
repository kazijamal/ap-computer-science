public class BinaryToString{

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	String s = "";
	int reverse = 0;
	while(true){
	    reverse *= 10;
	    reverse += n % 10;
	    n /= 10;
	    if (n == 0) break;
	}
	while(reverse > 0){
	    s += reverse % 10;
	    reverse /= 10;
	}
	System.out.println(s);
    }

}
