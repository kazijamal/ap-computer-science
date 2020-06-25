public final class BarCode{

    // instance variables
    private final int CHECKDIGIT;  // a nonnegative digit
    private final String ZIP;      // a string of digits
    private final String BARCODE;  // a string of full and half bars

    // table for conversion : digit -> string
    final static String [] CODES = { "||:::", ":::||", "::|:|",
				     "::||:",":|::|",":|:|:",":||::",
				     "|:::|", "|::|:", "|:|::"};

    // constructors
    //precondtion: zip.length() = 5 and zip contains only digits.
    //postcondition: throws a runtime exception zip is not the correct length
    //               or zip contains a non digit
    //               
    public BarCode(String zip) {
	if (zip.length() != 5) throw new RuntimeException();
        CHECKDIGIT = zipSum(zip) % 10;
	ZIP = zip;
	BARCODE = toBarcode();
    }

    // postcondition: Creates a copy of a bar code.
    public BarCode(BarCode x){
	this(x.ZIP);
    }


    //post: computes and returns the sum of the  ZIP
    private int zipSum(String zip){
	int ans = 0;
	for (int i = 0; i < zip.length(); i++)
	    ans += Integer.parseInt(zip.substring(i,i+1));
	return ans;
    }

    // post: returns a string representing a barcode
    // if ZIP = "08451" and CHECKDIGIT = 8" then
    // toBarCode() returns "|||:::|::|::|::|:|:|::::|||::|:|"      
    private String toBarcode(){
	String ans = "";
	for (int i = 0; i < ZIP.length(); i++){
	    int digit = (Integer.parseInt(ZIP.substring(i,i+1)));
	    ans += CODES[digit];
	}
	ans += CODES[CHECKDIGIT];
	ans = "|" + ans + "|";
	return ans;
    }


    //postcondition: format zip + check digit + barcode 
    //ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
    public String toString(){
	return ZIP +  CHECKDIGIT + "  " + BARCODE;
    }


    @Override
    public boolean equals(Object other){
	if (!(other instanceof BarCode)) return false;
	BarCode b = (BarCode) other;
	return ZIP.equals(b.ZIP);
    }


    @Override
    public int hashCode(){
	return ZIP.hashCode();
    }

}
