import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class Tabify{

    public static void main(String [] args){
	new Tabify().run();
    }

    private void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in),
					   "Input File: ");
	PrintWriter wr = openFileWriter(new Scanner(System.in), "Output File: ");
	tabify(rd, wr);
    }

    private void tabify(BufferedReader rd, PrintWriter wr){
	try{
	    int count = 0;
	    while(true){
		int x = rd.read();
		if (x == -1) break;
		if (x != '\t'){
		    wr.print((char) x);
		    if (x == '\n') count = 0;
		    else count++;
		}
		else{
		    int y = count;
		    for (int i = 0; i < 8 - y; i++){
			wr.print(" ");
			count++;
		    }
		}
		if (count == 8) count = 0;
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
