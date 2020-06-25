// Kazi Jamal and Sunan Tajwar Period 1

public class SearchStats {

    public static int[] makeData(int lo, int hi, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (Math.random() * (hi - lo)) + lo;
        }
        return ans;
    }

    public static void print(int[] array) {
        for (int x : array)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void selectionSort(int[] data) {
        final int N = data.length;
        for (int pass = 0; pass < N - 1; pass++) {
            int minimum = data[pass];
            int minindex = pass;
            for (int i = pass + 1; i < N; i++) {
                if (data[i] < minimum) {
                    minimum = data[i];
                    minindex = i;
                }
            }
            int temp = data[pass];
            data[pass] = data[minindex];
            data[minindex] = temp;
        }
    }

    public static int sequentialSearch(int[] data, int key) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == key)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] data, int key, int lo, int hi) {
        if (lo >= hi)
            return -1;
        int m = lo + (hi - lo) / 2;
        if (data[m] == key)
            return m;
        if (key < data[m]) // [lo,m)
            return binarySearch(data, key, lo, m);
        // [m+1,hi)
        return binarySearch(data, key, m + 1, hi);
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        System.out.println("Search Performance in milliseconds\n");
        System.out.printf("   %-10s| %-10s| %s%n", "N", "Linear", "Binary");
        System.out.println("---------------------------------");
        for (int i = 1, n = 10; n <= 100000; i++) {
            int[] data = makeData(0, n, n);
            int key = (int) (Math.random() * n);
            timer.start();
            sequentialSearch(data, key);
            timer.stop();
            long timeL = timer.elapsedTime();
            selectionSort(data);
            timer.start();
            binarySearch(data, key, 0, n);
            timer.stop();
            long timeB = timer.elapsedTime();
            System.out.printf("%8d     |%8d   |%6d %n", n, timeL, timeB);
            if (i % 2 == 0)
                n *= 2;
            else
                n *= 5;
        }
    }

}