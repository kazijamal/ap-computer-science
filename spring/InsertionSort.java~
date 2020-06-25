public class InsertionSort{

    public static void insertionSort(int [] data){
	final int N = data.length;
	for (int i = 1; i < N; i++){
	    int og = i;
	    while (i > 0){
		if (data[i] < data[i-1]){
		    int temp = data[i];
		    data[i] = data[i-1];
		    data[i-1] = temp;
		}
		i--;
	    }
	    i = og;
	}
    }

    public static void selectionSort(int [] data){
        final int N = data.length;
        for (int pass = 0; pass < N-1; pass++){
            int minimum = data[pass];
            int minindex = pass;
            for (int i = pass+1; i < N; i++){
                if (data[i] < minimum){
                    minimum = data[i];
                    minindex = i;
                }
            }
            int temp = data[pass];
            data[pass] = data[minindex];
            data[minindex] = temp;
        }
    }

    public static void bubbleShort(int [] data){
        final int N = data.length;
        // N-1 passes
        for (int pass = 1; pass < N; pass++){
            // i in [0,N-pass) => N(N-1)/2 comparisons
            boolean nochange = true;
            for (int i = 0; i < N - pass; i++){
                if (data[i] > data[i+1]){
                    int temp = data[i];
                    data[i] = data[i+1];
                    data[i+1] = temp;
                    nochange = false;
                }
            }
            if (nochange) break;
        }
    }

    public static int[] makeData(int lo, int hi, int n){
        int [] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans [i] = (int) (Math.random() * (hi - lo) ) + lo;
        return ans;
    }

    public static void print(int [] array){
        for (int x : array)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String [] args){
        int lo = Integer.parseInt(args[0]);
        int hi = Integer.parseInt(args[1]);
        final int N = Integer.parseInt(args[2]);
        int [] data = makeData(lo,hi,N);
        System.out.println("Before insertion sort: ");
        print(data);
        insertionSort(data);
        System.out.println("After insertion sort: ");
        print(data);
    }

}
