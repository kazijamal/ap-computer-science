import java.util.Arrays;

public class Anagrams{

    // O(N)
    // StringBuffer is a mutable sequence of characters.
    // A StringBuffer Object is not testable material.
    public static String randomString(int n){
	StringBuffer s = new StringBuffer("");
	for (int i = 0; i < n; i++){
	    int r = 'a' + (int)(Math.random() * ('z' - 'a')); // O(1)
	    s.append((char)r); // O(1)
	}
	// convert the mutable StringBuffer to an immutable String
	return s.toString();
    }

    // O(N)
    public static String shuffle(String s){
	StringBuffer sb = new StringBuffer(s); // O(n)
	int n = s.length();
	for (int i = 0; i < n; i++){
	    int r = (int)(Math.random() * (n - i)) + i; // O(1)
	    char c1 = sb.substring(r,r+1).charAt(0); // O(1)
	    char c2 = sb.substring(i,i+1).charAt(0); // O(1)
	    sb.setCharAt(i,c1);  // O(1) sb is mutable
	    sb.setCharAt(r, c2); // O(1)
	}
	return sb.toString();
    }

    // O(n^2) and not O(nlogN)
    public static boolean isAnagram(String a, String b){
	if (a.length() != b.length())   // O(1)
	    return false; 
	// O(N^2)
	for (int i = 0; i < a.length(); i++){ // O(N)
	    int pos = b.indexOf(a.substring(i,i+1)); // O(N)
	    if (pos == -1) return false;
	    b = b.substring(0,pos) + b.substring(pos + 1); // O(N)
	}
	return true;
    }

    // O(NlogN) and not O(n)
    public static boolean isAnagramV2(String a, String b){
	if (a.length() != b.length()) return false;
	final int N = a.length();
	String [] aArray = new String[N];   // O(N)
	String [] bArray = new String[N];   // O(N)
	// O(N)
	for (int i = 0; i < N; i++){        
	    aArray[i] =  a.substring(i,i+1);    // O(1)
	    bArray[i] =  b.substring(i,i+1);    // O(1)
	}
	Arrays.sort(aArray);       // O(NlogN)
	Arrays.sort(bArray);       // O(NlogN)
	
        for (int i = 0; i < N; i++) // O(N)
	    if (!aArray[i].equals(bArray[i])) return false;
        // Arrays.equals(aArray, bArray);
	return true;
    }

    // O(N)
    public static boolean isAnagramV3(String a, String b){
	if (a.length() != b.length()) return false;
	final int N = a.length();
	int[] count = new int[26];
	for (int i = 0; i < N; i++){
	    count[a.charAt(i) - 'a']++;
	    count[b.charAt(i) - 'a']--;
	}
	for (int i = 0; i < 26; i++){
	    if (count[i] != 0) return false;
	}
	return true;
    }

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	Stopwatch timer = new Stopwatch();
	timer.start();
	String a  = randomString(n);
	timer.stop();
	System.out.println("Creating string time: " + timer.elapsedTime());
	timer.start();
	String b =  shuffle(a);
	timer.stop();
	System.out.println("Creating shuffled string time: " + timer.elapsedTime());
	
	timer.start();
	System.out.println("Version 3: " + isAnagramV3(a,b));
	timer.stop();
	System.out.println("Version 3 time: " + timer.elapsedTime());
	  
	
	timer.start();
	System.out.println("Version 2: " + isAnagramV2(a,b));
	timer.stop();
	System.out.println("Version 2 time: " + timer.elapsedTime());
       
	timer.start();
	System.out.println("Version 1: " + isAnagram(a,b));
	timer.stop();
	System.out.println(" Version 1 time: " + timer.elapsedTime());
   
    }
}
