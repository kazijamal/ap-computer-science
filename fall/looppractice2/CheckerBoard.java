public class CheckerBoard{

    public static void main(String [] args){
	int N = Integer.parseInt(args[0]);
	for (int i = 1; i <= N; i++){
	    String row = "";
	    if (i % 2 == 0){
		for (int x = 1; x <= N; x++){
		    if (x % 2 == 0){
			row += " ";
		    }
		    else{
			row += "*";
		    }
		}
	    }
	    else{
		for (int x = 1; x <= N; x++){
		    if (x % 2 == 0){
			row += "*";
		    }
		    else{
			row += " ";
		    }
		}
	    }
	    System.out.println(row);
	}
    }

}
