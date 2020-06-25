import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class Censor{

    public static void main(String [] args){
	new Censor().run();
    }
    
    private void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in),
					   "Input File: ");
	PrintWriter wr = openFileWriter(new Scanner(System.in), "Output File: ");
	Scanner sys = new Scanner(System.in);
	System.out.print("Letters to Banish: ");
	String x = sys.nextLine();
        censor(rd, wr, x.toLowerCase());
    }
    
    
    private void censor(BufferedReader rd, PrintWriter wr, String x){
	try{
	    while (true){
		String line = rd.readLine();
		if (line == null) break;
		String nocase = line.toLowerCase();
		String newline = "";
		for (int i = 0; i < line.length(); i++){
		    int print = 0;
		    for (int l = 0; l < x.length(); l++){
			if (nocase.charAt(i) == x.charAt(l)){
			    print = 0;
			    break;
			}
			else print = 1;
		    }
		    if (print == 1){
			newline += line.charAt(i);
		    }
		}
		wr.println(newline);
	    }
	    rd.close();
	    wr.close();
	}catch(IOException ex){
	    throw new RuntimeException(ex.toString());
	}
    }

    private BufferedReader openFileReader(Scanner sys, String prompt){
	BufferedReader rd = null;
	while (rd == null){
	    System.out.print(prompt);
	    String file = sys.nextLine();
	    try{
		rd = new BufferedReader(new FileReader(file));
	    }catch(IOException ex){
		System.out.println("Can't open file.");
	    }
	}
	return rd;
    }
    
    private PrintWriter openFileWriter(Scanner sys, String prompt){
	PrintWriter wr = null;
	while (wr == null){
	    System.out.print(prompt);
	    String file = sys.nextLine();
	    try{
		return new PrintWriter(new BufferedWriter(new FileWriter(file)));
	    }catch(IOException ex){
		throw new RuntimeException(ex.toString());
	    }
	}
	return wr;
    }
    
}
