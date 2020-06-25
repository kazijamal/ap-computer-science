import javax.swing.JFileChooser;
import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class CountLines{

    public static void main(String [] args){
	new CountLines().run();
    }

    
    public void run(){
	try{
	    BufferedReader rd = openReader();
	    int numLines = 0;
	    while (true){
		String line = rd.readLine();
		if (line == null) break;
		numLines++;
	    }
	    rd.close();
	    System.out.println ("# lines: " + numLines);
	}catch(IOException ex){
	    throw new RuntimeException (ex.toString());
	}
	
    }


    public BufferedReader openReader() throws IOException{
	File dir = new File(System.getProperty("user.dir"));
	JFileChooser chooser = new JFileChooser(dir);
	int result = chooser.showOpenDialog(null);
	if (result == JFileChooser.APPROVE_OPTION){
	    File file = chooser.getSelectedFile();
	    return new BufferedReader(new FileReader(file));
	}
	return null;
    }
	
}

