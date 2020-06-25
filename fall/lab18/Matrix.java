public class Matrix{

    public static void main(String [] args){
	int h = Integer.parseInt(args[0]);
	new Matrix().run(h);
    }

    public void run(int h){
	final int[] [] identity = { {1,0,0},
				    {0,1,0},
				    {0,0,1}};
	System.out.println("3x3 Identity Matrix");
	printMatrix(identity);
	int[][] prod = scalarMult(5,identity);

	System.out.println("Scalar Multiplication 5 x Identity");
	printMatrix(prod);
	System.out.println("3x3 Identity Matrix is unchanged");
	printMatrix(identity);
	int [][] A = {{1,4}, {7,12}, {9,0}};
	int [][] B = {{3,-4}, {11,-10}, {12,4}};
	System.out.println("3 x 2 Matrix A");
	printMatrix(A);
	System.out.println("3 x 2 Matrix B");
	printMatrix(B);
	System.out.println("A + B ");
	printMatrix(addMat(A,B));
	int [][] C = {{1,6},
		      {4,3}};
	int [][] D = {{2,-1},{5, 0}};
	
	System.out.println("Square Matrix C");
	printMatrix(C);
	System.out.println("Square Matrix D");
	printMatrix(D);
	System.out.println("Square Matrix CD");
	printMatrix(multMat(C,D));
	System.out.println("Square Matrix DC");
	printMatrix(multMat(D,C));
	int [][] s1 = {{8,1,6},{3,5,7},{4,9,2}};
	int [][] s2 = {{16,3,2,13},{5,10,11,8},{9,6,7,12},{4,15,14,1}};
	System.out.println(isMagicSquare(s1));
	System.out.println(isMagicSquare(s2));
	System.out.println(isMagicSquare(identity));
	System.out.println(isMagicSquare(A));
	System.out.println(isMagicSquare(B));
	H(h);
    }
    
    int [][] multMat(int[][] a, int [][] b){
	final int N = a.length;
	int [][] ans = new int[N][N];
	for (int i = 0; i < N; i++){
	    for (int j = 0; j < N; j++){
		for (int k = 0; k < N; k++){
		    ans[i][j] += a[i][k] * b[k][j];
		}
	    }
	}
	return ans;
    }

    // Pre  : A and B have the same dimensions
    private int [][] addMat(int[][] a , int[][] b){
	int[][] ans = new int[a.length][a[0].length];
	for (int row = 0 ; row < a.length; row++){
	    for (int col = 0; col < a[row].length; col++){
		ans[row][col] = a[row][col] + b[row][col];
	    }
	}
	return ans;
    }
    // Post : No side effects
    // Post: No side effects
    private int[][] scalarMult(int k , int[][] m){
	int[][] ans = new int[m.length][m[0].length];
	for (int row = 0 ; row < m.length; row++){
	    for (int col = 0; col < m[row].length; col++){
		ans[row][col] = k * m[row][col];
	    }
	}
	return ans;
    }
    // prints in row major form
    private void printMatrix(int[][] m){
	for (int row = 0 ; row < m.length; row++){
	    for (int col = 0; col < m[row].length; col++){
		System.out.printf("%10d" , m[row][col] );
	    }
	    System.out.println();
	}
    }

    private boolean isMagicSquare(int[][] square){
	if (square.length != square[0].length) return false;
	int sum = 0;
	int currsum = 0;
	for (int col = 0; col < square.length; col++)
	    sum += square[0][col];
	for (int row = 0; row < square.length; row++){
	    for (int col = 0; col < square.length; col++)
		currsum += square[row][col];
	    if (currsum != sum) return false;
	    currsum = 0;
	}
	for (int col = 0; col < square.length; col++){
	    for (int row = 0; row < square.length; row++)
		currsum += square[row][col];
	    if (currsum != sum) return false;
	    currsum = 0;
	}
	int row = 0;
	for (int col = 0; col < square.length; col++){
	    currsum += square[row][col];
	    row++;
	}
	if (currsum != sum) return false;
	currsum = 0;
	row = 0;
	for (int col = square.length - 1; col >= 0; col--){
	    currsum += square[row][col];
	    row ++;
	}
	if (currsum != sum) return false;
	return true;
    }

    private void H(int h){
	boolean[][] matrix  = new boolean[h][h];
	for (int row = 0 ; row < matrix.length; row++){
	    for (int col = 0; col < matrix[row].length; col++){
		System.out.printf("%10b" , matrix[row][col] );
	    }
	    System.out.println();
	}
    }
}
	
