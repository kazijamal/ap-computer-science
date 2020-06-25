import java.util.Scanner;

public class Lab13{

    private String reverse(String str){
	String reverse = "";
	for (int i = str.length()-1; i >= 0; i--)
	    reverse += str.charAt(i);
	return reverse;
    }

    private String r_reverse(String str){
	if (str.length() == 0) return "";
	return r_reverse(str.substring(1)) + str.charAt(0);
    }

    private String scramble(String str){
	String scrambled = "";
	for (int i = str.length(); i > 0; i--){
	    int r = (int) (Math.random() * str.length());
	    scrambled += str.charAt(r);
	    str = str.substring(0,r) + str.substring(r+1);
	}
	return scrambled;
    }

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter str: ");
	String str = sys.nextLine();
	System.out.println(str + " reverse: " + reverse(str));
	System.out.println(str + " recursive reverse: " + r_reverse(str));
	System.out.println(str + " scrambled: " + scramble(str));
    }

    public static void main(String [] args){
	new Lab13().run();
    }

}
