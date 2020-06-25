import java.util.Scanner;

public class LetterSubstitutionCipher{

    private String encodeLetterSubstitutionCipher(String key, String message){
	String encoded = "";
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	if (Character.isUpperCase(key.charAt(0))){
	    message = message.toUpperCase();
	    alpha = alpha.toUpperCase();
	}
	else
	    message = message.toLowerCase();
	for (int i = 0; i < message.length(); i++){
	    if (alpha.contains(message.substring(i,i+1)))
		encoded += key.charAt(alpha.indexOf(message.charAt(i)));
	    else
		encoded += message.charAt(i);
	}
	return encoded;
    }

    private String invertKey(String key){
	String inverted = "0123456789,.;'[]<>-=_+{}:?";
	String alpha = "abcdefghijklmnopqrstuvwxyz";
	if (Character.isUpperCase(key.charAt(0))){
	    alpha = alpha.toUpperCase();
	}
	for (int i = 0; i < key.length(); i++){
	    inverted = inverted.replace(inverted.charAt(alpha.indexOf(key.charAt(i))), alpha.charAt(i));
	}
	return inverted;
    }
	
    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("Enter a 26-letter key : ");
	String key = sys.nextLine();
	System.out.print("Enter a message: ");
	String message = sys.nextLine();
	System.out.println("Encoded message: " + encodeLetterSubstitutionCipher(key, message));
	System.out.println("Inverted key: " + invertKey(key));
	System.out.println("Decoded message: " + encodeLetterSubstitutionCipher(invertKey(key), encodeLetterSubstitutionCipher(key, message)));
    }

    public static void main(String [] args){
	new LetterSubstitutionCipher().run();
    }

}
