import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public NumLineWordChar{

    public static void main(String [] args){
	new NumLineWordChar().run();
    }

    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in), "Enter a file: ");
	count(rd);
    }

    private void count(rd){
	int chars, words, lines = 0;
	try{
	    while(true){
		int ch = rd.read();
		chars++
		if (ch < 0){
		    
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
