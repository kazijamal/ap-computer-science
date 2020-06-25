// Kazi Jamal and Sunan Tajwar Period 1

public class SortStats {

    public static int[] makeData(int lo, int hi, int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = (int) (Math.random() * (hi - lo)) + lo;
        }
        return ans;
    }

    public static void selectionSort(int[] data) {
        final int N = data.length;
        // N - 1 passes
        for (int pass = 0; pass < N - 1; pass++) {
            int minPos = pass;
            // O(N) a sequential search
            for (int i = pass + 1; i < N; i++) {
                if (data[i] < data[minPos])
                    minPos = i;
            }
            // exactly 1 data exchange on each pass
            int temp = data[pass];
            data[pass] = data[minPos];
            data[minPos] = temp;
        }
    }

    public static void bubbleShort(int[] data) {
        final int N = data.length;
        // N - 1 passes
        for (int pass = 1; pass < N; pass++) {
            boolean exit = true;
            for (int i = 0; i < N - pass; i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                    exit = false; // can't exit early
                }
            }
            if (exit)
                return;
        }
    }

    public static void bubbleSort(int[] data) {
        final int N = data.length;
        // N - 1 passes
        for (int pass = 1; pass < N; pass++) {
            for (int i = 0; i < N - pass; i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;

                }
            }
        }
    }

    public static void insertionSort(int[] data) {
        final int N = data.length;
        for (int i = 1; i < N; i++) {
            int og = i;
            while (i > 0) {
                if (data[i] < data[i - 1]) {
                    int temp = data[i];
                    data[i] = data[i - 1];
                    data[i - 1] = temp;
                }
                i--;
            }
            i = og;
        }
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        System.out.println("Bubble Sort");
        System.out.printf("   %-9s|%15s%n", "N", "Time(sec)");
        System.out.println("----------------------------------");
        for (int n = 10; n <= 1000000; n *= 10) {
            int[] data = makeData(0, 100, n);
            timer.start();
            bubbleSort(data);
            timer.stop();
            double time = (double) timer.elapsedTime() / 1000;
            System.out.printf("%9d   |%15.8f%n", n, time);
        }

        System.out.println("\nBubble Short");
        System.out.printf("   %-9s|%15s%n", "N", "Time(sec)");
        System.out.println("----------------------------------");
        for (int n = 10; n <= 1000000; n *= 10) {
            int[] data = makeData(0, 100, n);
            timer.start();
            bubbleShort(data);
            timer.stop();
            double time = (double) timer.elapsedTime() / 1000;
            System.out.printf("%9d   |%15.8f%n", n, time);
        }

        System.out.println("\nSelection Sort");
        System.out.printf("   %-9s|%15s%n", "N", "Time(sec)");
        System.out.println("----------------------------------");
        for (int n = 10; n <= 1000000; n *= 10) {
            int[] data = makeData(0, 100, n);
            timer.start();
            selectionSort(data);
            timer.stop();
            double time = (double) timer.elapsedTime() / 1000;
            System.out.printf("%9d   |%15.8f%n", n, time);
        }

        System.out.println("\nInsertion Sort");
        System.out.printf("   %-9s|%15s%n", "N", "Time(sec)");
        System.out.println("----------------------------------");
        for (int n = 10; n <= 1000000; n *= 10) {
            int[] data = makeData(0, 100, n);
            timer.start();
            insertionSort(data);
            timer.stop();
            double time = (double) timer.elapsedTime() / 1000;
            System.out.printf("%9d   |%15.8f%n", n, time);
        }
    }

}