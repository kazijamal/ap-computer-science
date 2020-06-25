public class Encryptor{
       
    // private instance variables
    private String[][] myMat;       
   


    //  copies key into  myMat
    public Encryptor(String key){
	String[][] myMat = new String[6][6];
	for (int k = 0; k < 26; k++){
	    for (int i = 0; i < 6; i++){
		for (int j = 0; j < 6; j++){
		    myMat[i][j] = key.substring(k,k+1);
		}
	    }
	}
    }

    // returns an encrypted form of the word
    public String encryptWord(String word){}

    // returns an encrypted form of the pair
    public String encryptTwo(String pair){
	Point a = getCoordinates(pair.substring(0,1));
	Point b = getCoordinates(pair.substring(1,2));
	if (a.getRow() == b.getRow() || a.getCol() == b.getCol()){
	    Point temp = a;
	    a = b;
	    b = temp;
	}
    }

    // returns the coordinates of ch in the 2-dimensional array
    public Point getCoordinates(String ch){
	int ansrow, anscol;
	for (int row = 0; row < 6; row++){
	    for (int col = 0; col < 6; col++){
		if (myMat[row][col].equals(ch)){
		    ansrow = row;
		    anscol = col;
		}
	    }
	}
	return new Point(ansrow, anscol);
    }

    public String toString(){
	String ans = "";
	for (int i = 0; i <  myMat.length; i++){
	    for (int j = 0; j <  myMat[i].length; j++)
		ans +=  myMat[i][j] + " ";
	    ans += "\n";
	}
	return ans;
    }

    public static void main(String [] args){
        String key = "STUVWXYZ0123456789ABCDEFGHIJKLMNOPQR";
	Encryptor en = new Encryptor(key);
	System.out.println(en);
	/*
	  Point p1 = en.getCoordinates("P");
	  Point p2 = en.getCoordinates("8");
	  Point p3 = en.getCoordinates("M");
	  System.out.println("coordinates of P: " + p1);
	  System.out.println("coordinates of 8: " + p2);
	  System.out.println("coordinates of M: " + p3);
	  //  Letters: BR NE ET RE TH PR GG 
	  //Encrypted: FN QB BW QF HT RP GG     
	  String [] pairs = {"BR","NE", "ET", "RE", "TH", "PR", "GG"};
	  for (int i = 0; i < pairs.length; i++)
	  System.out.println(pairs[i] + ": " + en.encryptTwo(pairs[i]));

	  System.out.println(key.encryptWord("COMPUTER"));
	  System.out.println(key.encryptWord("SCIENCE"));
	  System.out.println(key.encryptWord("STUDENTS"));
	*/
    }

}
