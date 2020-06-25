import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class LongestLine{

    public static void main(String [] args){
	new LongestLine().run();
    }

    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in), "Enter a file:");
	System.out.println("The longest line in the file is: \n" + findLongestLine(rd));
    }

    private String findLongestLine(BufferedReader rd){
	String longest = "";
	try{
	    while (true){
		String line = rd.readLine();
		if (line == null) break;
		if (line.length() > longest.length()) longest = line;
	    }
	}catch(IOException ex){
	    throw new RuntimeException(ex.toString());
	}
	return longest;
    }

    private BufferedReader openFileReader(Scanner sysin, String prompt){
	BufferedReader rd = null;
	while (rd == null){
	    try{
		System.out.print(prompt);
		String name = sysin.nextLine();
		rd = new BufferedReader(new FileReader(name));
	    }catch(IOException ex){
		System.out.println("Can't open that file.");
	    }
	}
	return rd;
    }

}
