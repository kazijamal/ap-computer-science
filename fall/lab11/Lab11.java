import java.util.Scanner;

public class Lab11{
	
    private boolean endsWith(String str, String suffix){
	int lenstr = str.length();
	int lensuffix = suffix.length();
	if (lensuffix > lenstr) return false;
	String newstr = str.substring(str.length() - lensuffix);
	return newstr.equals(suffix);
    }

    private int indexOf(String receiver, String sub){
	int lenreceiver = receiver.length();
	int lensub = sub.length();
	for (int i = 0; i <= lenreceiver - lensub; i++){
	    if (receiver.substring(i, lensub + i).equals(sub))
		return i;
	}
	return -1;
    }

    private int indexOf(String receiver, String sub, int fromIndex){
	String newstr = receiver.substring(fromIndex);
	return indexOf(newstr,sub) + fromIndex;
    }

    private boolean contains(String receiver, String sub){
	return receiver.indexOf(sub) != -1;
    }

    private String createOrdinalForm(int n){
	if (n%10 == 1 && n%100 != 11)
	    return n + "st";
	if (n%10 == 2 && n%100 != 12)
	    return n + "nd";
	if (n%10 == 3 && n%100 != 13)
	    return n + "rd";
	else
	    return n + "th";
    }
    
    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter str1: ");
	String str1 = sys.nextLine();
	System.out.print("enter str2: ");
	String str2 = sys.nextLine();
	System.out.print("enter fromIndex: ");
	int fromIndex = sys.nextInt();
	System.out.print("enter n: ");
	int n = sys.nextInt();
	System.out.println("does str1 end with str2: " + endsWith(str1,str2));
	System.out.println("index of str2 in str1: " + indexOf(str1,str2));
	System.out.println("index of str2 in str1 starting fromIndex: " + indexOf(str1,str2,fromIndex));
	System.out.println("does str1 contain str2: " + contains(str1,str2));
	System.out.println("ordinal number of n: " + createOrdinalForm(n));
    }
    

    public static void main(String [] args){
	new Lab11().run();
    }
    
}
