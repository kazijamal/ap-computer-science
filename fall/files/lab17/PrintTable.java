import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintTable{

    public static void main(String [] args){
	new PrintTable().run();
    }

    public void run(){
	System.out.println("State                | Abbreviation  |    Code     ");
	System.out.println("---------------------+---------------+-------------");
	try{
	    BufferedReader rd = new BufferedReader(new FileReader("codes.csv"));
	    while (true){
		String line = rd.readLine();
		if (line == null) break;
		Scanner scanner = new Scanner(line);
		scanner.useDelimiter(",");
		String state = scanner.next();
		String abbr = scanner.next();
		int code = scanner.nextInt();
		System.out.printf("%-21s|", state);
		System.out.printf("%15s|", abbr);
		System.out.printf("%13d", code);
		System.out.println();
	    }
	    rd.close();
	}catch(IOException ex){
	    throw new RuntimeException(ex.toString());
	}
    }

}
