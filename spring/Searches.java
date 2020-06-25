// Sequential (Linear) Search
// useful for unsorted lists
// brute force search

public class Searches{

    // returns a array with the sequence [0, n).
    public static int[] makeData(int n){
	int[] ans = new int[n];
	for (int i = 0; i < n; i++){
	    ans[i] = i;
	}
	return ans;
    }

    public static void shuffle(int [] data){
	for (int i = 0; i < data.length; i++){
	    int r = (int) (Math.random() * (data.length  - i));
	    int temp = data[r];
	    data[r] = data[i];
	    data[i] = temp;
	}
    }

    public static void print(int[] data){
	for (int x : data)
	    System.out.print(x + " ");
	System.out.println();

    }
    // O(n)
    public static int sequentialSearch(int [] data, int key){
	for (int i = 0; i < data.length; i++){
	    if (data[i] == key) return i;
	}
	return -1;
    }
    
    public static int sequentialSearchR(int[] data, int key){
	return sHelper(data, key, 0);
    }

    // tail recursive; no delayed operation
    private static int sHelper(int[] data, int key, int i){
	if (i >= data.length) return -1;
	if (data[i] == key) return i;
	return sHelper(data, key, ++i);
    }
   
    public static void main(String [] args){
	final int N = 10;
	int [] data = makeData(N); 
	print(data);
	shuffle(data);
	print(data);
	for (int x : data){
	    System.out.println("found " + x + " at index " + sequentialSearch(data,x));
	}
	System.out.println("\nrecursive:");
	for (int x : data){
	    System.out.println("found " + x + " at index " + sequentialSearchR(data,x));
	}
    }
    
}
