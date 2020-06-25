public class Minesweeper{

    public static void main(String [] args){
	new Minesweeper().run();
    }

    public void run(){
	boolean[][] mineLocations = {{true,false,false,false,false,true},
				     {false,false,false,false,false,true},
				     {true,true,false,true,false,true},
				     {true,false,false,false,false,false},
				     {false,false,true,false,false,false},
				     {false,false,false,false,false,false}};
	printMatrix(countMines(mineLocations));
    }
    
    private void printMatrix(int[][] m){
	for (int row = 0 ; row < m.length; row++){
	    for (int col = 0; col < m[row].length; col++){
		System.out.printf("%10d" , m[row][col] );
	    }
	    System.out.println();
	}
    }

    int[][] countMines(boolean[][] mines){
	int[][] mineCounts = new int[mines.length][mines[0].length];
	for (int i = 0; i < mines.length; i++){
	    for (int j = 0; j < mines[i].length; j++){
		int count = 0;
		for (int a = -1; a <= 1; a++){
		    for (int b = -1; b <= 1; b++){
		        if (!(i + a < 0 || i + a >= mines[i].length || j + b < 0 || j + b >= mines.length)){
			    if (mines[i+a][j+b]) count += 1;
			}
		    }
		}
		mineCounts[i][j] = count;
	    }
	}
	return mineCounts;
    }
    
}
