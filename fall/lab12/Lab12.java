import java.util.Scanner;

public class Lab12{

    public static String trim(String str){
	int i = 0, j = str.length() - 1;
	while (i <= j && Character.isWhitespace(str.charAt(i))) i++;
	while (j > i  && Character.isWhitespace(str.charAt(j))) j--;
	return str.substring(i,j + 1);
    }

    public static String capitalize(String str){
	if (str.length() == 0) return str;
	return Character.toUpperCase(str.charAt(0)) +
	    str.substring(1).toLowerCase();
    }
    
    private String acronym(String str){
	String[] words = str.split(" ");
	String acronym = "";
	for (String word : words){
	    acronym += Character.toUpperCase(word.charAt(0));
	    for (int i = 0; i < word.length(); i++){
		if (!(Character.isLetter(word.charAt(i))))
		    acronym += Character.toUpperCase(word.charAt(i+1));
	    }
	}
	return acronym;
     }

    private String removeCharacters(String str, String remove){
	String newstr = "";
	for (int i = 0; i < str.length(); i++){
	    if (remove.contains(Character.toString((str.charAt(i)))));
	    else newstr += str.charAt(i);
	}
	return newstr;
    }

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter str1: ");
	String str1 = sys.nextLine();
	System.out.print("enter str2/remove: ");
	String remove = sys.nextLine();
	System.out.println("javatrimmed: " + str1.trim());
	System.out.println("trimmed: " + trim(str1));
	System.out.println("capitalized: " + capitalize(str1));
	System.out.println("acronym: " + acronym(str1));
	System.out.println("removed characters: " + removeCharacters(str1,remove));
    }
    
    public static void main(String [] args){
	new Lab12().run();
    }

}
