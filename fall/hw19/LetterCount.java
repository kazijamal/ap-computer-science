import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LetterCount{

    public static void main(String [] args){
	new LetterCount().run();
    }

    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in), "enter a file: ");
	int [] countArray = new int[26];
	for (int i = 0; i < 26; i++){
	    countArray[i] = 0;
	}
	countLetters(rd, countArray);
	printArray(countArray);
    }

    private int [] createArray(){
	int [] countArray = new int[26];
	for (int i = 0; i < 26; i++){
	    countArray[i] = 0;
	}
	return countArray;
    }

    private void printArray(int [] data){
	char ch = 'a';
	System.out.printf("%-8s%s", "Letter", "Frequency");
	System.out.println();
	for (int i = 0; i < data.length; i++){
	    System.out.printf("%-8c%9d", ch, data[i]);
	    System.out.println();
	    ch++;
	}
    }

    private void countLetters(BufferedReader rd, int [] data){
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	try{
	    while (true){
		String line = rd.readLine();
		if (line == null) break;
		for (int i = 0; i < line.length(); i++){
		    String letter = line.substring(i,i+1).toLowerCase();
		    if (alpha.contains(letter)){
			int index = alpha.indexOf(letter);
			data[index] = ++data[index];
		    }
		}
	    }
	    rd.close();
	}catch(IOException ex){
	    throw new RuntimeException();
	}
    }
    
    private BufferedReader openFileReader(Scanner sysin, String prompt){
	BufferedReader rd = null;
	while (rd == null){
	    try {
		System.out.print (prompt);
		String name = sysin.nextLine();
		rd = new BufferedReader(new FileReader(name));
	    }catch(IOException ex){
		System.out.println("Can't open that file.");
	    }
	}
	return rd;
    }

}
