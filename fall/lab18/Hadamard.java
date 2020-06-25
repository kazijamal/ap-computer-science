public class Hadamard{

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	new Hadamard().run(n);
    }

    public void run(int n){
	H(n);
	System.out.println();
	h(n);
    }
    
    // prints in row major form
    private void printMatrix(boolean[][] m){
	for (int row = 0 ; row < m.length; row++){
	    for (int col = 0; col < m[row].length; col++){
		System.out.printf("%10b" , m[row][col] );
	    }
	    System.out.println();
	}
    }

    private void H(int n){
	boolean[][] matrix = new boolean[n][n];
	matrix[0][0] = true;
	for (int x = 2; x <= n; x *= 2){
	    for (int row = 0; row < n; row++){
		for (int col = 0; col < n; col++){
		    if ((row >= x/2) || (col >= x/2) || (row < x/2 && col >= x/2)){
			if (row >= x/2 && col >= x/2)
			    matrix[row][col] = !(matrix[row%(x/2)][col%(x/2)]);
			else
			    matrix[row][col] = matrix[row%(x/2)][col%(x/2)];
		    }
		}
	    }
	}
	printMatrix(matrix);
    }

    private void h(int n){
	boolean[][] matrix = new boolean[n][n];
	matrix[0][0] = true;
	for (int x = 1; x < n; x *= 2){
	    for (int i = 0; i < x; i++){
		for (int j = 0; j < x; j++){
		    matrix[i+x][j] = matrix[i][j];
		    matrix[i][j+x] = matrix[i][j];
		    matrix[i+x][j+x] = !(matrix[i][j]);
		}
	    }
	}
	printMatrix(matrix);
    }

}
