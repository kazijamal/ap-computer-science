import java.util.ArrayList;

public class DominoTesting{

    public static void main(String [] args){
	new DominoTesting().run();
    }

    public void run(){
	System.out.println("Display of a full set of dominos\n");
	ArrayList<Domino> dominoes = new ArrayList<Domino>();
	for (int i = 0; i <= 6; i++){
	    for (int j = i; j <= 6; j++){
		dominoes.add(new Domino(i,j));
	    }
	}
	for (Domino d : dominoes){
	    System.out.println(d);
	}
	System.out.println("\nTotal number of dominos: " + dominoes.size());
    }

}
