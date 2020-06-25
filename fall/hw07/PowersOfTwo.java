public class PowersOfTwo{

    public static void main(String [] args){
	for (int exponent = 0, input = Integer.parseInt(args[0]); exponent <= input; exponent++){
	    int power = 1;
	    for (int n = exponent; n > 0 ; n--){
		power *= 2;
	    }
	    System.out.println(exponent + "\t" + power);
	}
    }

}
