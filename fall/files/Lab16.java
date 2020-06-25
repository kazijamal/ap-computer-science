/*
==========================================================================
Exercise
==========================================================================
1. Write a program that reads a file and reports how many lines, words and
   characters appear in it. For the purposes of this program,  a word consists
   of a consecutive sequence of any characters except whitespace characters.
   As an example suppose that the file Lear.txt contains the following passage
   from Shakespeare's King Lear:

    Lear.txt
    --------
    Poor naked wretches, wheresoe'er you are,           (42)
    That bide the pelting of this pitiless storm,       (46)
    How shall your houseless heads and unfed sides,     (48)
    Your loop'd and window'd raggedness, defend you     (48)
    From seasons such as these? 0, I have ta'en         (44)
    Too little care of this!                            (25)

  Your program should be able to generate this following sample run:

  Input file: Lear.txt
  Chars:  254
  Words:   43
  Lines:    6

   The counts in the output should be displayed in a column that is aligned on the
   right but nonetheless expands to fit the data. For example, if you have a
   file containing the full text of George Eliot's "Middlemarch", the output
   of your program should look like this:

   Input file: Middlemarch.txt
   Chars:  1796948
   Words:   316689
   Lines:    34037

  You can download entire books as text files from www.gutenberg.org.

==============================================================================
Selected format codes for the printf method
==============================================================================

 %b    Boolean
 %c    Character
 %d    Decimal
 %f    Floating-point
 %e    Exponential (Scientific Notation)
 %g    General (shorter of %f and %e)
 %n    Newline
 %o    octal
 %s    String
 %x    Hexadecimal
 %%    Percent Sign

Formatting Options
===================
  -     Left Alignment
  +     Explicit plus
  ,     Comma Separation
  0     Zero Fill
  w     Field Width
 .d     Significant digits

*/

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;


public class Lab16{

    private String file;


    public static void main(String [] args){
	new Lab16().run();
    }

    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in), "enter a file: ");
	fileStats(rd);
    }
    private void fileStats(BufferedReader rd){
	try {
	    int numLines = 0, numChars = 0, numWords = 0;
	    while (true){
		String line = rd.readLine();
		if (line == null) break;
		line += "\n";
		numLines++;
		numChars += line.length();
                numWords += countWords(line);
	    }
	    rd.close();
	    PrintWriter wr = new PrintWriter(new BufferedWriter(new FileWriter("stats" + file)));
	    printStats(wr,numChars, numLines, numWords);
	    wr.close();
	}catch(IOException ex){
	    throw new RuntimeException();
	}
    }

    private void printStats(PrintWriter wr,int numChars, int numLines, int numWords){
	int w = Math.max(("" + numChars).length(), Math.max(("" + numLines).length(),
							    ("" + numWords).length()));
	w += 2;
	wr.printf("Input file: %s%n", file);
	wr.printf("%-10s:%" + w + "d%n","Chars", numChars);
	wr.printf("%-10s:%" + w + "d%n","Lines", numLines);
	wr.printf("%-10s:%" + w + "d%n","Words", numWords);

    }


    // a word is a consecutive sequence of non-whitespace characters
    private int countWords(String line){
	int ans = 0;
	for (int i = 1; i < line.length() ; i++){
	    char curr = line.charAt(i);
	    char prev = line.charAt(i-1);
	    if (Character.isWhitespace(curr) && !Character.isWhitespace(prev))
		ans++;
	}
	return ans;
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





}
