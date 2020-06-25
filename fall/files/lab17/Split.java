import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Split{

    public static void main(String [] args){
	new Split().run();
    }

    public void run(){
	try{
	    BufferedReader rd = new BufferedReader(new FileReader("codes.csv"));
	    PrintWriter wrS = new PrintWriter(new BufferedWriter(new FileWriter("states.txt")));
	    PrintWriter wrA = new PrintWriter(new BufferedWriter (new FileWriter("abbreviations.txt")));
	    PrintWriter wrC = new PrintWriter(new BufferedWriter (new FileWriter("code.txt")));					 
	    while (true){
		String line = rd.readLine();
		if (line == null) break;
		Scanner scanner = new Scanner(line);
		scanner.useDelimiter(",");
		String state = scanner.next();
		String abbr = scanner.next();
		int code = scanner.nextInt();
	        wrS.println(state);
		wrA.println(abbr);
		wrC.println(code);
	    }
	    rd.close();
	    wrS.close();
	    wrA.close();
	    wrC.close();
	}catch(IOException ex){
	    throw new RuntimeException(ex.toString());
	}
    }

}
