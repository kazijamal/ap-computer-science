public class MergeSort{

    // pre: a and b are sorted in ascending order.
    // post: returns an array that contains every element of a an b
    //       in ascending order
    public static int[] merge1(int[] a, int[] b){
	int[] ans = new int[a.length + b.length];
	for (int acount = 0, bcount = 0, i = 0; acount < a.length || bcount < b.length; i++){
	    if (acount == a.length) ans[i] = b[bcount];
	    else if (bcount == b.length) ans[i] = a[acount];
	    else if (a[acount] <= b[bcount]){
		ans[i] = a[acount];
		acount++;
	    }
	    else{
		ans[i] = b[bcount];
		bcount++;
	    }
	}
	return ans;
    }

    public static int[] merge(int[] a, int[] b){
	int n1 = a.length;
	int n2 = b.length;
	int n = n1 + n2;
	int[] ans = new int[n]; // O(N) additional space
	int i = 0, j = 0, k = 0;
	while (k < n){
	    if (i >= n1 || j >= n2) break;
	    if (a[i] < b[j]) ans[k++] = a[i++];
	    else ans[k++] = b[j++];
	}
	return ans;
    }

    public static void mergeSort(int[] data){
	return;
    }

    public static void main(String[] args){
	int[] a = new int[3];
	a[0] = 2;
	a[1] = 6;
	a[2] = 7;
	int[] b = new int[4];
	b[0] = 1;
	b[1] = 3;
	b[2] = 8;
	b[3] = 9;
	for (int x: merge(a,b)){
	    System.out.println(x);
	}
    }

}
