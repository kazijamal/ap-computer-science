public class Matrices{

    public static void main(String [] args){
	new Matrices().run();
    }

    public void run(){
	printMatrice(scalarMult(5,identity));
	System.out.println();
	printMatrice(addMat(a,b));+
    }

    static int[][] identity = { {1,0,0},{0,1,0},{0,0,1} };
    static int[][] a = { {1,3},{4,2} };
    static int[][] b = { {0,4},{1,7} };

    private void printMatrice(int[][] m){
	for (int i = 0; i < m.length; i++){
	    for (int j = 0; j < m[i].length; j++){
		System.out.print(m[i][j] + " ");
	    }
	    System.out.println();
	}
    }
	
    private int[][] scalarMult(int a, int[][] m){
	int[][] ans = new int[m.length][m[0].length];
	for (int r = 0; r < m.length; r++){
	    for (int i = 0; i < m[r].length; i++){
		ans[r][i] = m[r][i] * a;
	    }
	}
	return ans;
    }

    private int[][] addMat(int[][] a, int[][] b){
	int[][] ans = new int[a.length][a[0].length];
	for (int r = 0; r < a.length; r++){
	    for (int i = 0; i < a[r].length; i++){
		ans[r][i] = a[r][i] + b[r][i];
	    }
	}
	return ans;
    }

    //  private int[][] multMat(int[][] a, int[][] b){
   
}
