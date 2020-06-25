public class BinaryHeap {

    public static void print(int[] data) {
        for (int x : data)
            System.out.print(x + " ");
        System.out.println();
    }

    // pre: data != null and both i and j are index positions
    // post: the elements data[i] and data[j] are exchanged.
    public static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // Pre: data != null. data represents a binary tree
    // that is complete up to the last level and
    // the last level is filled from left to right
    // up to a point.
    // Post: returns true if data has heap property
    // false otherwise.
    public static boolean isHeap(int[] data) {
        return isHeapHelper(data, 0);
    }

    // O(N)
    private static boolean isHeapHelper(int[] data, int i) {
        final int N = data.length;
        if (i >= N)
            return true;
        if (data[i] > data[(i - 1) / 2])
            return false;
        return isHeapHelper(data, i + 1);
    }

    // Pre: data != null, 0 <= i < data.length
    // both the left and right subtrees of the node at index i
    // are binary heaps.
    // Post: elements within [i, upper) are a heap
    // O(logN)
    public static void heapify(int[] data, int i, int upper) {
        int left = 2 * i + 1;
        int right = left + 1;
        if (left >= upper) return;
	int maxChildPos = left;
        if (right < upper && data[right] > data[left]) 
	    maxChildPos = right;
	if (data[i] < data[maxChildPos]){
            swap(data, i, maxChildPos);
	    heapify(data, maxChildPos, upper);
	}
    }

    public static void heapify(int[] data, int i){
	heapify(data, i, data.length);
    }

    // O(NlogN) and O(N^2)
    public static void buildHeap(int[] data) {
        int n = data.length;
        for (int p = (n - 2) / 2; p >= 0; p--)
	    heapify(data, p);
    }

    // pre: data != null
    // post: data sorted in ascending order
    // O(logN)
    public static void heapSort(int[] data){
	final int N = data.length;
	buildHeap(data);
	for (int i = 1; i < N; i++){
	    swap(data, 0, N-i); // O(1)
	    // heapify the elements within [0, N-i)
	    // sorted region [N-i, N)
	    heapify(data, 0, N-i); // O(logN)
	}
    }

    public static void main(String[] args) {
        int[] data = { 4, 5, 6, 1, 8, 7 };
        print(data);
        heapSort(data);
        print(data);

    }

}
