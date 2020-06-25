import java.util.Scanner;

public class CaesarCipher{

    private String encodeCaesarCipher(String str, int shift){
	String encoded = "";
        for (int i = 0; i < str.length(); i ++){
	    int ascii = (int) str.charAt(i);
	    if (ascii >= 65 && ascii <= 90){
		if (ascii + shift > 90){
		    ascii = (ascii + shift - 90) % 26 + 64;
		}
		else if (ascii + shift < 65){
		    ascii = (65 - ascii + shift) % 26 - 89;
		}
		else ascii += shift;
	    }
	    if (ascii >= 97 && ascii <= 122){
		if (ascii + shift > 122){
		    ascii = (ascii + shift - 122) % 26 + 96;
		}
		else if (ascii + shift < 97){
		    ascii = (97 - ascii + shift) % 26 - 121;
		}
		else ascii += shift;
	    }
	    encoded += (char) ascii;
	}
	return encoded;
    }
			

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("Enter the number of character positions to shift: ");
	int shift = sys.nextInt();
	sys.nextLine();
	System.out.print("Enter a message: ");
	String str = sys.nextLine();
	System.out.println("Encoded message: " + encodeCaesarCipher(str,shift));
    }

    public static void main(String [] args){
	new CaesarCipher().run();
    }

}
