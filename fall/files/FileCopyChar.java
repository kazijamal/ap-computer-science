import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class FileCopyChar{

    public static void main(String [] args){
	new FileCopyChar().run();
    }

    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in), "Enter a file:");
	PrintWriter wr = openFileWriter(new Scanner(System.in), "Enter name of copy:");
        copyFileCharByChar(rd,wr);
    }

    private void copyFileCharByChar(BufferedReader rd, PrintWriter wr){
	try{
	    while (true){
		int ch = rd.read();
		if (ch < 0){
		    rd.close();
		    wr.close();
		    break;
		}
		wr.write(ch);
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
