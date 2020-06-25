public class DivisorPattern{

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	for (int row = 1; row <= n; row++){
	    String line = "";
	    for (int column = 1; column <= n; column++){
		if ((row % column == 0) || (column % row == 0)){
		    line += "*";
		}
		else{
		    line += " ";
		}
	    }
	    line += row;
	    System.out.println(line);
	}
    }

}
