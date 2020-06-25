public class TokenScanner{
    
    // private instance variables
    private String input;      // String to scan
    private int cp;            // current position
    private boolean ignoreWhitespaceFlag;


    // default constructor
    public TokenScanner(){
	this("");
    }
    
    // constructor
    public TokenScanner(String input){
	this.input = input;
	cp = 0;
	ignoreWhitespaceFlag = false;
    }


    // resets the input and cp
    public void setInput(String input){
	this.input = input;
	cp = 0;
    }

    // returns true when input contains unprocessed tokens
    public boolean hasMoreTokens(){
	if (ignoreWhitespaceFlag) skipWhitespace();
	return cp < input.length();
    }

     
    public void ignoreWhitespace(){
	ignoreWhitespaceFlag = true;
     }

    // Skips over any whitespace characters before the next token.
    private void skipWhitespace(){
	for (int i = cp; i < input.length(); i++){
	    if (Character.isWhitespace(input.charAt(i))) cp++;
	    else break;
	}
    }

    // Assumes string does not contain a floating point number.
    // Returns the nextToken() if there is no next token then return
    // an empty string.
    public String nextToken(){
	if (ignoreWhitespaceFlag) skipWhitespace();
	else if (Character.isWhitespace(input.charAt(cp)))
	    return Character.toString(input.charAt(cp++));
	if (Character.isLetterOrDigit(input.charAt(cp))){
	    String ans = " ";
	    while (Character.isLetterOrDigit(input.charAt(cp))){
		ans += input.substring(cp,cp+1);
		cp ++;
	    }
	    return ans;
	}
	cp++;
	return input.substring(cp-1,cp);
	// if (hasMoreTokens()){
	//     if (ignoreWhitespaceFlag) skipWhitespace();
	//     int start = cp;
	//     while (cp < input.length()){
	// 	if (Character.isLetterOrDigit(input.charAt(cp))){
	// 	    while (Character.isLetterOrDigit(input.charAt(cp))){
	// 		cp++;
	// 		if (cp >= input.length()) break;
	// 	    }
	// 	    return input.substring(start,cp);
	// 	}
	// 	else if (Character.isWhitespace(input.charAt(cp))){
	// 	    while (Character.isWhitespace(input.charAt(cp))){
	// 		cp++;
	// 		if (cp >= input.length()) break;
	// 	    }
	// 	    return input.substring(start,cp);
	// 	}
	// 	else return Character.toString(input.charAt(cp++));
	//     }
	//     return input.substring(start,cp);
	// }
	// return "";
    }
    
}
