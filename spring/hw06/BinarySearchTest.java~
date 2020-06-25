import java.util.Arrays;

public class BinarySearchTest{

    // pre: data is sorted in ascending order
    //    searching the region [lo, hi)
    // post: Returns -1 if key not found
    //       Returns the index of key
    public static int binarySearch(int[] data, int key, int lo, int hi){
        if (lo >= hi) return -1;
        int m = lo + (hi-lo) / 2;
        if (data[m] == key) return m;
        // [lo, m)
        if (key < data[m]) return binarySearch(data, key, lo, m);
        // [m+1, hi)
        return binarySearch(data, key, m+1, hi);
    }

    public static int binarySearchI(int[] data, int key, int lo, int hi){
        while (lo <= hi){
            int m = lo + (hi - lo) / 2;
            if (data[m] == key) return m;
            // [lo, m]
            if (data[m] > key) hi = m - 1;
            // [m+1, hi)
            else lo = m + 1;
        }
        return -1;
    }

    // pre: data is sorted in ascending order.
    //      Search within the region [lo,hi).
    // post: returns -1 if key not found
    //       returns the minimum index of key
    public static int binarySearchModified(int[] data, int key, int lo, int hi){
        if (lo >= hi) return -1;
        int m = lo + (hi-lo) / 2;
        if (data[m] == key){
            while (data[m-1] == key){
                m--;
            }
            return m;
        }
        // [lo, m)
        if (key < data[m]) return binarySearch(data, key, lo, m);
        // [m+1, hi)
        return binarySearch(data, key, m+1, hi);
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
        print(data);
        Arrays.sort(data);
        print(data);
        System.out.println(binarySearch(data, 5, lo, hi));
        System.out.println(binarySearchI(data, 5, lo, hi));
        System.out.println(binarySearchModified(data, 5, lo, hi));
    }


}