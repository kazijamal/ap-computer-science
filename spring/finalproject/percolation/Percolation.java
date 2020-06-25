// full = -1
// open = 0
// closed = 1

public class Percolation {

    private int[][] sys;

    // create N-by-N grid, with all sites blocked
    public Percolation(int N) {
	if (N <= 0)
	    throw new IllegalArgumentException();
	sys = new int[N][N];
	for (int i = 0; i < sys.length; i++) {
	    for (int j = 0; j < sys.length; j++) {
		sys[i][j] = 1;
	    }
	}
    }

    // open site (row i, column j) if it is not open already
    public void open(int i, int j) {
	sys[i][j] = 0;
    }

    // is site (row i, column j) open?
    public boolean isOpen(int i, int j) {
	return (sys[i][j] == 0);
    }

    // is site (row i, column j) full?
    public boolean isFull(int i, int j) {
	if (!isOpen(i, j)) return false;
	while (i != 0) {
	    if (isOpen(i+1,j)) {
		if (isFull(i+1,j)) {
		    sys[i+1][j] = -1;
		    return true;
		}
	    }
	    if (isOpen(i-1,j)) {
		if (isFull(i-1,j)) {
		    sys[i-1][j] = -1;
		    return true;
		}
	    }
	    if (isOpen(i,j+1)) {
		if (isFull(i,j+1)) {
		    sys[i][j+1] = -1;
		    return true;
		}
	    }
	    if (isOpen(i,j-1)) {
		if (isFull(i,j-1)) {
		    sys[i][j-1] = -1;
		    return true;
		}
	    }
	}
	return false;
    }

    // does the system percolate?
    public boolean percolates() {
	for (int j = 0; j < sys.length; j++) {
	    if (isFull(sys.length-1,j)) return true;
	}
	return false;
    }

    public static void main(String[] args) {
	Percolation p = new Percolation(-1);
	for (int i = 0; i < p.sys.length; i++) {
	    for (int j = 0; j < p.sys.length; j++) {
		System.out.print(p.sys[i][j] + " ");
	    }
	    System.out.println();
	}
    }

}
