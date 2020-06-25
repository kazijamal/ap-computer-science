import java.util.Scanner;

public class Lab14{

    private String obenglobish(String str){
	String vowels = "aeiou";
	String ans = "";
	for (int i = 0; i < str.length(); i++){
	    if (vowels.contains(str.substring(i,i+1))){
		if ((i != 0 && vowels.contains(str.substring(i-1,i))) || (i == str.length()-1 && str.charAt(i) == 'e'))
		    ans += str.charAt(i);
		else{
		    ans += "ob" + str.charAt(i);
		}
	    }
	    else{
		ans += str.charAt(i);
	    }
	}
	return ans;
    }

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter a word: ");
	String word = sys.nextLine();
	System.out.println(word + " to obenglobish: " + obenglobish(word));
	System.out.println("english to obenglobish: " + obenglobish("english"));
	System.out.println("hobnob to obenglobish: " + obenglobish("hobnob"));
	System.out.println("gooiest to obenglobish: " + obenglobish("gooiest"));
	System.out.println("amaze to obenglobish: " + obenglobish("amaze"));
	System.out.println("rot to obenglobish: " + obenglobish("rot"));
    }

    public static void main(String [] args){
	new Lab14().run();
    }
    
}
