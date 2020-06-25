import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileCopyLine{

    public static void main(String [] args){
	new FileCopyLine().run();
    }

    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in), "Enter a file:");
	PrintWriter wr = openFileWriter(new Scanner(System.in), "Enter name of copy:");
        copyFileLineByLine(rd,wr);
    }
    
    private void copyFileLineByLine(BufferedReader rd, PrintWriter wr){
	try{
	    while (true){
		String line = rd.readLine();
		if (line == null){
		    rd.close();
		    wr.close();
		    break;
		}
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

    private PrintWriter openFileWriter(Scanner sysin, String prompt){
	PrintWriter wr = null;
	while (wr == null){
	    try{
		System.out.print(prompt);
		String name = sysin.nextLine();
		wr = new PrintWriter(new BufferedWriter(new FileWriter(name)));
	    }catch(IOException ex){
		System.out.println("Can't write to that file.");
	    }
	}
	return wr;
    }

}
