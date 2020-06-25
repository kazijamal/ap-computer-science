public class SelfOrganizingSearch{

    // precondition: data != null
    // postcondition: returns the index position of the first occurrence
    //                of x in data; -1 if not found
    public static int sequentialSearch(int[] data, int x){
	for (int i = 0; i < data.length; i++)
	    if (data[i] == x) return i;
	return -1;
    }
    // F(N) = a(N+1) + b(2N+1)
    // F(N) <= c(3N+2)

    // O(n)
    public static void print(int [] data){
        for (int x: data)
            System.out.print(x + " ");
        System.out.println();
    }

    //precondition: data != null
    //postcondition: returns true if x is found in data
    //               and moves x to the front of the sequence while
    //               all elements to the left of x are shifted
    //               to the right by 1; otherwise return false.
    public static boolean selfOrganizingSearch(int [] data, int x){
	for (int i = 0; i < data.length; i++){
	    if (data[i] == x){
		int pos = i;
		// shift left
		while (pos > 0){
		    data[pos] = data[pos-1];
		    pos--;
		}
		data[0] = x;
		return true;
	    }
	}
	return false;
    }
    
    public static void main(String [] args){
        int[] data = {1,2,3,4,5};
        print(data);   // 1 2 3 4 5
        selfOrganizingSearch(data,5);
        print(data);   // 5 1 2 3 4
        selfOrganizingSearch(data,2);
        print(data);   // 2 5 1 3 4
        selfOrganizingSearch(data,0);
        print(data);   // 2 5 1 3 4
    }

}
