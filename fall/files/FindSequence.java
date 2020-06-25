import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class FindSequence{

    public static void main(String [] args){
	new FindSequence().run();
    }

    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in), "Enter a file:");
	Scanner sys = new Scanner(System.in);
	System.out.print("enter a sequence: ");
	String s = sys.nextLine();
        findSequence(rd,s);
    }

    private void findSequence(BufferedReader rd, String s){
	try{
	    int linenum = 0;
	    while (true){
		String line = rd.readLine();
		if (line == null){
		    System.out.println("Not Found");
		    break;
		}
		if (line.indexOf(s) != -1){
		    System.out.println(linenum + ":" + line.indexOf(s));
		    break;
		}
		linenum++;
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
