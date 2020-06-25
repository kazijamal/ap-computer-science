import java.util.Scanner;

public class ScrabbleScore{

    private int points(String word){
	int pts = 0;
	for (int i = 0; i < word.length(); i++){
	    String ch = word.substring(i,i+1);
	    if ("AEILNORSTU".contains(ch)) pts++;
	    else if ("DG".contains(ch)) pts += 2;
	    else if ("BCMP".contains(ch)) pts += 3;
	    else if ("FHVWY".contains(ch)) pts += 4;
	    else if ("K".equals(ch)) pts += 5;
	    else if ("JX".contains(ch)) pts += 8;
	    else if ("QZ".contains(ch)) pts += 10;
	}
	return pts;
    }

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter a word to find its score: ");
	String word = sys.nextLine();
	System.out.println(points(word) + " points");
    }

    public static void main(String [] args){
	new ScrabbleScore().run();
    }

}
