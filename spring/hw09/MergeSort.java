public class MergeSort {

    // pre: a and b are sorted in ascending order
    // post: returns an array that contains every element of a and b
    // in ascending order. No side effects are produced.
    // Must be O(N) in both space and time.
    public static int[] merge(int[] a, int[] b) {
	final int N1 = a.length;
	final int N2 = b.length;
	final int N = N1 + N2;
	int[] ans = new int[N]; // O(N) additional space
	int i = 0, j = 0, k = 0;
	// O(N)
	while (k < N) {
	    if (i >= N1 || j >= N2)
		break;
	    // i,j and k are in-bounds
	    if (a[i] < b[j])
		ans[k++] = a[i++];
	    else
		ans[k++] = b[j++];
	}
	while (i < N1)
	    ans[k++] = a[i++];
	while (j < N2)
	    ans[k++] = b[j++];
	return ans;
    }

    // O(logN) runtime
    // O(logN) space (maximum stack height)
    // pre: n >= 1
    // post: returns the floor of the logarithm base 2 of n.
    public static int log(int n) {
	if (n < 2)
	    return 0;
	return 1 + log(n / 2);
    }

    // pre: data != null
    // post: data is sorted in ascending order in O(NlogN) time and space
    public static void mergeSort(int[] data) {
	final int N = data.length;
	int[] aux = new int[N]; // O(N) additional space
	msHelper(data, aux, 0, N); // [O,N)
    }

    // pre: 0 <= lo <= hi <= data.length
    private static void msHelper(int[] data, int[] aux, int lo, int hi) {
	if (hi - lo <= 1)
	    return;
	int m = lo + (hi - lo) / 2;
	msHelper(data, aux, lo, m); // [lo,m)
	msHelper(data, aux, m, hi); // [m,hi)
	merge(data, aux, lo, m, hi);
    }

    // pre: data != null, aux.length = data.length
    // 0 <= lo <= m <= h <= data.length
    // elements within [lo, m) are sorted
    // elements within [m, hi) are sorted
    // post: elements from [lo, hi) are sorted in O(N) time
    public static void merge(int[] data, int[] aux, int lo, int m, int hi) {
	// Step 1: copy elements within the region [lo, hi) from data into aux
	for (int i = lo; i < hi; i++) {
	    aux[i] = data[i];
	}
	// Step 2: merge the copied elements from aux back into data
	// creates left side array from [lo, m)
	// int[] l = new int[m - lo];
	// for (int i = lo; i < m; i++) {
	//     l[i - lo] = aux[i];
	// }
	// // creates right side aray from [m, hi)
	// int[] r = new int[hi - m];
	// for (int i = m; i < hi; i++) {
	//     r[i - m] = aux[i];
	// }
	// // creates merged array from left and right side
	// int[] merged = merge(l, r);
	// // copied elements from the merged array back into data
	// for (int i = lo; i < hi; i++) {
	//     data[i] = merged[i - lo];
	// }
	int c1 = lo, c2 = m, c3 = lo;
	while (c1 < m && c2 < hi){
	    if (aux[c1] <= aux[c2])
		data[c3++] = aux[c1++];
	    else data[c3++] = aux[c2++];
	}
	while (c1 < m)
	    data[c3++] = aux[c1++];
	while (c2 < hi)
	    data[c3++] = aux[c2++];
    }

    public static void main(String[] args) {
	int[] data = new int[7];
	data[0] = 2;
	data[1] = 6;
	data[2] = 7;
	data[3] = 1;
	data[4] = 3;
	data[5] = 8;
	data[6] = 9;
	System.out.println("Before mergeSort: ");
	for (int i : data)
	    System.out.print(i + " ");
	System.out.println("\nAfter mergeSort: ");
	mergeSort(data);
	for (int i : data)
	    System.out.print(i + " ");
	System.out.println();	
    }

}
