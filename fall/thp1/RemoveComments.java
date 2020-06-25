import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class RemoveComments{

    private String file;
    
    public static void main(String [] args){
	new RemoveComments().run();
    }
    
    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in), "enter a file: ");
	PrintWriter wr = openFileWriter(new Scanner(System.in), "Output File: ");
	removeComments(rd,wr);
    }

    public void removeComments(BufferedReader rd, PrintWriter wr){
	try{
	    while (true){
		String line = rd.readLine();
		if (line == null) break;
		String newline = line.trim();
		if  (newline.length() < 2) wr.println(line);
		else if (newline.substring(0,2).equals("//")) ;
		else if (newline.substring(0,2).equals("/*"))
		    while (!(line.contains("*/"))){
			    line = rd.readLine();
		    }
		else if (newline.substring(newline.length()-2,newline.length()).equals("*/")) ;
		else wr.println(line);
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
	    file = sys.nextLine();
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
