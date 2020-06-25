public class TokenScannerClient{

    public static void main(String [] args){
	new TokenScannerClient().run();
    }

    public void run(){
	TokenScanner sc = new TokenScanner("Ok 007, this is a sentence.");
	int t = 0;
	while (sc.hasMoreTokens()){
	    System.out.println("token " + t + " : " + sc.nextToken());
	    t++;
	}
	System.out.println();
	sc.setInput("Ok 007, this is a sentence.");
	System.out.println("avgWordLength: " + avgWordLength("Ok 007, this is a sentence."));
	System.out.println();
	sc.setInput("Ok 007, this is a sentence.");
	sc.ignoreWhitespace();
	t = 0;
	while (sc.hasMoreTokens()){
	    System.out.println("token " + t + " : " + sc.nextToken());
	    t++;
	}
    }

    public double avgWordLength(String line){
	double wordCount = 0.0;
	int letterCount = 0;
	TokenScanner sc = new TokenScanner(line);
	sc.ignoreWhitespace();
	while (sc.hasMoreTokens()){
	    String token = sc.nextToken();
	    if (Character.isLetterOrDigit(token.charAt(0))){
		wordCount++;
		letterCount += token.length();
	    }
	}
	return letterCount / wordCount;
    }
    
}
