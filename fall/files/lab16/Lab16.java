import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Lab16{

    public static void main(String [] args){
	new Lab16().run();
    }

    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in), "Input file: ");
	count(rd);
    }

    private void count(BufferedReader rd){
	int chars = 0, words = 0, lines = 0;
	try{
	    while(true){
		String line = rd.readLine();
		if (line == null) break;
	        chars += line.length();
		words += line.split(" ").length;
		lines++;
	    }
	}catch(IOException ex){
	    throw new RuntimeException(ex.toString());
	}
	int spacing = Integer.toString(chars).length() + 1;
	String format = "%s: %" + spacing + "d%n";
	System.out.printf(format,"Chars",chars);
	System.out.printf(format,"Words",words);
	System.out.printf(format,"Lines",lines);
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
