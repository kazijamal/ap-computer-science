import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileCopy{

    public static void main(String [] args){
	new FindSequence().run();
    }

    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in), "Enter a file:");
	try{
	PrintWriter wr = new PrintWriter(new BufferedWriter(new FileWriter("Copy.txt")));
	}catch(IOException ex){
	    throw new RuntimeException(ex.toString());
	}
        copyFileLineByLine(rd,wr);
    }

    private void copyFileCharByChar(BufferedReader rd, PrintWriter wr){
	try{
	    while (true){
		if (line == null) break;
		wr.write(rd.read());
	    }
	}catch(IOException ex){
	    throw new RuntimeException(ex.toString());
	}
    }
    
    private void copyFileLineByLine(BufferedReader rd, PrintWriter wr){
	try{
	    while (true){
		String line = rd.readLine();
		if (line == null) break;
		wr.println(line);
	    }
	}catch(IOException ex){
	    throw new RuntimeException(ex.toString());
	}
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
