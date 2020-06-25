public class Deal{

    public static void main(String [] args){
	int n = Integer.parseInt(args[0]);
	if (n > 10) n = 10;
	new Deal().run(n);
    }

    public void run(int n){
	initDeck();
	shuffle(deck);
	hands(n);
    }
    
    static String[] SUIT = {"Clubs","Diamonds","Hearts","Spades"};
    static String[] RANKS = {"2","3","4","5","6","7","8","9","10","JACK","QUEEN","KING","ACE"};
    String[] deck = new String[52];

    public void initDeck(){
	for (int r = 0; r < RANKS.length; r++){
	    for (int s = 0; s < SUIT.length; s++){
		deck[SUIT.length*r+s] = RANKS[r] + " of " + SUIT[s];
	    }
	}
    }
	    
    public void shuffle(String [] data){
	for (int i = data.length - 1; i > 0; i--){
	    int randindex = (int) (Math.random() * (i+1));
	    String temp = data[i];
	    data[i] = data[randindex];
	    data[randindex] = temp;
	}
    }

    public void hands(int n){
	int c = 0;
	for (int p = 0; p < n; p++){
	    for (int h = 0; h < 5; h++){
		System.out.print(deck[c] + "\t");
		c++;
	    }
	    System.out.println();
	}
    }
    
}
